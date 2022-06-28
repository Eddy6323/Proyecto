<%
    if (session.getAttribute("logueado") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

        <title>Formulario de Productos</title>
    </head>
    <body>
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="productos"/>
        </jsp:include>        
        <div class="container" >
            <h1>Formulario de Productos</h1>
            <br>
            <form action="ProductosControlador" method="post" >
                <input type="hidden" name="id" value="${productos.id}" >
                <div class="form-group col-md-6 mb-3">
                    <label for="producto" class="form-label">Producto</label>                    
                    <select name="numproducto" class="form-label" required="">
                        <option value="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_compras}">                        
                            <option value="${item.id}" style="background-color: #3d96f1"
                                    <c:if test="${productos.numproducto == item.id}">
                                        selected
                                    </c:if> >${item.producto}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="precio" class="form-label">Precio</label>
                    <input type="number" name="precio" value="${productos.precio}" class="form-control" id="precio" required="">
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="fecha" class="form-label">Fecha</label>
                    <input type="date" name="fecha" value="${productos.fecha}" class="form-control" id="fecha" required="">
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="disponibilidad" class="form-label">Disponibilidad</label>
                    <input type="number" name="disponibilidad" value="${productos.disponibilidad}" class="form-control" id="disponibilidad" required="">
                </div>
                <button type="submit" class="btn btn-primary">Procesar</button>
            </form>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>