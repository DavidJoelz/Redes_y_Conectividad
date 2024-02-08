package servicios;

import dao.UsuarioDAO;
import entidades.Usuario;

import java.sql.SQLException;

public class UsuarioService {

    private final UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void registrarUsuario(Usuario usuario) throws SQLException {
        usuarioDAO.insertarUsuario(usuario);
    }

    public boolean verificarCredenciales(String dni, String password) throws SQLException {
        Usuario usuario = usuarioDAO.obtenerUsuarioPorDni(dni);

        // Verificar si el usuario existe y si la contraseña coincide
        return usuario != null && usuario.getPass().equals(password);
    }

    public String obtenerRolUsuario(String dni) throws SQLException {
        Usuario usuario = usuarioDAO.obtenerUsuarioPorDni(dni);

        // Devolver el rol del usuario
        return (usuario != null) ? usuario.getRol() : null;
    }

    public String obtenerNombreUsuario(String dni) throws SQLException {
        Usuario usuario = usuarioDAO.obtenerUsuarioPorDni(dni);

        // Devolver el nombre del usuario
        return (usuario != null) ? usuario.getNombre() : null;
    }
}