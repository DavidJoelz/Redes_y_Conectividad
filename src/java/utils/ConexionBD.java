package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/permigest2";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    // Constructor privado para evitar instanciación directa
    private ConexionBD() {
        // No es necesario realizar acciones en el constructor
    }

    static {
        // Registrar el controlador de JDBC una sola vez al cargar la clase
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
    }

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }

    public static void cerrarConexion(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            // Cerrar recursos en orden inverso para evitar problemas
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Puedes manejar la excepción de alguna manera según tus necesidades
        }
    }
}