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

        <title>Formulario de Ventas</title>
    </head>
    <body>
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="ventas"/>
        </jsp:include>        
        <div class="container" >
            <h1>Formulario de Ventas</h1>
            <br>
            <form action="VentasControlador" method="post" >
                 <input type="hidden" name="id" value="${ventas.id}" >
                 <div class="form-group col-md-6 mb-3">
                    <label for="producto" class="form-label">Producto</label>                    
                    <select name="producto" class="form-label" required="">
                        <option value="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_productos}">                        
                            <option value="${item.numproducto}" style="background-color: #3d96f1"
                                    <c:if test="${ventas.producto == item.numproducto}">
                                        selected
                                    </c:if> >${item.producto}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="precventa" class="form-label">Precio de venta</label>
                    <input type="number" name="precventa" value="${ventas.precventa}" class="form-control" id="precventa" required="">
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="cantidad" class="form-label">Cantidad</label>
                    <input type="number" name="cantidad" value="${ventas.cantidad}" class="form-control" id="cantidad" required="">
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="fechareg" class="form-label">Fecha de registro</label>
                    <input type="date" name="fechareg" value="${ventas.fechareg}" class="form-control" id="fechareg" required="">
                </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="cliente" class="form-label">Cliente</label>                    
                    <select name="cliente" class="form-label" required="">
                        <option value="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_clientes}">                        
                            <option value="${item.id}" style="background-color: #3d96f1"
                                    <c:if test="${ventas.cliente == item.id}">
                                        selected
                                    </c:if> >${item.nombres}</option>
                        </c:forEach>
                    </select>
                   </div>
                
                 <div class="form-group col-md-6 mb-3">
                    <label for="empleado" class="form-label">Empleado</label>                    
                    <select name="empleado" class="form-label" required="">
                        <option value="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_empleados}">                        
                            <option value="${item.id}" style="background-color: #3d96f1"
                                    <c:if test="${ventas.empleado == item.id}">
                                        selected
                                    </c:if> >${item.nombres}</option>
                        </c:forEach>
                    </select>
                   </div>
                <div class="form-group col-md-6 mb-3">
                    <label for="total" class="form-label">Total</label>

                    <input type="number" name="total" value="${ventas.total}" class="form-control" id="total" required="">
                </div><br>

                <button type="submit" class="btn btn-primary">Procesar</button>
         
            </form>  

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>


