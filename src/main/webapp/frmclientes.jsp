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

        <title>Formulario de Clientes</title>
    </head>
    <body>
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="clientes"/>
        </jsp:include>        
        <div class="container" >

            <h1>Formulario de Clientes</h1>

            <br>
            <form action="ClientesControlador" method="post" >
                <input type="hidden" name="id" value="${cliente.id}" >
                <div class="form-group col-md-6 mb-3">
                    <label for="nombres" class="form-label">Nombres</label>
                    <input type="text"  name="nombres" value="${cliente.nombres}" class="form-control" id="nombres" required="">                    
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="apellidos" class="form-label">Apellidos</label>
                    <input type="text" name="apellidos" value="${cliente.apellidos}" class="form-control" id="apellidos" required="">
                </div>
                 <div class="form-group col-md-6 mb-3">
                    <label for="direccion" class="form-label">Direccion</label>
                    <input type="text" name="direccion" value="${cliente.direccion}" class="form-control" id="direccion" required="">
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="telefono" class="form-label">Celular</label>
                    <input type="text" name="telefono" value="${cliente.telefono}" class="form-control" id="telefono" required="">
                </div><br>
                <button type="submit" class="btn btn-primary">Procesar</button>
            </form>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>