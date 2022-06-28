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

        <title>Formulario de Usuarios</title>
    </head>
    <body>
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="usuarios"/>
        </jsp:include>        
        <div class="container" >

            <h1>Formulario de Usuarios</h1>

            <br>
            <form action="UsuariosControlador" method="post" >
                <input type="hidden" name="id" value="${usuario.id}" >
                <div class="form-group col-md-6 mb-3">
                    <label for="usuario" class="form-label">Nombre de usuario</label>
                    <input type="text"  name="usuario" value="${usuario.usuario}" class="form-control" id="usuario" required="">                    
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="correo" class="form-label">Correo</label>
                    <input type="email" name="correo" value="${usuario.correo}" class="form-control" id="correo" required="">
                </div>
                 <div class="form-group col-md-6 mb-3">
                    <label for="cargo" class="form-label">Cargo</label>
                    <input type="text" name="cargo" value="${usuario.cargo}" class="form-control" id="cargo" required="">
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" name="password" value="${cliente.password}" class="form-control" id="password" required="">
                </div><br>
                <button type="submit" class="btn btn-primary">Procesar</button>
            </form>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>