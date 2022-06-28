
package com.emergentes.dao;

import com.emergentes.modelo.Compras;
import java.util.List;


public interface ComprasDAO {
    public void insert(Compras compra) throws Exception;
    public void update(Compras compra) throws Exception;
    public void delete(int id) throws Exception;
    public Compras getById(int id) throws Exception;
    public List<Compras> getAll() throws Exception;
    public List<Compras> getReport(String fecha1, String fecha2, String product) throws Exception;
}
