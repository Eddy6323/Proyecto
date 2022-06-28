
package com.emergentes.dao;

import com.emergentes.modelo.Usuarios;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UsuariosDAOimpl extends ConexionDB implements UsuariosDAO {

    @Override
    public void insert(Usuarios usuario) throws Exception {
        String sql = "insert into usuarios (usuario,correo,cargo,password) values(?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, usuario.getUsuario());
        ps.setString(2, usuario.getCorreo());
        ps.setString(3, usuario.getCargo());
        ps.setString(4, usuario.getPassword());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Usuarios usuario) throws Exception {
        String sql = "update usuarios set usuario=?,correo=?,cargo=?,password=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, usuario.getUsuario());
        ps.setString(2, usuario.getCorreo());
        ps.setString(3, usuario.getCargo());
        ps.setString(4, usuario.getPassword());
        ps.setInt(5, usuario.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from usuarios where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Usuarios getById(int id) throws Exception {
        Usuarios usu = new Usuarios();
        String sql = "select * from usuarios where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            usu.setId(rs.getInt("id"));
            usu.setUsuario(rs.getString("usuario"));
            usu.setCorreo(rs.getString("correo"));
            usu.setCargo(rs.getString("cargo"));
            usu.setPassword(rs.getString("password"));
        }
        this.desconectar();
        return usu;
    }

    @Override
    public List<Usuarios> getAll() throws Exception {
        List<Usuarios> lista = null;
        String sql = "select * from usuarios";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Usuarios>();
        while (rs.next()) {            
            Usuarios usu = new Usuarios();
            usu.setId(rs.getInt("id"));
            usu.setUsuario(rs.getString("usuario"));
            usu.setCorreo(rs.getString("correo"));
            usu.setCargo(rs.getString("cargo"));
            usu.setPassword(rs.getString("password"));
            lista.add(usu);
        }
        this.desconectar();
        return lista;
    }
    
}
