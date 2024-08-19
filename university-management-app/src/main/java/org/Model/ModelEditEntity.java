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

    public boolean editAsignatura(String nombre, int creditos, String nombreDept, int id_profesor){
        DbConnection conn = new DbConnection();
        try {
            Connection cn = conn.connectDb();
            String sql = "{call editAsignatura (?, ?, ?, ?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.setString(1, nombre);
            callSql.setInt(2, creditos);
            callSql.setString(3, nombreDept);
            callSql.setInt(4, id_profesor);
            int updatedRows = callSql.executeUpdate();

            if (updatedRows > 0){
                cn.close();
                callSql.close();
                return true;
            }else {
                cn.close();
                callSql.close();
                return false;
            }
        }catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la base de datos al editar asignatura: " + e);
        }
    }

    public boolean editGrupo(int num_grupo, String nombreAsignatura, int id_profesor){
        DbConnection conn = new DbConnection();
        try {
            Connection cn = conn.connectDb();
            String sql = "{call udpateGrupo (?, ?, ?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.setInt(1, num_grupo);
            callSql.setString(2, nombreAsignatura);
            callSql.setInt(3, id_profesor);
            int updatedRows = callSql.executeUpdate();

            if (updatedRows > 0){
                cn.close();
                callSql.close();
                return true;
            }else {
                cn.close();
                callSql.close();
                return false;
            }
        }catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la base de datos al editar grupo: " + e);
        }
    }

    public boolean editHorario(int idHorario, String dia, String horaInicio, String horaTermina, int grupo, int aula){
        DbConnection conn = new DbConnection();
        try {
            Connection cn = conn.connectDb();
            String sql = "{call updateHorario (?, ?, ?, ?, ?, ?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.setInt(1, idHorario);
            callSql.setString(2, dia);
            callSql.setString(3, horaInicio);
            callSql.setString(4, horaTermina);
            callSql.setInt(5, grupo);
            callSql.setInt(6, aula);
            int updatedRows = callSql.executeUpdate();

            if (updatedRows > 0){
                cn.close();
                callSql.close();
                return true;
            }else {
                cn.close();
                callSql.close();
                return false;
            }
        }catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la base de datos al editar horario: " + e);
        }
    }
}
