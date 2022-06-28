
package com.emergentes.dao;

import com.emergentes.modelo.Clientes;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAOimpl extends ConexionDB implements ClientesDAO {

    @Override
    public void insert(Clientes cliente) throws Exception {
        String sql = "insert into clientes (nombres,apellidos,direccion,telefono) values(?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, cliente.getNombres());
        ps.setString(2, cliente.getApellidos());
        ps.setString(3, cliente.getDireccion());
        ps.setInt(4, cliente.getTelefono());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Clientes cliente) throws Exception {
        String sql = "update clientes set nombres=?,apellidos=?,direccion=?,telefono=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, cliente.getNombres());
        ps.setString(2, cliente.getApellidos());
        ps.setString(3, cliente.getDireccion());
        ps.setInt(4, cliente.getTelefono());
        ps.setInt(5, cliente.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from clientes where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Clientes getById(int id) throws Exception {
        Clientes cli = new Clientes();
        String sql = "select * from clientes where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            cli.setId(rs.getInt("id"));
            cli.setNombres(rs.getString("nombres"));
            cli.setApellidos(rs.getString("apellidos"));
            cli.setDireccion(rs.getString("direccion"));
            cli.setTelefono(rs.getInt("telefono"));
        }
        this.desconectar();
        return cli;
    }

    @Override
    public List<Clientes> getAll() throws Exception {
        List<Clientes> lista = null;
        String sql = "select * from clientes";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Clientes>();
        while (rs.next()) {            
            Clientes cli = new Clientes();
            cli.setId(rs.getInt("id"));
            cli.setNombres(rs.getString("nombres"));
            cli.setApellidos(rs.getString("apellidos"));
            cli.setDireccion(rs.getString("direccion"));
            cli.setTelefono(rs.getInt("telefono"));
            lista.add(cli);
        }
        this.desconectar();
        return lista;
    }
    
}
