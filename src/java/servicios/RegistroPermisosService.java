package servicios;

import dao.RegistroPermisosDAO;
import entidades.RegistroPermisos;

import java.sql.SQLException;
import java.util.List;

public class RegistroPermisosService {

    private final RegistroPermisosDAO registroPermisosDAO;

    public RegistroPermisosService() {
        this.registroPermisosDAO = new RegistroPermisosDAO();
    }

    public void registrarRegistroPermisos(RegistroPermisos registroPermisos) throws SQLException {
        try {
            // Puedes agregar más validaciones si es necesario
            registroPermisosDAO.insertarRegistroPermisos(registroPermisos);
        } catch (SQLException e) {
            // Loguea el error o lanza una excepción más específica si es necesario
            throw e;
        }
    }

    public List<RegistroPermisos> obtenerRegistrosPorUsuario(String dniUsuario) throws SQLException {
        try {
            // Puedes agregar más validaciones si es necesario
            return registroPermisosDAO.obtenerRegistrosPorUsuario(dniUsuario);
        } catch (SQLException e) {
            // Loguea el error o lanza una excepción más específica si es necesario
            throw e;
        }
    }
    
    public List<RegistroPermisos> obtenerHistorialPermisos() throws SQLException {
        try {
            // Obtener el historial completo de permisos desde el DAO
            return registroPermisosDAO.obtenerHistorialPermisos();
        } catch (SQLException e) {
            // Loguea el error o lanza una excepción más específica si es necesario
            throw e;
        }
    }

    // Otros métodos relacionados con la manipulación de registrosPermisos en la lógica de negocio
}