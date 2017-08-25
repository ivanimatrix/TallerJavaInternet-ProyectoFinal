/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.List;
import models.MecanicoDTO;

/**
 *
 * @author ivanimatrix
 */
public interface MecanicoDAO {
    
    public int insert(MecanicoDTO mecanico) throws SQLException;
    
    public int update(MecanicoDTO mecanico) throws SQLException;
    
    public int delete(int id_mecanico) throws SQLException;
	
    public List<MecanicoDTO> select() throws SQLException;
        
    public MecanicoDTO selectById(int id_mecanico) throws SQLException;
        
    public int contarMecanicos() throws SQLException;
}
