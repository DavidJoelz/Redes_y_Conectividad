// HistorialPermisosServlet.java
package servlets;

import entidades.RegistroPermisos;
import servicios.RegistroPermisosService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HistorialPermisosServlet")
public class HistorialPermisosServlet extends HttpServlet {
    private final RegistroPermisosService registroPermisosService;

    public HistorialPermisosServlet() {
        this.registroPermisosService = new RegistroPermisosService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtener historial de permisos desde el servicio
            List<RegistroPermisos> historialPermisos = registroPermisosService.obtenerHistorialPermisos();

            // Almacenar el historial en el alcance de la solicitud para acceder desde la JSP
            request.setAttribute("historialPermisos", historialPermisos);

            // Redirigir a la página de historial
            request.getRequestDispatcher("verHistorial.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace(); // O manejar la excepción de alguna otra manera

            // Redirigir a una página de error si es necesario
            response.sendRedirect("error.jsp");
        }
    }
}