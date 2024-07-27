package org.Model;

import java.sql.*;

public class DbConnection {
    private String dbUrl = "jdbc:oracle:thin:adminBdProyecto/1234@172.210.177.14:1521:orcl";

    public DbConnection() {
    }

    public Connection connectDb() throws SQLException{
            Connection conn = DriverManager.getConnection(dbUrl);
            System.out.println("Conexion exitosa a la BD");
            return conn;
    }
}
