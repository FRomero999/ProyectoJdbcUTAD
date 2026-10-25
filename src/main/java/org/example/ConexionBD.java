package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Proporciona conexiones JDBC a la base de datos PostgreSQL del proyecto.
 */
public final class ConexionBD {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "admin";
    private static final String PASSWORD = "pwd";

    private ConexionBD() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
