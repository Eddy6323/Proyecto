<%
    if (session.getAttribute("logueado") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">

        <title>Formulario de Empleados</title>
    </head>
    <body>
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="empleados"/>
        </jsp:include>        
        <div class="container" >

            <h1>Formulario de Empleados</h1>

            <br>
            <form action="EmpleadosControlador" method="post" >
                <input type="hidden" name="id" value="${empleado.id}" >
                <div class="form-group col-md-6 mb-3">
                    <label for="nombres" class="form-label">Nombres</label>
                    <input type="text"  name="nombres" value="${empleado.nombres}" class="form-control" id="nombres" required="">                    
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="apellidos" class="form-label">Apellidos</label>
                    <input type="text" name="apellidos" value="${empleado.apellidos}" class="form-control" id="apellidos" required="">
                </div>
                 <div class="form-group col-md-6 mb-3">
                    <label for="ci" class="form-label">Ci</label>
                    <input type="text" name="ci" value="${empleado.ci}" class="form-control" id="ci" >
                </div>
                 <div class="form-group col-md-6 mb-3">
                    <label for="fechanacim" class="form-label">Fecha de Nacimeinto</label>
                    <input type="date" name="fechanacim" value="${empleado.fechanacim}" class="form-control" id="fechanacim" required="">
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="telefono" class="form-label">Celular</label>
                    <input type="text" name="telefono" value="${empleado.telefono}" class="form-control" id="telefono" required="">
                </div><br>
                <button type="submit" class="btn btn-primary">Procesar</button>
            </form>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>