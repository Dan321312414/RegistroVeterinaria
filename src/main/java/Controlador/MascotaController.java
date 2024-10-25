package Controlador;

import Modelo.DatabaseConnection;
import Modelo.Mascota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MascotaController {
    private Connection connection;

    public MascotaController() {
        connection = DatabaseConnection.getConnection();
    }

    
    public boolean crearMascota(Mascota mascota) {
        String sql = "INSERT INTO mascotas (nombre, tipoMascota, raza, colorPelaje, edad, nombreDueno, dniDueno, tipoServicio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, mascota.getNombre());
            stmt.setString(2, mascota.getTipoMascota());
            stmt.setString(3, mascota.getRaza());
            stmt.setString(4, mascota.getColorPelaje());
            stmt.setInt(5, mascota.getEdad());
            stmt.setString(6, mascota.getNombreDueno());
            stmt.setString(7, mascota.getDniDueno());
            stmt.setString(8, mascota.getTipoServicio());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear mascota: " + e.getMessage());
            return false;
        }
    }
    public boolean registrarMascota(Mascota mascota) {
        String sql = "INSERT INTO mascotas (nombre, tipoMascota, raza, colorPelaje, edad, nombreDueno, dniDueno, tipoServicio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
             
            pstmt.setString(1, mascota.getNombre());
            pstmt.setString(2, mascota.getTipoMascota());
            pstmt.setString(3, mascota.getRaza());
            pstmt.setString(4, mascota.getColorPelaje());
            pstmt.setInt(5, mascota.getEdad());
            pstmt.setString(6, mascota.getNombreDueno());
            pstmt.setString(7, mascota.getDniDueno());
            pstmt.setString(8, mascota.getTipoServicio());

            return pstmt.executeUpdate() > 0; 
        } catch (SQLException e) {
            System.out.println("Error al registrar la mascota: " + e.getMessage());
            return false;
        }
    }


 
    public List<Mascota> obtenerMascotas() {
        List<Mascota> listaMascotas = new ArrayList<>();
        String sql = "SELECT * FROM mascotas";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Mascota mascota = new Mascota();
                mascota.setNombre(rs.getString("nombre"));
                mascota.setTipoMascota(rs.getString("tipoMascota"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setColorPelaje(rs.getString("colorPelaje"));
                mascota.setEdad(rs.getInt("edad"));
                mascota.setNombreDueno(rs.getString("nombreDueno"));
                mascota.setDniDueno(rs.getString("dniDueno"));
                mascota.setTipoServicio(rs.getString("tipoServicio"));
                // Puedes añadir las horas de entrada y salida si las necesitas
                listaMascotas.add(mascota);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener mascotas: " + e.getMessage());
        }
        return listaMascotas;
    }

   
    public boolean actualizarMascota(Mascota mascota, int id) {
        String sql = "UPDATE mascotas SET nombre=?, tipoMascota=?, raza=?, colorPelaje=?, edad=?, nombreDueno=?, dniDueno=?, tipoServicio=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, mascota.getNombre());
            stmt.setString(2, mascota.getTipoMascota());
            stmt.setString(3, mascota.getRaza());
            stmt.setString(4, mascota.getColorPelaje());
            stmt.setInt(5, mascota.getEdad());
            stmt.setString(6, mascota.getNombreDueno());
            stmt.setString(7, mascota.getDniDueno());
            stmt.setString(8, mascota.getTipoServicio());
            stmt.setInt(9, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar mascota: " + e.getMessage());
            return false;
        }
    }

   
    public boolean eliminarMascota(int id) {
        String sql = "DELETE FROM mascotas WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar mascota: " + e.getMessage());
            return false;
        }
    }
}
