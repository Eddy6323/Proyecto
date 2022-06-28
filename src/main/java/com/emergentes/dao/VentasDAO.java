
package com.emergentes.dao;

import com.emergentes.modelo.Ventas;
import java.util.List;

public interface VentasDAO {
    public void insert(Ventas venta) throws Exception;
    public void update(Ventas venta) throws Exception;
    public void delete(int id) throws Exception;
    public Ventas getById(int id) throws Exception;
    public List<Ventas> getAll() throws Exception;
    public List<Ventas> getReport(String fecha1, String fecha2, int product) throws Exception;
}
