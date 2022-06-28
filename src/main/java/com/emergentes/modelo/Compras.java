
package com.emergentes.modelo;

public class Compras {
    private int id;
    private String producto;
    private int preciocompra;
    private int cantidad;
    private String fechareg;
    private int proveedor;
    private int total;
    private String empresa;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(int preciocompra) {
        this.preciocompra = preciocompra;
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

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Compras{" + "id=" + id + ", producto=" + producto + ", preciocompra=" + preciocompra + ", cantidad=" + cantidad + ", fechareg=" + fechareg + ", proveedor=" + proveedor + ", total=" + total + ", empresa=" + empresa + '}';
    }

 

   
   
    
    
    
    
    
}
