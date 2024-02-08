package dao;

import entidades.Permiso;
import utils.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PermisoDAO {

    public void insertarPermiso(Permiso permiso) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Obtener conexión a la base de datos
            connection = ConexionBD.conectar();

            // Verificar que el permiso no sea nulo y tenga al menos algunos campos requeridos
            if (permiso != null && permiso.getDNIUsuario() != null) {
                // Preparar la consulta SQL para insertar un nuevo permiso
                String sql = "INSERT INTO Permiso (DNIUsuario, TipoPermiso, AreaOrigen, DependenciaOrigen, " +
                             "AreaDestino, DependenciaDestino, Asunto, Observaciones, Fecha, HoraSalida, HoraRetorno) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);

                // Establecer los parámetros de la consulta con los valores del permiso
                preparedStatement.setString(1, permiso.getDNIUsuario());
                preparedStatement.setString(2, permiso.getTipoPermiso());
                preparedStatement.setString(3, permiso.getAreaOrigen());
                preparedStatement.setString(4, permiso.getDependenciaOrigen());
                preparedStatement.setString(5, permiso.getAreaDestino());
                preparedStatement.setString(6, permiso.getDependenciaDestino());
                preparedStatement.setString(7, permiso.getAsunto());
                preparedStatement.setString(8, permiso.getObservaciones());
                preparedStatement.setDate(9, Date.valueOf(permiso.getFecha()));
                preparedStatement.setTime(10, Time.valueOf(permiso.getHoraSalida()));
                preparedStatement.setTime(11, Time.valueOf(permiso.getHoraRetorno()));

                // Ejecutar la consulta para insertar el permiso
                preparedStatement.executeUpdate();
            } else {
                throw new IllegalArgumentException("El permiso o algunos campos requeridos son nulos.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Relanza la excepción para que pueda ser manejada en el Servlet
        } finally {
            // Cerrar recursos
            ConexionBD.cerrarConexion(connection, preparedStatement, null);
        }
    }

    public List<Permiso> obtenerPermisosPorUsuario(String dniUsuario) throws SQLException {
        List<Permiso> permisos = new ArrayList<>();

        try (Connection connection = ConexionBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Permiso WHERE DNIUsuario = ?")) {

            preparedStatement.setString(1, dniUsuario);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Crear y agregar objetos Permiso a la lista con los datos obtenidos de la base de datos
                    permisos.add(new Permiso(
                            resultSet.getString("DNIUsuario"),
                            resultSet.getString("TipoPermiso"),
                            resultSet.getString("AreaOrigen"),
                            resultSet.getString("DependenciaOrigen"),
                            resultSet.getString("AreaDestino"),
                            resultSet.getString("DependenciaDestino"),
                            resultSet.getString("Asunto"),
                            resultSet.getString("Observaciones"),
                            resultSet.getDate("Fecha").toLocalDate(),
                            resultSet.getTime("HoraSalida").toLocalTime(),
                            resultSet.getTime("HoraRetorno").toLocalTime()
                    ));
                }
            }
        }

        return permisos;
    }

    // Otros métodos relacionados con la manipulación de permisos en la base de datos
}