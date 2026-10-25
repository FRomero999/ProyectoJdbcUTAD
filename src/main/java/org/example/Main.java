package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Muestra por consola todas las marcas almacenadas en la tabla {@code brands}.
 */
public class Main {

    static void main() {
        String sql = "SELECT id, name, country FROM brands ORDER BY id";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("ID | NOMBRE | PAIS");
            System.out.println("-".repeat(55));

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | "
                        + rs.getString("name") + " | "
                        + rs.getString("country"));
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar las marcas: " + e.getMessage());
        }
    }
}
