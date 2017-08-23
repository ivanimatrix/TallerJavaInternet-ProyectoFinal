package DAO;

import java.sql.SQLException;
import java.util.List;
import models.UsuarioDTO;

/**
 * Esta interfaz contiene los m�todos abstractos con las 
 * operaciones b�sicas sobre la tabla de Usuario
 * CRUD (Create, Read, Update y Delete)
 * Se debe crear una clase concreta para implementar el
 * c�digo asociado a cada m�todo
 * @author Ubaldo
 *
 */
public interface UsuarioDAO {
	
	public int insert(UsuarioDTO usuario) throws SQLException;
	
	public List<UsuarioDTO> select() throws SQLException;
        
        public UsuarioDTO selectById(int id_usuario) throws SQLException;
        
        public UsuarioDTO validarUsuario(String rut_usuario, String pass_usuario) throws SQLException;
}
