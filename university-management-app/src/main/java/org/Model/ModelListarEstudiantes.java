package org.Model;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ModelListarEstudiantes {

    public ArrayList<Object[]> getEstudiantes(){
        ArrayList<Object []> estudiantes = new ArrayList<>();
        DbConnection conn = new DbConnection();

        try {
            Connection cn = conn.connectDb();

            String sql = "{call getEstudiantes(?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.registerOutParameter(1, OracleTypes.CURSOR);
            callSql.execute();

            ResultSet result = (ResultSet) callSql.getObject(1);

            while(result.next()){
                Object [] item = {result.getString("cedula"), result.getString("nombre"), result.getString("apellido")
                        , result.getString("email"), result.getLong("num_celular")};
                estudiantes.add(item);
            }

            return estudiantes;
        }catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la base de datos al extraer los estudiantes (getEstudiantes): " + e);
        }
    }
}
