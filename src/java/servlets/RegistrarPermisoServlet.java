package servlets;

import entidades.Permiso;
import servicios.PermisoService;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistrarPermisoServlet")
public class RegistrarPermisoServlet extends HttpServlet {
    private final PermisoService permisoService;

    public RegistrarPermisoServlet() {
        this.permisoService = new PermisoService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener parámetros del formulario
        String dniUsuario = request.getParameter("DNIUsuario");
        String tipoPermiso = request.getParameter("TipoPermiso");
        String areaOrigen = request.getParameter("AreaOrigen");
        String dependenciaOrigen = request.getParameter("DependenciaOrigen");
        String areaDestino = request.getParameter("AreaDestino");
        String dependenciaDestino = request.getParameter("DependenciaDestino");
        String asunto = request.getParameter("Asunto");
        String observaciones = request.getParameter("Observaciones");
        LocalDate fecha = LocalDate.parse(request.getParameter("Fecha"));
        LocalTime horaSalida = LocalTime.parse(request.getParameter("HoraSalida"));
        LocalTime horaRetorno = LocalTime.parse(request.getParameter("HoraRetorno"));

        try {
            // Crear objeto Permiso con la información del formulario
            Permiso permiso = new Permiso(dniUsuario, tipoPermiso, areaOrigen, dependenciaOrigen,
                    areaDestino, dependenciaDestino, asunto, observaciones, fecha, horaSalida, horaRetorno);

            // Llamar al servicio para insertar el permiso en la base de datos
            permisoService.registrarPermiso(permiso);

            // Redirigir a la página de inicio u otra página según tu lógica
            response.sendRedirect("dashboardEmpleado.jsp");
        } catch (SQLException e) {
            e.printStackTrace(); // O manejar la excepción de alguna otra manera

            // Redirigir a una página de error si es necesario
            response.sendRedirect("error.jsp");
        }
    }
}