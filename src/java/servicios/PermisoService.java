package servicios;

import dao.PermisoDAO;
import entidades.Permiso;

import java.sql.SQLException;
import java.util.List;

public class PermisoService {

    private final PermisoDAO permisoDAO;

    public PermisoService() {
        this.permisoDAO = new PermisoDAO();
    }

    public void registrarPermiso(Permiso permiso) throws SQLException {
        permisoDAO.insertarPermiso(permiso);
    }

    public List<Permiso> obtenerPermisosPorUsuario(String dniUsuario) throws SQLException {
        return permisoDAO.obtenerPermisosPorUsuario(dniUsuario);
    }

    // Otros métodos relacionados con la manipulación de permisos en la base de datos
}