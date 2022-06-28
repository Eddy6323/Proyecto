<%
    String opcion = request.getParameter("opcion");
%>

<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-dark bg-primary">
        <div class="container">
            
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="#">GESTION DE COMPRAS Y VENTAS</a>
            <div>
             <a href="Panel.jsp" class="btn btn-darck btn-primary" >Volver a Panel</a>
            <a href="LoginControlador?action=logout" class="btn btn-darck btn-primary" >Cerrar sesión</a>
            </div>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link <%=  (opcion.equals("usuarios")) ? "active" : ""%>" href="UsuariosControlador">Usuarios</a>
                    </li >
                    <li class="nav-item">
                        <a class="nav-link <%=  (opcion.equals("productos")) ? "active" : ""%>" href="ProductosControlador">Productos</a>
                    </li
                    <li class="nav-item">
                        <a class="nav-link <%=  (opcion.equals("empleados")) ? "active" : ""%>" href="EmpleadosControlador">Empleados</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%=  (opcion.equals("clientes")) ? "active" : ""%>" href="ClientesControlador">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%=  (opcion.equals("compras")) ? "active" : ""%>" href="ComprasControlador">Compras</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%=  (opcion.equals("ventas")) ? "active" : ""%>" href="VentasControlador">Ventas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%=  (opcion.equals("proveedor")) ? "active" : ""%>" href="ProveedorControlador">Proveedor</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%=  (opcion.equals("reporteventa")) ? "active" : ""%>" href="ReporteVentaControlador">Reporte de Ventas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%=  (opcion.equals("reportecompras")) ? "active" : ""%>" href="ReporteCompraControlador">Reporte de Compras</a>
                    </li>
                                         
                </ul>
                
            </div>
        </div>
    </nav>
</header>
