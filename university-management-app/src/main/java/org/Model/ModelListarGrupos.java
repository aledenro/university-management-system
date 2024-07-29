package org.Model;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelListarGrupos {

    public ArrayList<Object[]> getGrupos(){
        ArrayList<Object []> grupos = new ArrayList<>();
        DbConnection conn = new DbConnection();

        try {
            Connection cn = conn.connectDb();

            String sql = "{call getGruposaledenro@gmail.com (?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.registerOutParameter(1, OracleTypes.CURSOR);
            callSql.execute();

            ResultSet result = (ResultSet) callSql.getObject(1);

            while(result.next()){
                Object [] item = {result.getLong("id_grupo"), result.getLong("num_estudiantes")
                        , result.getString("nombre_asignatura"), result.getString("nombre_profesor")};
                grupos.add(item);
            }

            return grupos;
        }catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la base de datos al extraer las asignaturas (getAsignaturas): " + e);
        }
    }
}
