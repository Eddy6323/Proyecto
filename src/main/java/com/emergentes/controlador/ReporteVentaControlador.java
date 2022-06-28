
package com.emergentes.controlador;

import com.emergentes.dao.ProductosDAO;
import com.emergentes.dao.ProductosDAOimpl;
import com.emergentes.dao.VentasDAO;
import com.emergentes.dao.VentasDAOimpl;
import com.emergentes.modelo.Productos;
import com.emergentes.modelo.Ventas;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReporteVentaControlador", urlPatterns = {"/ReporteVentaControlador"})
public class ReporteVentaControlador extends HttpServlet {

    
  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          try {
            VentasDAO dao = new VentasDAOimpl();
            ProductosDAO daoProductos = new ProductosDAOimpl();
            List<Productos> lista_productos = null;
            Ventas reporte = new Ventas();
           
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "add";
            switch (action) {
               
                case "add":
                    lista_productos = daoProductos.getAll();
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("reporte", reporte);
                    request.getRequestDispatcher("frnreporteventa.jsp").forward(request, response);
                    break;
                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
        VentasDAO dao = new VentasDAOimpl();
          int product;
            String fecha1,fecha2;
                       product = Integer.parseInt(request.getParameter("product"));
                    fecha1= request.getParameter("fecha1");
                    fecha2= request.getParameter("fecha2");
                    List<Ventas> lista= dao.getReport(fecha1, fecha2, product);
                    request.setAttribute("reporte", lista);
                    request.getRequestDispatcher("reporteventa.jsp").forward(request, response);
            
                    } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
