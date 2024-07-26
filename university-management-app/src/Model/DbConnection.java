package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private String dbUrl = "jdbc:oracle:thin:adminBdProyecto/1234@172.210.177.14:1521:orcl";

    public DbConnection() {
    }

    public Connection connectDb(){
        try {
            Connection conn = DriverManager.getConnection(dbUrl);
            System.out.println("Conexion exitosa a la BD");
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a la BD: " + e);
        }
    }
}
