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
            throw new RuntimeException("Error al conectarse a la base de datos al editar estudiante: " + e);
        }
    }

    public boolean editProfesor(String nombre, String apellido, String correo, int num_telefono, String cedula) {
        DbConnection conn = new DbConnection();
        try {
            Connection cn = conn.connectDb();
            String sql = "{call editProfesor (?, ?, ?, ?, ?)}";
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
            throw new RuntimeException("Error al conectarse a la base de datos al editar profesor: " + e);
        }
    }

    public boolean editDepartamento(String nombre, String ubicacion, int id_departamento) {
        DbConnection conn = new DbConnection();
        try {
            Connection cn = conn.connectDb();
            String sql = "{call editDepartamento (?, ?, ?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.setString(1, nombre);
            callSql.setString(2, ubicacion);
            callSql.setInt(3, id_departamento);
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
            throw new RuntimeException("Error al conectarse a la base de datos al editar departamento: " + e);
        }
    }

    public boolean editAula(int id_aula, int capacidad) {
        DbConnection conn = new DbConnection();
        try {
            Connection cn = conn.connectDb();
            String sql = "{call editAula (?, ?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.setInt(1, id_aula);
            callSql.setInt(2, capacidad);
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
            throw new RuntimeException("Error al conectarse a la base de datos al editar aula: " + e);
        }
    }
}
