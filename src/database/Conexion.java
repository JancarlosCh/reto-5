package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JancarlosCh
 */
public class Conexion {

    private static final String UBICACION_DB = "ProyectosConstruccion.db";

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_DB;
        DriverManager.registerDriver(new org.sqlite.JDBC());
        return DriverManager.getConnection(url);
    }
}
