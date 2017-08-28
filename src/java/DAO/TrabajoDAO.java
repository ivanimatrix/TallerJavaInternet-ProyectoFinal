/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.List;
import models.TrabajoDTO;

/**
 *
 * @author ivanimatrix
 */
public interface TrabajoDAO {
    
    public int insert(TrabajoDTO trabajo) throws SQLException;
    
    public int update(TrabajoDTO trabajo) throws SQLException;
    
    public int delete(int id_trabajo) throws SQLException;
    
    public List<TrabajoDTO> select() throws SQLException;
    
    public List<TrabajoDTO> selectByVehiculo(int id_vehiculo) throws SQLException;
    
    public List<TrabajoDTO> selectByMecanico(int id_mecanico) throws SQLException;
    
    public int contarTrabajosVehiculo(int id_vehiculo) throws SQLException;
    
    
}
