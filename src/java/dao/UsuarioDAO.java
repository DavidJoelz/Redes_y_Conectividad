// UsuarioDAO.java
package dao;

import entidades.Usuario;
import utils.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public void insertarUsuario(Usuario usuario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Obtener conexión a la base de datos
            connection = ConexionBD.conectar();

            // Verificar que el usuario no sea nulo y tenga al menos algunos campos requeridos
            if (usuario != null && usuario.getDNI() != null && usuario.getEmail() != null && usuario.getPass() != null) {
                // Preparar la consulta SQL para insertar un nuevo usuario
                String sql = "INSERT INTO Usuarios (DNI, Email, Pass, Nombre, Apellidos, Rol) VALUES (?, ?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);

                // Establecer los parámetros de la consulta con los valores del usuario
                preparedStatement.setString(1, usuario.getDNI());
                preparedStatement.setString(2, usuario.getEmail());
                preparedStatement.setString(3, usuario.getPass());
                preparedStatement.setString(4, usuario.getNombre());
                preparedStatement.setString(5, usuario.getApellidos());
                preparedStatement.setString(6, usuario.getRol());

                // Ejecutar la consulta para insertar el usuario
                preparedStatement.executeUpdate();
            } else {
                throw new IllegalArgumentException("El usuario o algunos campos requeridos son nulos.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Relanza la excepción para que pueda ser manejada en el Servlet
        } finally {
            // Cerrar recursos
            ConexionBD.cerrarConexion(connection, preparedStatement, null);
        }
    }

    public Usuario obtenerUsuarioPorDni(String dni) throws SQLException {
        try (Connection connection = ConexionBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Usuarios WHERE DNI = ?")) {

            preparedStatement.setString(1, dni);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Crear y devolver un objeto Usuario con los datos obtenidos de la base de datos
                    return new Usuario(
                            resultSet.getString("DNI"),
                            resultSet.getString("Email"),
                            resultSet.getString("Pass"),
                            resultSet.getString("Nombre"),
                            resultSet.getString("Apellidos"),
                            resultSet.getString("Rol")
                    );
                }
            }
        }

        // Devolver null si no se encuentra ningún usuario con el DNI proporcionado
        return null;
    }

    // Otros métodos relacionados con la manipulación de usuarios en la base de datos
}