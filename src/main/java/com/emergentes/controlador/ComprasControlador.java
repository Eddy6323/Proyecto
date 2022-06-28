
package com.emergentes.controlador;

import com.emergentes.dao.ComprasDAO;
import com.emergentes.dao.ComprasDAOimpl;
import com.emergentes.dao.ProveedorDAO;
import com.emergentes.dao.ProveedorDAOimpl;
import com.emergentes.modelo.Compras;
import com.emergentes.modelo.Proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ComprasControlador", urlPatterns = {"/ComprasControlador"})
public class ComprasControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ComprasDAO dao = new ComprasDAOimpl();
            ProveedorDAO daoProveedor = new ProveedorDAOimpl();
            Compras com = new Compras();
            int id;
             List<Proveedor> lista_proveedor = null;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_proveedor= daoProveedor.getAll();
                    request.setAttribute("lista_proveedor", lista_proveedor);
                    request.setAttribute("compras", com);
                    request.getRequestDispatcher("frmcompras.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    com = dao.getById(id);
                    lista_proveedor= daoProveedor.getAll();
                    request.setAttribute("lista_proveedor", lista_proveedor);
                    request.setAttribute("compras", com);
                    request.getRequestDispatcher("frmcompras.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ComprasControlador");
                    break;
                case "view":
                    List<Compras> lista = dao.getAll();
                    request.setAttribute("compras", lista);
                    request.getRequestDispatcher("compras.jsp").forward(request, response);
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
        String producto = request.getParameter("producto");
        int preciocompra = Integer.parseInt(request.getParameter("preciocompra"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String fechareg = request.getParameter("fechareg");
        int proveedor = Integer.parseInt(request.getParameter("proveedor"));
        int total = Integer.parseInt(request.getParameter("total"));
        Compras com = new Compras();
        com.setId(id);
        com.setProducto(producto);
        com.setPreciocompra(preciocompra);
        com.setCantidad(cantidad);
        com.setFechareg(fechareg);
        com.setProveedor(proveedor);
        com.setTotal(total);
        ComprasDAO dao = new ComprasDAOimpl();
        
            if (id == 0) {
            try {
                // Nuevo
                dao.insert(com);
            } catch (Exception ex) {
                System.out.println("Error al Insertar: "  + ex.getMessage());
            }
        } else {
            try {
                // Edicion
                dao.update(com);
            } catch (Exception ex) {
                System.out.println("Error al Actualizar: " + ex.getMessage());
            }
        }
        
        response.sendRedirect("ComprasControlador");
      
    }

   
}
