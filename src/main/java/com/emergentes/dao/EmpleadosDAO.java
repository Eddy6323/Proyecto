
package com.emergentes.dao;

import com.emergentes.modelo.Empleados;
import java.util.List;

public interface EmpleadosDAO {
    public void insert(Empleados empleado) throws Exception;
    public void update(Empleados empleado) throws Exception;
    public void delete(int id) throws Exception;
    public Empleados getById(int id) throws Exception;
    public List<Empleados> getAll() throws Exception; 
}
