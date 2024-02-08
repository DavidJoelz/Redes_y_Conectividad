<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PermiGest - Inicio</title>
    <link rel="stylesheet" type="text/css" href="css/stylesindex.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>Bienvenido a PermiGest</h2>

        <%-- Muestra el mensaje de error si existe --%>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger" role="alert">
                ${errorMessage}
            </div>
        </c:if>

        <form action="IniciarSesionServlet" method="post">
            <label>ID Usuario (DNI):</label>
            <input type="text" name="DNI" required>

            <label>Contraseña:</label>
            <input type="password" name="Pass" required>

            <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
        </form>

        <p>¿No tienes cuenta? <a href="registroUsuario.jsp">Registrarse</a></p>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
