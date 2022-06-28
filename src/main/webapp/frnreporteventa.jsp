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

        <title>Reporte Ventas</title>
    </head>
    <body>
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="reporteventa"/>
        </jsp:include>        
        <div class="container" >
            <h1>Reporte Venta</h1>
            <br>
            <form action="ReporteVentaControlador" method="post" >
            <div class="form-group col-md-6 mb-3">
                    <label for="fecha1" class="form-label">Fecha Inicial</label>
                    <input type="date" name="fecha1" value="${reporte.fechareg}" class="form-control" id="fecha1" required="">
                </div>
            
             <div class="form-group col-md-6 mb-3">
                    <label for="fecha" class="form-label">Fecha Final</label>
                    <input type="date" name="fecha2" value="${reporte.fechareg}" class="form-control" id="fecha" required="">
                </div>
            <div class="form-group col-md-6 mb-3">
                    <label for="product" class="form-label">Producto</label>                    
                    <select name="product" class="form-label" required="">
                        <option value="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_productos}">                        
                            <option value="${item.numproducto}" style="background-color: #3d96f1"
                                    <c:if test="${reporte.producto == item.numproducto}">
                                        selected
                                    </c:if> >${item.producto}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-md-6 mb-3">
                  
                </div>
                <button type="submit" class="btn btn-primary">Generar Reporte</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>


