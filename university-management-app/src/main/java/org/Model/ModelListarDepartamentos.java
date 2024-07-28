package org.Model;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelListarDepartamentos {

    public ArrayList<Object[]> getDepartamentos(){
        ArrayList<Object []> departamentos = new ArrayList<>();
        DbConnection conn = new DbConnection();

        try {
            Connection cn = conn.connectDb();

            String sql = "{call getDepartamentos(?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.registerOutParameter(1, OracleTypes.CURSOR);
            callSql.execute();

            ResultSet result = (ResultSet) callSql.getObject(1);

            while(result.next()){
                Object [] item = {result.getString("nombre"), result.getString("locacion")};
                departamentos.add(item);
            }

            return departamentos;
        }catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la base de datos al extraer los departamentos (getDepartamentos): " + e);
        }
    }
}
