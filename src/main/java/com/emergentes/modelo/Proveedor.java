
package com.emergentes.modelo;

public class Proveedor {
   private int id;
   private String nombres;
   private String apellidos;
   private String direccion;
   private String empresa;
   private int telefono;

    public Proveedor() {
        this.id = 0;
        this.nombres = "";
        this.apellidos = "";
        this.direccion = "";
        this.empresa = "";
        this.telefono = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", empresa=" + empresa + ", telefono=" + telefono + '}';
    }
   
   
}
