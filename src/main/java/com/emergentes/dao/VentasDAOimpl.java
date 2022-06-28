package com.emergentes.dao;

import com.emergentes.modelo.Ventas;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentasDAOimpl extends ConexionDB implements VentasDAO {

    @Override
    public void insert(Ventas venta) throws Exception {
        String sql = "insert into ventas (producto,precventa,cantidad,fechareg,cliente,empleado,total) values(?,?,?,?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, venta.getProducto());
        ps.setInt(2, venta.getPrecventa());
        ps.setInt(3, venta.getCantidad());
        ps.setString(4, venta.getFechareg());
        ps.setInt(5, venta.getCliente());
        ps.setInt(6, venta.getEmpleado());
        ps.setInt(7, venta.getTotal());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Ventas venta) throws Exception {
        String sql = "update ventas set producto=?,precventa=?,cantidad=?,fechareg=?,cliente=?,empleado=?,total=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, venta.getProducto());
        ps.setInt(2, venta.getPrecventa());
        ps.setInt(3, venta.getCantidad());
        ps.setString(4, venta.getFechareg());
        ps.setInt(5, venta.getCliente());
        ps.setInt(6, venta.getEmpleado());
        ps.setInt(7, venta.getTotal());
        ps.setInt(8, venta.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from ventas where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Ventas getById(int id) throws Exception {
        Ventas ven = new Ventas();
        String sql = "select * from ventas where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ven.setId(rs.getInt("id"));
            ven.setProducto(rs.getInt("producto"));
            ven.setPrecventa(rs.getInt("precventa"));
            ven.setCantidad(rs.getInt("cantidad"));
            ven.setFechareg(rs.getString("fechareg"));
            ven.setCliente(rs.getInt("cliente"));
            ven.setEmpleado(rs.getInt("empleado"));
            ven.setTotal(rs.getInt("total"));
        }
        this.desconectar();
        return ven;
    }

    @Override
    public List<Ventas> getAll() throws Exception {
        List<Ventas> lista = null;
        String sql = "select v.*,c.producto as nom_producto,cl.nombres as nom_cliente,e.nombres as nom_empleado from productos p,compras c,ventas v,empleados e,clientes cl where p.numproducto=c.id and  v.producto=p.numproducto and v.cliente=cl.id and v.empleado=e.id";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Ventas>();
        while (rs.next()) {
            Ventas ven = new Ventas();
            ven.setId(rs.getInt("id"));
            ven.setProducto(rs.getInt("producto"));
            ven.setPrecventa(rs.getInt("precventa"));
            ven.setCantidad(rs.getInt("cantidad"));
            ven.setFechareg(rs.getString("fechareg"));
            ven.setCliente(rs.getInt("cliente"));
            ven.setEmpleado(rs.getInt("empleado"));
            ven.setTotal(rs.getInt("total"));
            ven.setNom_producto(rs.getString("nom_producto"));
            ven.setNom_cliente(rs.getString("nom_cliente"));
            ven.setNom_empleado(rs.getString("nom_empleado"));
            lista.add(ven);
        }
        this.desconectar();
        return lista;
    }

    @Override
    public List<Ventas> getReport(String fecha1, String fecha2, int product) throws Exception {
        List<Ventas> lista = null;
        String sql = "select v.*,c.producto as nom_producto,cl.nombres as nom_cliente,e.nombres as nom_empleado from productos p,compras c,ventas v,empleados e,clientes cl where p.numproducto=c.id and  v.producto=p.numproducto and v.cliente=cl.id and v.empleado=e.id and v.fechareg between ? and ? and v.producto = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, fecha1);
        ps.setString(2, fecha2);
        ps.setInt(3, product);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Ventas>();
        while (rs.next()) {
            Ventas ven = new Ventas();
            ven.setId(rs.getInt("id"));
            ven.setProducto(rs.getInt("producto"));
            ven.setPrecventa(rs.getInt("precventa"));
            ven.setCantidad(rs.getInt("cantidad"));
            ven.setFechareg(rs.getString("fechareg"));
            ven.setCliente(rs.getInt("cliente"));
            ven.setEmpleado(rs.getInt("empleado"));
            ven.setTotal(rs.getInt("total"));
            ven.setNom_producto(rs.getString("nom_producto"));
            ven.setNom_cliente(rs.getString("nom_cliente"));
            ven.setNom_empleado(rs.getString("nom_empleado"));
            lista.add(ven);
        }
        this.desconectar();
        return lista;
    }

}
