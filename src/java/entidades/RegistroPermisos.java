package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import utils.ConexionBD;

public class RegistroPermisos {
    private int ID;
    private int PermisoID;
    private LocalDate FechaRegistro;
    private LocalTime HoraRegistro;
    private int RegistradoPor;

    // Constructor vacío (puede ser necesario para ciertos frameworks)
    public RegistroPermisos() {
    }

    // Constructor con parámetros
    public RegistroPermisos(int ID, int PermisoID, LocalDate FechaRegistro, LocalTime HoraRegistro, int RegistradoPor) {
        this.ID = ID;
        this.PermisoID = PermisoID;
        this.FechaRegistro = FechaRegistro;
        this.HoraRegistro = HoraRegistro;
        this.RegistradoPor = RegistradoPor;
    }

    // Getters y setters (puedes generarlos automáticamente en tu IDE)
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPermisoID() {
        return PermisoID;
    }

    public void setPermisoID(int PermisoID) {
        this.PermisoID = PermisoID;
    }

    public LocalDate getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(LocalDate FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public LocalTime getHoraRegistro() {
        return HoraRegistro;
    }

    public void setHoraRegistro(LocalTime HoraRegistro) {
        this.HoraRegistro = HoraRegistro;
    }

    public int getRegistradoPor() {
        return RegistradoPor;
    }

    public void setRegistradoPor(int RegistradoPor) {
        this.RegistradoPor = RegistradoPor;
    }

    public String getUsuarioDNI() {
        String usuarioDNI = "";

        // Consultar la base de datos para obtener el DNI del usuario
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConexionBD.conectar();
            String consulta = "SELECT DNI FROM Usuarios WHERE ID = ?";
            preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setInt(1, this.RegistradoPor);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                usuarioDNI = resultSet.getString("DNI");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        } finally {
            ConexionBD.cerrarConexion(connection, preparedStatement, resultSet);
        }

        return usuarioDNI;
    }

    @Override
    public String toString() {
        return "RegistroPermisos{" +
                "ID=" + ID +
                ", PermisoID=" + PermisoID +
                ", FechaRegistro=" + FechaRegistro +
                ", HoraRegistro=" + HoraRegistro +
                ", RegistradoPor=" + RegistradoPor +
                '}';
    }
}
