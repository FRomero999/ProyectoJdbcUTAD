package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Ejemplo de eliminación de una marca de la tabla {@code brands}.
 */
public class EliminarMarca {

    static void main() {
        String nombre = "Nintendo";

        String sql = "DELETE FROM brands WHERE name = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);

            int filas = ps.executeUpdate();
            System.out.println("Filas eliminadas: " + filas);

            if (filas == 0) {
                System.out.println("No se encontró la marca '" + nombre
                        + "'. Ejecuta antes InsertarMarca.");
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar la marca: " + e.getMessage());
        }
    }
}
