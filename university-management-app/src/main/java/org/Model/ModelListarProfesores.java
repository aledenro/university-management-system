package org.Model;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelListarProfesores {

    public ArrayList<Object[]> getProfesores(){
        ArrayList<Object []> profesores = new ArrayList<>();
        DbConnection conn = new DbConnection();

        try {
            Connection cn = conn.connectDb();

            String sql = "{call getProfesores(?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.registerOutParameter(1, OracleTypes.CURSOR);
            callSql.execute();

            ResultSet result = (ResultSet) callSql.getObject(1);

            while(result.next()){
                Object [] item = {result.getString("cedula"), result.getString("nombre"), result.getString("apellido")
                        , result.getString("email"), result.getLong("num_celular")};
                profesores.add(item);
            }

            return profesores;
        }catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la base de datos al extraer los profesores (getProfesores): " + e);
        }
    }
}
