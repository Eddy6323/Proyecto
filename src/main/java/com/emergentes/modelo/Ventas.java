
package com.emergentes.modelo;

public class Ventas {
    private int id;
    private int producto;
    private int precventa;
    private int cantidad;
    private String fechareg;
    private int cliente;
    private int empleado;
    private int total;
    private String nom_producto;
    private String nom_cliente;
    private String nom_empleado;


    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }

    public String getNom_empleado() {
        return nom_empleado;
    }

    /* public Ventas() {
    this.id = 0;
    this.producto = "";
    this.precventa = 0;
    this.cantidad = 0;
    this.fechareg = "";
    this.cliente = 0;
    this.empleado = 0;
    this.total = 0;
    }*/
    public void setNom_empleado(String nom_empleado) {
        this.nom_empleado = nom_empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getPrecventa() {
        return precventa;
    }

    public void setPrecventa(int precventa) {
        this.precventa = precventa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechareg() {
        return fechareg;
    }

    public void setFechareg(String fechareg) {
        this.fechareg = fechareg;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Ventas{" + "id=" + id + ", producto=" + producto + ", precventa=" + precventa + ", cantidad=" + cantidad + ", fechareg=" + fechareg + ", cliente=" + cliente + ", empleado=" + empleado + ", total=" + total + ", nom_producto=" + nom_producto + ", nom_cliente=" + nom_cliente + ", nom_empleado=" + nom_empleado + '}';
    }

   
    
}
