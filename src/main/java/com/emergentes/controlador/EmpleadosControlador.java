
package com.emergentes.controlador;

import com.emergentes.dao.EmpleadosDAO;
import com.emergentes.dao.EmpleadosDAOimpl;
import com.emergentes.modelo.Empleados;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmpleadosControlador", urlPatterns = {"/EmpleadosControlador"})
public class EmpleadosControlador extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EmpleadosDAO dao = new EmpleadosDAOimpl();
            Empleados emp = new Empleados();
            int id;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("empleado", emp);
                    request.getRequestDispatcher("frmempleados.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    emp = dao.getById(id);
                    request.setAttribute("empleado", emp);
                    request.getRequestDispatcher("frmempleados.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("EmpleadosControlador");
                    break;
                case "view":
                    List<Empleados> lista = dao.getAll();
                    request.setAttribute("empleados", lista);
                    request.getRequestDispatcher("empleados.jsp").forward(request, response);
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
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        int ci = Integer.parseInt(request.getParameter("ci"));
        String fechanacim = request.getParameter("fechanacim");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        Empleados emp = new Empleados();
        emp.setId(id);
        emp.setNombres(nombres);
        emp.setApellidos(apellidos);
        emp.setCi(ci);
        emp.setFechanacim(fechanacim);
        emp.setTelefono(telefono);
        EmpleadosDAO dao = new EmpleadosDAOimpl();
        
            if (id == 0) {
            try {
                // Nuevo
                dao.insert(emp);
            } catch (Exception ex) {
                System.out.println("Error al Insertar: "  + ex.getMessage());
            }
        } else {
            try {
                // Edicion
                dao.update(emp);
            } catch (Exception ex) {
                System.out.println("Error al Actualizar: " + ex.getMessage());
            }
        }
        
        response.sendRedirect("EmpleadosControlador");
      
    }

  
}
