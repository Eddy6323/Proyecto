
package com.emergentes.controlador;

import com.emergentes.dao.ComprasDAO;
import com.emergentes.dao.ComprasDAOimpl;
import com.emergentes.dao.ProductosDAO;
import com.emergentes.dao.ProductosDAOimpl;
import com.emergentes.modelo.Compras;
import com.emergentes.modelo.Productos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ProductosControlador", urlPatterns = {"/ProductosControlador"})
public class ProductosControlador extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            ProductosDAO dao = new ProductosDAOimpl();
            Productos pro = new Productos();
            ComprasDAO daocompra= new ComprasDAOimpl();
            int id;
            List<Compras> lista_compras = null;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_compras=daocompra.getAll();
                    request.setAttribute("lista_compras", lista_compras);
                    request.setAttribute("productos", pro);
                    request.getRequestDispatcher("frmproductos.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    pro = dao.getById(id);
                    lista_compras=daocompra.getAll();
                    request.setAttribute("lista_compras", lista_compras);
                    request.setAttribute("productos", pro);
                    request.getRequestDispatcher("frmproductos.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ProductosControlador");
                    break;
                case "view":
                    List<Productos> lista = dao.getAll();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
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
        int numproducto = Integer.parseInt(request.getParameter("numproducto"));
        int precio = Integer.parseInt(request.getParameter("precio"));
        String fecha = request.getParameter("fecha");
        int disponibilidad = Integer.parseInt(request.getParameter("disponibilidad"));
        Productos pro = new Productos();
        pro.setId(id);
        pro.setNumproducto(numproducto);
        pro.setPrecio(precio);
        pro.setFecha(fecha);
        pro.setDisponibilidad(disponibilidad);
        ProductosDAO dao = new ProductosDAOimpl();
        
            if (id == 0) {
            try {
                // Nuevo
                dao.insert(pro);
            } catch (Exception ex) {
                System.out.println("Error al Insertar: "  + ex.getMessage());
            }
        } else {
            try {
                // Edicion
                dao.update(pro);
            } catch (Exception ex) {
                System.out.println("Error al Actualizar: " + ex.getMessage());
            }
        }
        
        response.sendRedirect("ProductosControlador");
      
    }

 
}
