package com.emergentes.controlador;

import com.emergentes.dao.ClientesDAO;
import com.emergentes.dao.ClientesDAOimpl;
import com.emergentes.dao.ComprasDAO;
import com.emergentes.dao.ComprasDAOimpl;
import com.emergentes.dao.EmpleadosDAO;
import com.emergentes.dao.EmpleadosDAOimpl;
import com.emergentes.dao.ProductosDAO;
import com.emergentes.dao.ProductosDAOimpl;
import com.emergentes.dao.VentasDAO;
import com.emergentes.dao.VentasDAOimpl;
import com.emergentes.modelo.Clientes;
import com.emergentes.modelo.Compras;
import com.emergentes.modelo.Empleados;
import com.emergentes.modelo.Productos;
import com.emergentes.modelo.Ventas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VentasControlador", urlPatterns = {"/VentasControlador"})
public class VentasControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            VentasDAO dao = new VentasDAOimpl();
            /// ComprasDAO daoCompras= new ComprasDAOimpl();
            ProductosDAO daoProductos = new ProductosDAOimpl();
            ClientesDAO daoClientes = new ClientesDAOimpl();
            EmpleadosDAO daoEmpleados = new EmpleadosDAOimpl();
            List<Clientes> lista_clientes = null;
            List<Empleados> lista_empleados = null;
            // List<Compras> lista_compras = null;
            List<Productos> lista_productos = null;
            Ventas ventas = new Ventas();
            int id;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_clientes = daoClientes.getAll();
                    lista_empleados = daoEmpleados.getAll();
                    //lista_compras = daoCompras.getAll();
                    lista_productos = daoProductos.getAll();
                     request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_clientes", lista_clientes);
                    request.setAttribute("lista_empleados", lista_empleados);
                   // request.setAttribute("lista_compras", lista_compras);
                   
                    request.setAttribute("ventas", ventas);
                    request.getRequestDispatcher("frmventas.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    ventas = dao.getById(id);
                    lista_clientes = daoClientes.getAll();
                    lista_empleados = daoEmpleados.getAll();
                    lista_productos = daoProductos.getAll();
                   // lista_compras = daoCompras.getAll();
                    // request.setAttribute("lista_compras", lista_compras);
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_clientes", lista_clientes);
                    request.setAttribute("lista_empleados", lista_empleados);
                    request.setAttribute("ventas", ventas);
                    request.getRequestDispatcher("frmventas.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("VentasControlador");
                    break;
                case "view":
                    List<Ventas> lista = dao.getAll();
                    request.setAttribute("ventas", lista);
                    request.getRequestDispatcher("ventas.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int producto = Integer.parseInt(request.getParameter("producto"));
        int precventa = Integer.parseInt(request.getParameter("precventa"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String fechareg = request.getParameter("fechareg");
        int cliente = Integer.parseInt(request.getParameter("cliente"));
        int empleado = Integer.parseInt(request.getParameter("empleado"));
        int total = Integer.parseInt(request.getParameter("total"));
        Ventas ven = new Ventas();
        ven.setId(id);
        ven.setProducto(producto);
        ven.setPrecventa(precventa);
        ven.setCantidad(cantidad);
        ven.setFechareg(fechareg);
        ven.setCliente(cliente);
        ven.setEmpleado(empleado);
        ven.setTotal(total);
        VentasDAO dao = new VentasDAOimpl();

        if (id == 0) {
            try {
                // Nuevo
                dao.insert(ven);
            } catch (Exception ex) {
                System.out.println("Error al Insertar: " + ex.getMessage());
            }
        } else {
            try {
                // Edicion
                dao.update(ven);
            } catch (Exception ex) {
                System.out.println("Error al Actualizar: " + ex.getMessage());
            }
        }

        response.sendRedirect("VentasControlador");

    }

}
