package org.Model;

import oracle.jdbc.OracleTypes;

import java.sql.*;

public class ModelLogin {

    private ResultSet result = null;
    private String contrasena = "";
    private String activo = "";

    public ModelLogin() {
    }

    private boolean verifyIfExists(String correo){

        DbConnection conn = new DbConnection();
        try {
            Connection cn = conn.connectDb();

            // llama al sp login y le pasa como parametros el correo ingresado por el usuario y un cursor para poder devolver datos desde el sp
            String sql = "{call login(?, ?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.setString(1, correo);
            callSql.registerOutParameter(2, OracleTypes.CURSOR);

            callSql.execute();

            // extrae del cursor un resultset
            this.result = (ResultSet) callSql.getObject(2);

            // si el result set no esta vacio, extrae la contrasena y si esta activo o no
            if (result.next()){
                this.contrasena = result.getString("contrasena");
                this.activo = result.getString("activo");
                callSql.close();
                result.close();
                cn.close();
                return true;
            }else {
                callSql.close();
                result.close();
                cn.close();
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la base de datos al hacer login: " + e);
        }
    }

    public String loginLogic(String correo, String password){
        boolean existe = verifyIfExists(correo);

        // retorna el string a mostrar en el warning, si todo coincide retorna string vacio
        if(!existe){
            return "No existe un usuario con ese correo electrónico.";
        }else if(!activo.equals("Y")){
            return "El usuario está inactivo, contacte a un administrador.";
        } else if (!contrasena.equals(password)) {
            return "Contraseña incorrecta para el usuario " + correo + ".";
        }else {
            return "";
        }
    }
}
