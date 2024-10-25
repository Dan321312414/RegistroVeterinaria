package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
  private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=VeterinariaDB;encrypt=false";
    private static final String USERNAME = "sa";  
    private static final String PASSWORD = "12345678"; 
    
    private static Connection connection;

    public static Connection getConnection() {
    try {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexión a la base de datos establecida.");
        }
    } catch (SQLException e) {
        System.out.println("Error al establecer la conexión: " + e.getMessage());
    }
    return connection;
}

}
