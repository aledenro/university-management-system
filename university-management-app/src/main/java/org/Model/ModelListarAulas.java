package org.Model;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelListarAulas {

    public ArrayList<Object[]> getAulas(){
        ArrayList<Object []> aulas = new ArrayList<>();
        DbConnection conn = new DbConnection();

        try {
            Connection cn = conn.connectDb();

            String sql = "{call getAulas(?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.registerOutParameter(1, OracleTypes.CURSOR);
            callSql.execute();

            ResultSet result = (ResultSet) callSql.getObject(1);

            while(result.next()){
                Object [] item = {result.getInt("id_aula"), result.getString("capacidad")};
                aulas.add(item);
            }

            return aulas;
        }catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la base de datos al extraer las aulas (getAulas): " + e);
        }
    }
}
