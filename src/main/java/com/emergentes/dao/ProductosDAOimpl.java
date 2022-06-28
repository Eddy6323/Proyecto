
package com.emergentes.dao;

import com.emergentes.modelo.Productos;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductosDAOimpl extends ConexionDB implements ProductosDAO {

    @Override
    public void insert(Productos producto) throws Exception {
        String sql = "insert into productos (numproducto,precio,fecha,disponibilidad) values(?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, producto.getNumproducto());
        ps.setInt(2, producto.getPrecio());
        ps.setString(3, producto.getFecha());
        ps.setInt(4, producto.getDisponibilidad());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Productos producto) throws Exception {
         String sql = "update productos set numproducto=?,precio=?,fecha=?,disponibilidad=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, producto.getNumproducto());
        ps.setInt(2, producto.getPrecio());
        ps.setString(3, producto.getFecha());
        ps.setInt(4, producto.getDisponibilidad());
        ps.setInt(5, producto.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from productos where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Productos getById(int id) throws Exception {
        Productos pro = new Productos();
        String sql = "select * from productos where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            pro.setId(rs.getInt("id"));
            pro.setNumproducto(rs.getInt("numproducto"));
            pro.setPrecio(rs.getInt("precio"));
            pro.setFecha(rs.getString("fecha"));
            pro.setDisponibilidad(rs.getInt("disponibilidad"));
        }
        this.desconectar();
        return pro;
    }

    @Override
    public List<Productos> getAll() throws Exception {
        List<Productos> lista = null;
        String sql = "select p.*,c.producto from productos p left join compras c on p.numproducto=c.id";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Productos>();
        while (rs.next()) {            
            Productos pro = new Productos();
            pro.setId(rs.getInt("id"));
            pro.setNumproducto(rs.getInt("numproducto"));
            pro.setPrecio(rs.getInt("precio"));
            pro.setFecha(rs.getString("fecha"));
            pro.setDisponibilidad(rs.getInt("disponibilidad"));
            pro.setProducto(rs.getString("producto"));
            lista.add(pro);
        }
        this.desconectar();
        return lista;
    }
    
}
