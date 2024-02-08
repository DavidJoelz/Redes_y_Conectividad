package servlets;

import entidades.Usuario;
import servicios.UsuarioService;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@WebServlet("/RegistrarUsuarioServlet")
public class RegistrarUsuarioServlet extends HttpServlet {
    private final UsuarioService usuarioService;

    public RegistrarUsuarioServlet() {
        this.usuarioService = new UsuarioService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener parámetros del formulario
        String dni = request.getParameter("DNI");
        String email = request.getParameter("Email");
        String password = request.getParameter("Pass");
        String nombre = request.getParameter("Nombre");
        String apellidos = request.getParameter("Apellidos");
        String rol = request.getParameter("Rol");

        try {
            // Crear objeto Usuario con la información del formulario
            Usuario usuario = new Usuario(dni, email, password, nombre, apellidos, rol);

            // Llamar al servicio para insertar el usuario en la base de datos
            usuarioService.registrarUsuario(usuario);

            // Redirigir a la página de inicio de sesión o a otra página según tu lógica
            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            e.printStackTrace(); // O manejar la excepción de alguna otra manera

            // Redirigir a una página de error si es necesario
            response.sendRedirect("error.jsp");
        }
    }
}