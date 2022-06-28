
package com.emergentes.dao;

import com.emergentes.modelo.Proveedor;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAOimpl extends ConexionDB implements ProveedorDAO {

    @Override
    public void insert(com.emergentes.modelo.Proveedor proveedor) throws Exception {
        String sql = "insert into proveedor (nombres,apellidos,direccion,empresa,telefono) values(?,?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, proveedor.getNombres());
        ps.setString(2, proveedor.getApellidos());
        ps.setString(3, proveedor.getDireccion());
        ps.setString(4, proveedor.getEmpresa());
        ps.setInt(5, proveedor.getTelefono());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(com.emergentes.modelo.Proveedor proveedor) throws Exception {
        String sql = "update proveedor set nombres=?,apellidos=?,direccion=?,empresa=?,telefono=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
      ps.setString(1, proveedor.getNombres());
        ps.setString(2, proveedor.getApellidos());
        ps.setString(3, proveedor.getDireccion());
        ps.setString(4, proveedor.getEmpresa());
        ps.setInt(5, proveedor.getTelefono());
        ps.setInt(6, proveedor.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from proveedor where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public com.emergentes.modelo.Proveedor getById(int id) throws Exception {
        Proveedor pro = new Proveedor();
        String sql = "select * from proveedor where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {   
            pro.setId(rs.getInt("id"));
            pro.setNombres(rs.getString("nombres"));
            pro.setApellidos(rs.getString("apellidos"));
            pro.setEmpresa(rs.getString("empresa"));
            pro.setDireccion(rs.getString("direccion"));
            pro.setTelefono(rs.getInt("telefono"));
        }
        this.desconectar();
        return pro;
    }

    @Override
    public List<com.emergentes.modelo.Proveedor> getAll() throws Exception {
        List<Proveedor> lista = null;
        String sql = "select * from proveedor";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Proveedor>();
        while (rs.next()) {            
            Proveedor pro = new Proveedor();
            pro.setId(rs.getInt("id"));
            pro.setNombres(rs.getString("nombres"));
            pro.setApellidos(rs.getString("apellidos"));
            pro.setEmpresa(rs.getString("empresa"));
            pro.setDireccion(rs.getString("direccion"));
            pro.setTelefono(rs.getInt("telefono"));
            lista.add(pro);
        }
        this.desconectar();
        return lista;
    }
    
}
