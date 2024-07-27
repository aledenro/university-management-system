package org.Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ModelEditEntity {
    public ModelEditEntity() {
    }

    public boolean editEstudiante(String nombre, String apellido, String correo, int num_telefono, String cedula) {
        DbConnection conn = new DbConnection();
        try {
            Connection cn = conn.connectDb();
            String sql = "{call editEstudiante (?, ?, ?, ?, ?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.setString(1, nombre);
            callSql.setString(2, apellido);
            callSql.setString(3, correo);
            callSql.setInt(4, num_telefono);
            callSql.setString(5, cedula);
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
            throw new RuntimeException("Error al conectarse a la base de datos al agregar estudiantes: " + e);
        }
    }
}
