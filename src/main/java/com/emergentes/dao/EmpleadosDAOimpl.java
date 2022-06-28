
package com.emergentes.dao;


import com.emergentes.modelo.Empleados;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosDAOimpl extends ConexionDB implements EmpleadosDAO{

    @Override
    public void insert(Empleados empleado) throws Exception {
         String sql = "insert into empleados (nombres,apellidos,ci,fechanacim,telefono) values(?,?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, empleado.getNombres());
        ps.setString(2, empleado.getApellidos());
        ps.setInt(3, empleado.getCi());
        ps.setString(4, empleado.getFechanacim());
        ps.setInt(5, empleado.getTelefono());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Empleados empleado) throws Exception {
        String sql = "update empleados set nombres=?,apellidos=?,ci=?,fechanacim=?,telefono=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, empleado.getNombres());
        ps.setString(2, empleado.getApellidos());
        ps.setInt(3, empleado.getCi());
        ps.setString(4, empleado.getFechanacim());
        ps.setInt(5, empleado.getTelefono());
        ps.setInt(6, empleado.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from empleados where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Empleados getById(int id) throws Exception {
        Empleados emp = new Empleados();
        String sql = "select * from empleados where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            emp.setId(rs.getInt("id"));
            emp.setNombres(rs.getString("nombres"));
            emp.setApellidos(rs.getString("apellidos"));
            emp.setCi(rs.getInt("ci"));
            emp.setFechanacim(rs.getString("fechanacim"));
            emp.setTelefono(rs.getInt("telefono"));
        }
        this.desconectar();
        return emp;
    }

    @Override
    public List<Empleados> getAll() throws Exception {
        List<Empleados> lista = null;
        String sql = "select * from empleados";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Empleados>();
        while (rs.next()) {            
            Empleados emp = new Empleados();
            emp.setId(rs.getInt("id"));
            emp.setNombres(rs.getString("nombres"));
            emp.setApellidos(rs.getString("apellidos"));
            emp.setCi(rs.getInt("ci"));
            emp.setFechanacim(rs.getString("fechanacim"));
            emp.setTelefono(rs.getInt("telefono"));
            lista.add(emp);
        }
        this.desconectar();
        return lista;
    }
    
}
