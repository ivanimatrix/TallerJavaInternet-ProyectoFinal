/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.FormularioContactoDTO;

/**
 *
 * @author ivanimatrix
 */
public class FormularioContactoDAOImpl implements FormularioContactoDAO {
    
    private Connection userConn;

    public FormularioContactoDAOImpl() {
    }

    public FormularioContactoDAOImpl(Connection userConn) {
        this.userConn = userConn;
    }

    @Override
    public int insert(FormularioContactoDTO contacto) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            String SQL_INSERT = "insert into formulario_contacto(nombres_contacto, apellidos_contacto, email_contacto, telefono_contacto, mensaje_contacto, fecha_contacto) values(?,?,?,?,?,NOW())";
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, contacto.getNombres_contacto());
            stmt.setString(2, contacto.getApellidos_contacto());
            stmt.setString(3, contacto.getEmail_contacto());
            stmt.setString(4, contacto.getTelefono_contacto());
            stmt.setString(5, contacto.getMensaje_contacto());

            rows = stmt.executeUpdate();

        }catch(SQLException e){
            rows = 0;
            System.out.println(e.getMessage());
        }
        finally{
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return rows;
    }

    @Override
    public List<FormularioContactoDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        FormularioContactoDTO formularioContactoDTO = null;
        List<FormularioContactoDTO> contactos = new ArrayList<FormularioContactoDTO>();
        try{
            String SQL_SELECT = "select id_contacto, nombres_contacto, apellidos_contacto, email_contacto, telefono_contacto, mensaje_contacto, fecha_contacto from formulario_contacto";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                formularioContactoDTO = new FormularioContactoDTO();
                formularioContactoDTO.setId_contacto(rs.getInt("id_contacto"));
                formularioContactoDTO.setNombres_contacto(rs.getString("nombres_contacto"));
                formularioContactoDTO.setApellidos_contacto(rs.getString("apellidos_contacto"));
                formularioContactoDTO.setEmail_contacto(rs.getString("email_contacto"));
                formularioContactoDTO.setTelefono_contacto(rs.getString("telefono_contacto"));
                formularioContactoDTO.setMensaje_contacto(rs.getString("mensaje_contacto"));
                formularioContactoDTO.setFecha_contacto(rs.getString("fecha_contacto"));
                contactos.add(formularioContactoDTO);

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return contactos;
    }

    @Override
    public FormularioContactoDTO selectById(int id_contacto) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        FormularioContactoDTO formularioContactoDTO = null;
        try{
            String SQL_SELECT = "select id_contacto, nombres_contacto, apellidos_contacto, email_contacto, telefono_contacto, mensaje_contacto, fecha_contacto from formulario_contacto where id_contacto = ?";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, id_contacto);
            rs = stmt.executeQuery();
            while(rs.next()){
                formularioContactoDTO = new FormularioContactoDTO();
                formularioContactoDTO.setId_contacto(rs.getInt("id_contacto"));
                formularioContactoDTO.setNombres_contacto(rs.getString("nombres_contacto"));
                formularioContactoDTO.setApellidos_contacto(rs.getString("apellidos_contacto"));
                formularioContactoDTO.setEmail_contacto(rs.getString("email_contacto"));
                formularioContactoDTO.setTelefono_contacto(rs.getString("telefono_contacto"));
                formularioContactoDTO.setMensaje_contacto(rs.getString("mensaje_contacto"));
                formularioContactoDTO.setFecha_contacto(rs.getString("fecha_contacto"));

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return formularioContactoDTO;
    }
    
    
    
}
