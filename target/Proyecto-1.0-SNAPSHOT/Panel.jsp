<%
    if (session.getAttribute("logueado") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/stilos_boton.css" media="all" />
        <script src="https://kit.fontawesome.com/a9c5650905.js" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div style="text-align:center;">
            <br><h1>PANEL DE CONTROL DE VENTA Y COMPRAS</h1><br><br>
            <a href="UsuariosControlador"><button type="buton" class="boton")"><i class="fa-solid fa-circle-user"></i><br>USUARIOS</button></a>
            <a href="ProductosControlador"><button type="buton" class="boton")"><i class="fa-solid fa-couch"></i><br>PRODUCTOS</button></a>
            <a href="EmpleadosControlador"><button type="buton" class="boton"><i class="fa-solid fa-helmet-safety"></i><br>EMPLEADOS</button><br></a>
            <a href="ClientesControlador"><button type="buton" class="boton"><i class="fa-solid fa-people-group"></i><br>CLIENTES</button></a>
            <a href="ComprasControlador"><button type="buton" class="boton"><i class="fa-solid fa-basket-shopping"></i><br>COMPRAS</button></a>
            <a href="VentasControlador"><button type="buton" class="boton")"><i class="fa-solid fa-cash-register"></i><br>VENTAS</button><br>
            <a href="ProveedorControlador"><button type="buton" class="boton"><i class="fa-solid fa-truck-front"></i><br>PROVEEDOR</button></a>
            <a href="ReporteVentaControlador"><button type="buton" class="boton"><i class="fa-solid fa-file-invoice"></i><br>REPORTE VENTAS</button></a>
            <a href="ReporteCompraControlador"><button type="buton" class="boton"><i class="fa-solid fa-file-invoice-dollar"></i><br>REPORTE COMPRAS</button></a>
        </div>
        <div>
            <br><a href="LoginControlador?action=logout"><button type="buton"  class="boton2" ><i class="fa-solid fa-arrow-right-from-bracket"></i><br>SALIR</button></a>
        </div>
    </body>
</html>
