package org.Model;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelGetEntity {

    public ModelGetEntity() {
    }

    public Object[] getEstudiante(String cedula){
        DbConnection conn = new DbConnection();

        try {
            Connection cn = conn.connectDb();
            String sql = "{call getEstudiante (?, ?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.setString(1, cedula);
            callSql.registerOutParameter(2, OracleTypes.REF_CURSOR);
            callSql.execute();

            ResultSet result = (ResultSet) callSql.getObject(2);

            if (result.next()){
                Object[] estudiante = {result.getString("cedula"), result.getString("nombre"), result.getString("apellido")
                        , result.getString("email"), result.getLong("num_celular")};
                cn.close();
                callSql.close();
                result.close();
                return estudiante;
            }

            cn.close();
            callSql.close();
            result.close();
            return null;
        }catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la base de datos al revisar si existe el estudiante: " + e);
        }
    }

    public Object[] getProfesor(String cedula){
        DbConnection conn = new DbConnection();

        try {
            Connection cn = conn.connectDb();
            String sql = "{call getProfesor (?, ?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.setString(1, cedula);
            callSql.registerOutParameter(2, OracleTypes.REF_CURSOR);
            callSql.execute();

            ResultSet result = (ResultSet) callSql.getObject(2);

            if (result.next()){
                Object[] profesor = {result.getString("cedula"), result.getString("nombre"), result.getString("apellido")
                        , result.getString("email"), result.getLong("num_celular")};
                cn.close();
                callSql.close();
                result.close();
                return profesor;
            }

            cn.close();
            callSql.close();
            result.close();
            return null;
        }catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la base de datos al revisar si existe el profesor: " + e);
        }
    }

    public Object[] getDepartamento(String nombre){
        DbConnection conn = new DbConnection();

        try {
            Connection cn = conn.connectDb();
            String sql = "{call getDepartamento (?, ?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.setString(1, nombre);
            callSql.registerOutParameter(2, OracleTypes.REF_CURSOR);
            callSql.execute();

            ResultSet result = (ResultSet) callSql.getObject(2);

            if (result.next()){
                Object[] departamento = {result.getString("nombre"), result.getString("locacion"), result.getLong("id_departamento")};
                cn.close();
                callSql.close();
                result.close();
                return departamento;
            }

            cn.close();
            callSql.close();
            result.close();
            return null;
        }catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la base de datos al revisar si existe el departamento: " + e);
        }
    }
}
