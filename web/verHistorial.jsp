<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entidades.RegistroPermisos" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>PermiGest2 - Historial de Permisos</title>
    <link rel="stylesheet" type="text/css" href="css/styleshistorial.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

    <!-- DataTables Styles -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css">
</head>
<body>
    <div class="container">
        <h2>Historial de Permisos</h2>

        <!-- Tabla para mostrar el historial de permisos -->
        <table id="miTabla" class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Permiso ID</th>
                    <th>DNI Usuario</th>
                    <th>Fecha de Registro</th>
                    <th>Hora de Registro</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% List<RegistroPermisos> historialPermisos = (List<RegistroPermisos>) request.getAttribute("historialPermisos"); %>

                <% if (historialPermisos != null) { %>
                    <% for (RegistroPermisos registro : historialPermisos) { %>
                        <tr>
                            <td><%= registro.getID() %></td>
                            <td><%= registro.getPermisoID() %></td>
                            <td><%= registro.getUsuarioDNI() %></td>
                            <td><%= registro.getFechaRegistro() %></td>
                            <td><%= registro.getHoraRegistro() %></td>
                            <td>
                                <a href="EliminarPermisoServlet?permisoID=<%= registro.getPermisoID() %>">Eliminar</a>
                                <!-- Comenta o elimina la siguiente línea para quitar la acción de Modificar -->
                                <!-- <a href="ModificarPermisoServlet?permisoID=<%= registro.getPermisoID() %>">Modificar</a> -->
                            </td>
                        </tr>
                    <% } %>
                <% } else { %>
                    <tr>
                        <td colspan="6">No hay datos en el historial</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
            <!-- Botón para cerrar sesión -->
    <form action="CerrarSesionServlet" method="post">
        <button type="submit" class="btn btn-danger">Cerrar Sesión</button>
    </form>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <!-- DataTables Scripts -->
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/2.4.2/js/dataTables.buttons.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
    <script src="https://cdn.datatables.net/buttons/2.4.2/js/buttons.html5.min.js"></script>

    <!-- DataTables Initialization -->
    <script>
        $(document).ready(function () {
            $('#miTabla').DataTable({
                dom: 'Bfrtip',
                buttons: [
                    'copy',
                    'csv',
                    'excel',
                    'pdf',
                    'print'
                ]
            });
        });
    </script>
</body>
</html>
