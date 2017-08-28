/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.List;
import models.FormularioContactoDTO;

/**
 *
 * @author ivanimatrix
 */
public interface FormularioContactoDAO {
    
    public int insert(FormularioContactoDTO contacto) throws SQLException;
    
    public List<FormularioContactoDTO> select() throws SQLException;
    
    public FormularioContactoDTO selectById(int id_contacto) throws SQLException;
    
}
