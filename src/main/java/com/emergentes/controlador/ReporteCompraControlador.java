
package com.emergentes.controlador;

import com.emergentes.dao.ComprasDAO;
import com.emergentes.dao.ComprasDAOimpl;
import com.emergentes.modelo.Compras;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ReporteCompraControlador", urlPatterns = {"/ReporteCompraControlador"})
public class ReporteCompraControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          try {
            ComprasDAO dao = new ComprasDAOimpl();
            ComprasDAO daocompras = new ComprasDAOimpl();
            List<Compras> lista_compras = null;
            Compras reporte = new Compras();
           
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "add";
            switch (action) {
               
                case "add":
                    lista_compras = daocompras.getAll();
                    request.setAttribute("lista_compras", lista_compras);
                    request.setAttribute("reporte", reporte);
                    request.getRequestDispatcher("frmreportecompras.jsp").forward(request, response);
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
        ComprasDAO dao = new ComprasDAOimpl();
         
            String fecha1,fecha2,product;
                     product = request.getParameter("product");
                    fecha1= request.getParameter("fecha1");
                    fecha2= request.getParameter("fecha2");
                    List<Compras> lista= dao.getReport(fecha1, fecha2, product);
                    request.setAttribute("reporte", lista);
                    request.getRequestDispatcher("reportecompras.jsp").forward(request, response);
                    } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
}
