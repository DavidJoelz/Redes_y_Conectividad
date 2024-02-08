<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PermiGest - Registro de Usuario</title>
    <link rel="stylesheet" type="text/css" href="css/registroUsuarioStyle.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

    <!-- DataTables CSS -->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css">

</head>
<body>
    <div class="container">
        <h2>Registrarse en PermiGest</h2>

        <form action="RegistrarUsuarioServlet" method="post">
            <label>ID Usuario (DNI):</label>
            <input type="text" name="DNI" id="DNI" required>
            <span id="DNIMsg"></span>

            <label>Email:</label>
            <input type="email" name="Email" id="Email" required>
            <span id="EmailMsg"></span>

            <label>Contraseña:</label>
            <input type="password" name="Pass" id="Pass" required>
            <span id="PassMsg"></span>

            <label>Nombre:</label>
            <input type="text" name="Nombre" id="Nombre" required>
            <span id="NombreMsg"></span>

            <label>Apellidos:</label>
            <input type="text" name="Apellidos" id="Apellidos" required>
            <span id="ApellidosMsg"></span>

            <label>Rol:</label>
            <select name="Rol" id="Rol" required>
                <option value="Empleado">Empleado</option>
                <option value="Control">Control</option>
            </select>
            <span id="RolMsg"></span>

            <div class="text-center mt-3">
                <button type="submit" class="btn btn-primary" id="btnRegistrarUsuario">Registrarse</button>
            </div>
        </form>
        
        <div class="text-center mt-3">
            <button type="button" class="btn btn-secondary" onclick="location.href='index.jsp'">Salir</button>
        </div>
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
        $(document).ready(function() {
            // DataTable initialization
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

            // Validación de formulario y estado del botón
            $("#btnRegistrarUsuario").prop('disabled', true);

            $("#DNI").keyup(function() {
                validateDNI();
                buttonState();
            });

            $("#Email").keyup(function() {
                validateEmail();
                buttonState();
            });

            $("#Pass").keyup(function() {
                validatePassword();
                buttonState();
            });

            $("#Nombre").keyup(function() {
                validateNombre();
                buttonState();
            });

            $("#Apellidos").keyup(function() {
                validateApellidos();
                buttonState();
            });

            $("#Rol").change(function() {
                validateRol();
                buttonState();
            });
        });

        function buttonState() {
            if (validateDNI() && validateEmail() && validatePassword() && validateNombre() && validateApellidos() && validateRol()) {
                $("#btnRegistrarUsuario").prop('disabled', false);
            } else {
                $("#btnRegistrarUsuario").prop('disabled', true);
            }
        }

        // Funciones de validación
        function validateDNI() {
            var dni = $("#DNI").val();
            var reg = /^\d{8}$/;
            var isValid = reg.test(dni);
            $("#DNIMsg").html(isValid ? "" : "<p class='text-danger'>Ingresa un DNI válido (8 dígitos numéricos)</p>");
            return isValid;
        }

        function validateEmail() {
            var email = $("#Email").val();
            var reg = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            var isValid = reg.test(email);
            $("#EmailMsg").html(isValid ? "" : "<p class='text-danger'>Ingresa un correo electrónico válido</p>");
            return isValid;
        }

        function validatePassword() {
            var password = $("#Pass").val();
            var isValid = password.length >= 8;
            $("#PassMsg").html(isValid ? "" : "<p class='text-danger'>La contraseña debe tener al menos 8 caracteres</p>");
            return isValid;
        }

        function validateNombre() {
            var nombre = $("#Nombre").val();
            var isValid = /^[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ\s]{3,}$/.test(nombre);
            $("#NombreMsg").html(isValid ? "" : "<p class='text-danger'>Por favor, ingresa nombres válidos</p>");
            return isValid;
        }

        function validateApellidos() {
            var apellidos = $("#Apellidos").val();
            var isValid = /^[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ\s]{3,}$/.test(apellidos);
            $("#ApellidosMsg").html(isValid ? "" : "<p class='text-danger'>Por favor, ingresa apellidos válidos</p>");
            return isValid;
        }

        function validateRol() {
            var rol = $("#Rol").val();
            var isValid = rol === "Empleado" || rol === "Control";
            $("#RolMsg").html(isValid ? "" : "<p class='text-danger'>Selecciona un rol válido</p>");
            return isValid;
        }
    </script>
</body>
</html>