package dao;

import entidades.RegistroPermisos;
import utils.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistroPermisosDAO {

    public void insertarRegistroPermisos(RegistroPermisos registroPermisos) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConexionBD.conectar();

            if (registroPermisos != null && registroPermisos.getPermisoID() > 0 && registroPermisos.getRegistradoPor() > 0) {
                String sql = "INSERT INTO RegistroPermisos (PermisoID, FechaRegistro, HoraRegistro, RegistradoPor) " +
                             "VALUES (?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setInt(1, registroPermisos.getPermisoID());
                preparedStatement.setDate(2, Date.valueOf(registroPermisos.getFechaRegistro()));
                preparedStatement.setTime(3, Time.valueOf(registroPermisos.getHoraRegistro()));
                preparedStatement.setInt(4, registroPermisos.getRegistradoPor());

                preparedStatement.executeUpdate();

                // Obtener la clave generada automáticamente (ID)
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idGenerado = generatedKeys.getInt(1);
                        registroPermisos.setID(idGenerado);
                    }
                }
            } else {
                throw new IllegalArgumentException("El registroPermisos o algunos campos requeridos son nulos.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            ConexionBD.cerrarConexion(connection, preparedStatement, null);
        }
    }

    public List<RegistroPermisos> obtenerRegistrosPorUsuario(String dniUsuario) throws SQLException {
        List<RegistroPermisos> registrosPermisos = new ArrayList<>();

        try (Connection connection = ConexionBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM RegistroPermisos WHERE RegistradoPor = ?")) {

            preparedStatement.setString(1, dniUsuario);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    registrosPermisos.add(new RegistroPermisos(
                            resultSet.getInt("ID"),
                            resultSet.getInt("PermisoID"),
                            resultSet.getDate("FechaRegistro").toLocalDate(),
                            resultSet.getTime("HoraRegistro").toLocalTime(),
                            resultSet.getInt("RegistradoPor")
                    ));
                }
            }
        }

        return registrosPermisos;
    }
    
    public List<RegistroPermisos> obtenerHistorialPermisos() throws SQLException {
        List<RegistroPermisos> historialPermisos = new ArrayList<>();

        try (Connection connection = ConexionBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM RegistroPermisos")) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    historialPermisos.add(new RegistroPermisos(
                            resultSet.getInt("ID"),
                            resultSet.getInt("PermisoID"),
                            resultSet.getDate("FechaRegistro").toLocalDate(),
                            resultSet.getTime("HoraRegistro").toLocalTime(),
                            resultSet.getInt("RegistradoPor")
                    ));
                }
            }
        }

        return historialPermisos;
    }

    // Otros métodos relacionados con la manipulación de registrosPermisos en la base de datos
}