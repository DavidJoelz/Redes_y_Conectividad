package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CerrarSesionServlet")
public class CerrarSesionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener la sesión actual o crear una nueva si no existe
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Invalidar la sesión actual
            session.invalidate();
        }

        // Redirigir al usuario a la página de inicio
        response.sendRedirect("index.jsp");
    }
}
