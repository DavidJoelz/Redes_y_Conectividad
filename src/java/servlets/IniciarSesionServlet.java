package servlets;

import entidades.Usuario;
import servicios.UsuarioService;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/IniciarSesionServlet")
public class IniciarSesionServlet extends HttpServlet {
    private final UsuarioService usuarioService;

    public IniciarSesionServlet() {
        this.usuarioService = new UsuarioService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener parámetros del formulario
        String dni = request.getParameter("DNI");
        String password = request.getParameter("Pass");

        try {
            // Verificar credenciales
            if (usuarioService.verificarCredenciales(dni, password)) {
                // Obtener el rol y nombre del usuario
                String rol = usuarioService.obtenerRolUsuario(dni);
                String nombreUsuario = usuarioService.obtenerNombreUsuario(dni);

                // Almacenar información en la sesión
                request.getSession().setAttribute("rolUsuario", rol);
                request.getSession().setAttribute("nombreUsuario", nombreUsuario);
                request.getSession().setAttribute("DNI", dni);

                // Redirigir según el rol
                redirigirSegunRol(response, rol);
            } else {
                // Credenciales inválidas, establecer mensaje de error en la sesión
                request.getSession().setAttribute("errorMessage", "Usuario o contraseña incorrectos");
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
            request.getSession().setAttribute("errorMessage", "Error en el servidor");
            response.sendRedirect("index.jsp");
        }
    }

    private void redirigirSegunRol(HttpServletResponse response, String rol)
            throws IOException {
        switch (rol) {
            case "Empleado":
                response.sendRedirect("dashboardEmpleado.jsp");
                break;
            case "Control":
                response.sendRedirect("dashboardControl.jsp");
                break;
            // Agrega casos para otros roles según sea necesario
            default:
                // Redirigir a la página principal u otra página según tu lógica
                response.sendRedirect("index.jsp");
                break;
        }
    }
}
