
package com.emergentes.modelo;


public class Usuarios {
    private int id;
    private String usuario;
    private String correo;
    private String cargo;
    private String password;

    public Usuarios() {
        this.id = 0;
        this.usuario = "";
        this.correo = "";
        this.cargo = "";
        this.password = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "id=" + id + ", usuario=" + usuario + ", correo=" + correo + ", cargo=" + cargo + ", password=" + password + '}';
    }

   

    
}
