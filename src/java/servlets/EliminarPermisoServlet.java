package servlets;

import entidades.RegistroPermisos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.ConexionBD;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import servicios.RegistroPermisosService;

@WebServlet("/EliminarPermisoServlet")
public class EliminarPermisoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el ID del permiso a eliminar desde los parámetros de la solicitud
        int permisoID = Integer.parseInt(request.getParameter("permisoID"));

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establecer la conexión
            connection = ConexionBD.conectar();

            // Preparar la consulta SQL para eliminar el permiso
            String sql = "DELETE FROM RegistroPermisos WHERE PermisoID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, permisoID);

            // Ejecutar la consulta
            preparedStatement.executeUpdate();

            // Recargar la lista de permisos actualizada
            List<RegistroPermisos> historialPermisos = obtenerHistorialPermisosDesdeBD();

            // Agregar la lista actualizada como atributo de la solicitud
            request.setAttribute("historialPermisos", historialPermisos);

            // Redirigir a la página de historial después de eliminar el permiso
            request.getRequestDispatcher("verHistorial.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
            response.sendRedirect("error.jsp");
        } finally {
            // Cerrar la conexión
            ConexionBD.cerrarConexion(connection, preparedStatement, null);
        }
    }

    private List<RegistroPermisos> obtenerHistorialPermisosDesdeBD() throws SQLException {
        // Lógica para obtener la lista actualizada de permisos desde la base de datos
        // Puedes utilizar tu servicio o DAO correspondiente
        // Ejemplo:
        RegistroPermisosService permisosService = new RegistroPermisosService();
        return permisosService.obtenerHistorialPermisos();
        
    }
}

