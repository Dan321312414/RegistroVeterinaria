
package com.mycompany.registroveterinaria;


import Modelo.DatabaseConnection;
import Vista.ServicioSeleccion;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author USUARIO
 */
public class RegistroVeterinaria {

    public static void main(String[] args) {
    

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel"); // Cambia a otro tema si prefieres
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("Error al establecer Look and Feel: " + e.getMessage());
        }

    
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            System.out.println("Conexión a la base de datos establecida.");
            new ServicioSeleccion().setVisible(true); // Mostrar la interfaz principal
        } else {
            System.out.println("No se pudo establecer la conexión a la base de datos.");
        }
    }
}