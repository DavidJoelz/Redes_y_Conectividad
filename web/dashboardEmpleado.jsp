<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PermiGest2 - Dashboard Empleado</title>
    <link rel="stylesheet" type="text/css" href="css/stylesempleado.css">
</head>
<body>
    <div class="container">
        <%-- Obtener el nombre del usuario desde la sesión --%>
        <h2>Bienvenido a PermiGest, <%= session.getAttribute("nombreUsuario") %></h2>

        <!-- Botón para registrar permiso -->
        <form action="registroPermiso.jsp" method="get">
            <button type="submit">Registrar Permiso</button>
        </form>
        
        <!-- Agrega el enlace o botón para cerrar sesión -->
        <form action="CerrarSesionServlet" method="post">
            <button type="submit" class="logout-btn">Cerrar Sesión</button>
        </form>

        <!-- Resto del contenido del dashboard -->
        <!-- ... -->
    </div>
</body>
</html>