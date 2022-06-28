package com.emergentes.dao;

import com.emergentes.modelo.Compras;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComprasDAOimpl extends ConexionDB implements ComprasDAO {

    @Override
    public void insert(Compras compra) throws Exception {
        String sql = "insert into compras (producto,preciocompra,cantidad,fechareg,proveedor,total) values(?,?,?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, compra.getProducto());
        ps.setInt(2, compra.getPreciocompra());
        ps.setInt(3, compra.getCantidad());
        ps.setString(4, compra.getFechareg());
        ps.setInt(5, compra.getProveedor());
        ps.setInt(6, compra.getTotal());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Compras compra) throws Exception {
        String sql = "update compras set producto=?,preciocompra=?,cantidad=?,fechareg=?,proveedor=?,total=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, compra.getProducto());
        ps.setInt(2, compra.getPreciocompra());
        ps.setInt(3, compra.getCantidad());
        ps.setString(4, compra.getFechareg());
        ps.setInt(5, compra.getProveedor());
        ps.setInt(6, compra.getTotal());
        ps.setInt(7, compra.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from compras where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Compras getById(int id) throws Exception {
        Compras com = new Compras();
        String sql = "select * from compras where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            com.setId(rs.getInt("id"));
            com.setProducto(rs.getString("producto"));
            com.setPreciocompra(rs.getInt("preciocompra"));
            com.setCantidad(rs.getInt("cantidad"));
            com.setFechareg(rs.getString("fechareg"));
            com.setProveedor(rs.getInt("proveedor"));
            com.setTotal(rs.getInt("total"));
        }
        this.desconectar();
        return com;
    }

    @Override
    public List<Compras> getAll() throws Exception {
        List<Compras> lista = null;
        String sql = "select c.*,p.empresa from compras c left join proveedor p on c.proveedor = p.id";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Compras>();
        while (rs.next()) {
            Compras com = new Compras();
            com.setId(rs.getInt("id"));
            com.setProducto(rs.getString("producto"));
            com.setPreciocompra(rs.getInt("preciocompra"));
            com.setCantidad(rs.getInt("cantidad"));
            com.setFechareg(rs.getString("fechareg"));
            com.setProveedor(rs.getInt("proveedor"));
            com.setTotal(rs.getInt("total"));
            com.setEmpresa(rs.getString("empresa"));
            lista.add(com);
        }
        this.desconectar();
        return lista;
    }

    @Override
    public List<Compras> getReport(String fecha1, String fecha2, String product) throws Exception {
        List<Compras> lista = null;
        String sql = "select c.*,p.empresa from compras c,proveedor p where c.proveedor=p.id and c.fechareg between ? and ? and c.producto=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, fecha1);
        ps.setString(2, fecha2);
        ps.setString(3, product);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Compras>();
        while (rs.next()) {
            Compras com = new Compras();
            com.setId(rs.getInt("id"));
            com.setProducto(rs.getString("producto"));
            com.setPreciocompra(rs.getInt("preciocompra"));
            com.setCantidad(rs.getInt("cantidad"));
            com.setFechareg(rs.getString("fechareg"));
            com.setProveedor(rs.getInt("proveedor"));
            com.setTotal(rs.getInt("total"));
            com.setEmpresa(rs.getString("empresa"));
            lista.add(com);
        }
        this.desconectar();
        return lista;
    }

}
