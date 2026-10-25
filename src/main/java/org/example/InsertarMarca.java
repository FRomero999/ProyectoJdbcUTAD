package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Ejemplo de inserción de una nueva marca en la tabla {@code brands}.
 */
public class InsertarMarca {

    static void main() {
        String nombre = "Nintendo";
        String pais = "Japón";

        String sql = "INSERT INTO brands (name, country) VALUES (?, ?)";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, new String[]{"id"})) {

            ps.setString(1, nombre);
            ps.setString(2, pais);

            int filas = ps.executeUpdate();
            System.out.println("Filas insertadas: " + filas);

            try (ResultSet claves = ps.getGeneratedKeys()) {
                if (claves.next()) {
                    System.out.println("Nueva marca con id " + claves.getInt(1)
                            + ": " + nombre + " (" + pais + ")");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al insertar la marca: " + e.getMessage());
        }
    }
}
