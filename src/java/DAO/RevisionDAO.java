/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.List;
import models.RevisionDTO;

/**
 *
 * @author ivanimatrix
 */
public interface RevisionDAO {
    
    public int insert(RevisionDTO revision) throws SQLException;
    
    public int update(RevisionDTO revision) throws SQLException;
    
    public int delete(int id_revision) throws SQLException;
    
    public List<RevisionDTO> select() throws SQLException;
    
    public List<RevisionDTO> selectByVehiculo(int id_vehiculo) throws SQLException;
    
    public int contarRevisionesVehiculo(int id_vehiculo) throws SQLException;
    
    
}
