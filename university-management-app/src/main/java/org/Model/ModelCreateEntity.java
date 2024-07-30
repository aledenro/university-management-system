package org.Model;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelCreateEntity {
    public ModelCreateEntity() {
    }

    public boolean createEstudiante(String nombre, String apellido, String correo, int num_telefono, String cedula){
        DbConnection conn = new DbConnection();
        try {
            Connection cn = conn.connectDb();
            String sql = "{call createEstudiante (?, ?, ?, ?, ?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.setString(1, nombre);
            callSql.setString(2, apellido);
            callSql.setString(3, correo);
            callSql.setInt(4, num_telefono);
            callSql.setString(5, cedula);
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
            throw new RuntimeException("Error al conectarse a la base de datos al agregar estudiantes: " + e);
        }
    }

    public boolean createProfesor(String nombre, String apellido, String correo, int num_telefono, String cedula){
        DbConnection conn = new DbConnection();
        try {
            Connection cn = conn.connectDb();
            String sql = "{call createProfesor (?, ?, ?, ?, ?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.setString(1, nombre);
            callSql.setString(2, apellido);
            callSql.setString(3, correo);
            callSql.setInt(4, num_telefono);
            callSql.setString(5, cedula);
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
            throw new RuntimeException("Error al conectarse a la base de datos al agregar profesores: " + e);
        }
    }

    public boolean createDepartamento(String nombre, String ubicacion){
        DbConnection conn = new DbConnection();
        try {
            Connection cn = conn.connectDb();
            String sql = "{call createDepartamento (?, ?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.setString(1, nombre);
            callSql.setString(2, ubicacion);
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
            throw new RuntimeException("Error al conectarse a la base de datos al agregar departamentos: " + e);
        }
    }

    public boolean createAula(int num_aula, int capacidad){
        DbConnection conn = new DbConnection();
        try {
            Connection cn = conn.connectDb();
            String sql = "{call createAula (?, ?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.setInt(1, num_aula);
            callSql.setInt(2, capacidad);
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
            throw new RuntimeException("Error al conectarse a la base de datos al agregar aula: " + e);
        }
    }

    public boolean createAsignatura(String nombre, int creditos, String nombreDept, int id_profesor){
        DbConnection conn = new DbConnection();
        try {
            Connection cn = conn.connectDb();
            String sql = "{call createAsignatura (?, ?, ?, ?)}";
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
            throw new RuntimeException("Error al conectarse a la base de datos al agregar asignatura: " + e);
        }
    }

    public boolean createGrupo(String nombreAsignatura, int id_profesor){
        DbConnection conn = new DbConnection();
        try {
            Connection cn = conn.connectDb();
            String sql = "{call createGrupo(?, ?)}";
            CallableStatement callSql = cn.prepareCall(sql);
            callSql.setString(1, nombreAsignatura);
            callSql.setInt(2, id_profesor);
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
            throw new RuntimeException("Error al conectarse a la base de datos al agregar grupo: " + e);
        }
    }
}

