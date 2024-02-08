<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PermiGest - Registro de Permiso</title>
    <link rel="stylesheet" type="text/css" href="css/registroPermisoStyle.css">
    
    <!-- Agregamos script de JavaScript para obtener la fecha y hora del sistema -->
    <script>
        function obtenerFechaHoraSistema() {
            var fechaSistema = new Date();

            // Obtener fecha en formato yyyy-mm-dd
            var fechaFormateada = fechaSistema.getFullYear() + '-' +
                ('0' + (fechaSistema.getMonth() + 1)).slice(-2) + '-' +
                ('0' + fechaSistema.getDate()).slice(-2);

            // Obtener hora en formato hh:mm
            var horaFormateada = ('0' + fechaSistema.getHours()).slice(-2) + ':' +
                ('0' + fechaSistema.getMinutes()).slice(-2);

            // Establecer fecha y hora solo en el campo de "Hora de Salida"
            document.getElementById('fecha').value = fechaFormateada;
            document.getElementById('horaSalida').value = horaFormateada;
        }
    </script>
</head>
<body onload="obtenerFechaHoraSistema();"> <!-- Llamamos a la función cuando carga la página -->
    <div class="container">
        <h2>Registrar Permiso en PermiGest</h2>

        <form action="RegistrarPermisoServlet" method="post">
            <!-- Obtener automáticamente el DNI del usuario desde la sesión -->
            <label>ID Usuario (DNI):</label>
            <input type="text" name="DNIUsuario" value="<%= session.getAttribute("DNI") %>" required readonly>

            <label>Tipo de Permiso:</label>
            <select name="TipoPermiso" required>
                <option value=" "> </option>
                <option value="Oficial">Oficial</option>
                <option value="Particular">Particular</option>
                <option value="Essalud">Essalud</option>
                <option value="Capacitacion">Capacitación</option>
                <option value="Gremial">Gremial</option>
            </select>

            <label>Área de Origen:</label>
            <select name="AreaOrigen" required>
                <option value=" "> </option>
                <option value="Ingeniería">Ingeniería</option>
                <option value="Sociales">Sociales</option>
                <option value="Biomédicas">Biomédicas</option>
                <option value="Central">Central</option>
                <option value="Sucursal Camaná">Sucursal Camaná</option>
                <option value="Sucursal Mollendo">Sucursal Mollendo</option>
                <option value="Sucursal La Joya">Sucursal La Joya</option>
            </select>

            <label>Dependencia de Origen:</label>
            <input type="text" name="DependenciaOrigen" required>

            <label>Área de Destino:</label>
            <select name="AreaDestino" required>
                <option value=" "> </option>
                <option value="Ingeniería">Ingeniería</option>
                <option value="Sociales">Sociales</option>
                <option value="Biomédicas">Biomédicas</option>
                <option value="Central">Central</option>
                <option value="Sucursal Camaná">Sucursal Camaná</option>
                <option value="Sucursal Mollendo">Sucursal Mollendo</option>
                <option value="Sucursal La Joya">Sucursal La Joya</option>
            </select>

            <label>Dependencia de Destino:</label>
            <input type="text" name="DependenciaDestino" required>

            <label>Asunto:</label>
            <input type="text" name="Asunto" required>

            <label>Observaciones:</label>
            <textarea name="Observaciones"></textarea>

            <label>Fecha:</label>
            <input type="date" name="Fecha" id="fecha" required>

            <label>Hora de Salida:</label>
            <input type="time" name="HoraSalida" id="horaSalida" required>

            <label>Hora de Retorno:</label>
            <input type="time" name="HoraRetorno" required>

            <button type="submit">Registrar Permiso</button>
            
        </form>
    </div>
</body>
</html>