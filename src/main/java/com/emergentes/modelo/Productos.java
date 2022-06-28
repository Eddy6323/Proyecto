
package com.emergentes.modelo;

public class Productos {
   private int id;
   private int numproducto;
   private int precio;
   private String fecha ;
   private int disponibilidad;
   private String producto;


    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumproducto() {
        return numproducto;
    }

    public void setNumproducto(int numproducto) {
        this.numproducto = numproducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Productos{" + "id=" + id + ", numproducto=" + numproducto + ", precio=" + precio + ", fecha=" + fecha + ", disponibilidad=" + disponibilidad + ", producto=" + producto + '}';
    }

    
   
   
}
