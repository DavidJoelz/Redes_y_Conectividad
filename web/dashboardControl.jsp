<!-- dashboardControl.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PermiGest2 - Dashboard Control</title>
    <link rel="stylesheet" type="text/css" href="css/stylescontrol.css">
</head>
<body>
    <div class="container">
        <%-- Obtener el nombre del usuario desde la sesión --%>
        <h2>Bienvenido a PermiGest Control!  <%= session.getAttribute("nombreUsuario") %></h2>

        <!-- Botón para ver historial de permisos -->
        <a href="HistorialPermisosServlet">Ver Historial de Permisos</a>

        <!-- Botón para cerrar sesión -->
        <form action="CerrarSesionServlet" method="post">
            <button type="submit" class="logout-btn">Cerrar Sesión</button>
        </form>
        
        <!-- Resto del contenido del dashboard -->
        <!-- ... -->
    </div>
</body>
</html>

