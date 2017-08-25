/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.List;
import models.VehiculoDTO;

/**
 *
 * @author ivanimatrix
 */
public interface VehiculoDAO {
    
    public int insert(VehiculoDTO vehiculo) throws SQLException;
    
    public int update(VehiculoDTO vehiculo) throws SQLException;
    
    public int delete(int id_vehiculo) throws SQLException;
	
    public List<VehiculoDTO> select() throws SQLException;
        
    public VehiculoDTO selectById(int id_vehiculo) throws SQLException;
    
    public VehiculoDTO selectByPatente(String patente_vehiculo) throws SQLException;
        
    public int contarVehiculos() throws SQLException;
    
}
