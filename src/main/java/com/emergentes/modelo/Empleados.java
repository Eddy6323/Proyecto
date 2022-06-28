
package com.emergentes.modelo;

public class Empleados {
    private int id;
    private String nombres;
    private String apellidos;
    private int ci;
    private String fechanacim;
    private int telefono;

    public Empleados() {
        this.id = 0;
        this.nombres = "";
        this.apellidos = "";
        this.ci = 0;
        this.fechanacim = "";
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

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getFechanacim() {
        return fechanacim;
    }

    public void setFechanacim(String fechanacim) {
        this.fechanacim = fechanacim;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Empleados{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", ci=" + ci + ", fechanacim=" + fechanacim + ", telefono=" + telefono + '}';
    }
    
    
    
}
