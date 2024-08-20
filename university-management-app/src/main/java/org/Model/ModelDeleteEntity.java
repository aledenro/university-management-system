package org.Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ModelDeleteEntity {
    public ModelDeleteEntity() {
    }

    public boolean deleteMatricula(int id) {
        DbConnection conn = new DbConnection();
        try {
            Connection cn = conn.connectDb();
            String sql = "{call deleteMatricula (?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.setInt(1, id);
            int updatedRows = callSql.executeUpdate();

            if (updatedRows > 0) {
                cn.close();
                callSql.close();
                return true;
            } else {
                cn.close();
                callSql.close();
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la base de datos al eliminar matricula: " + e);
        }
    }
}
