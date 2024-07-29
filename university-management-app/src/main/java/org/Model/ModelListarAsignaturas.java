package org.Model;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelListarAsignaturas {

    public ArrayList<Object[]> getAsignaturas(){
        ArrayList<Object []> profesores = new ArrayList<>();
        DbConnection conn = new DbConnection();

        try {
            Connection cn = conn.connectDb();

            String sql = "{call getAsignaturas(?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.registerOutParameter(1, OracleTypes.CURSOR);
            callSql.execute();

            ResultSet result = (ResultSet) callSql.getObject(1);

            while(result.next()){
                Object [] item = {result.getString("nombre_asignatura"), result.getLong("creditos")
                        , result.getString("nombre_departamento"), result.getString("nombre_profesor")};
                profesores.add(item);
            }

            return profesores;
        }catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la base de datos al extraer las asignaturas (getAsignaturas): " + e);
        }
    }
}
