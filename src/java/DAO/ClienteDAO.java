/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.List;
import models.ClienteDTO;

/**
 *
 * @author ivanimatrix
 */
public interface ClienteDAO {
    
    public int insert(ClienteDTO cliente) throws SQLException;
    
    public int update(ClienteDTO cliente) throws SQLException;
    
    public int delete(int id_cliente) throws SQLException;
	
    public List<ClienteDTO> select() throws SQLException;
        
    public ClienteDTO selectById(int id_cliente) throws SQLException;
        
    public int contarClientes() throws SQLException;
}
