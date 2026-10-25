package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Ejemplo de actualización del país de una marca existente en la tabla {@code brands}.
 */
public class ActualizarMarca {

    static void main() {
        String nombre = "Nintendo";
        String nuevoPais = "Japón (Kioto)";

        String sql = "UPDATE brands SET country = ? WHERE name = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoPais);
            ps.setString(2, nombre);

            int filas = ps.executeUpdate();
            System.out.println("Filas actualizadas: " + filas);

            if (filas == 0) {
                System.out.println("No se encontró la marca '" + nombre
                        + "'. Ejecuta antes InsertarMarca.");
            } else {
                System.out.println("La marca '" + nombre
                        + "' ahora tiene el país '" + nuevoPais + "'.");
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar la marca: " + e.getMessage());
        }
    }
}
