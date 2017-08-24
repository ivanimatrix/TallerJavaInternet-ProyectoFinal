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
import models.ClienteDTO;

/**
 *
 * @author ivanimatrix
 */
public class ClienteDAOImpl implements ClienteDAO {
    
    private Connection userConn;

    public ClienteDAOImpl() {
    }

    public ClienteDAOImpl(Connection userConn) {
        this.userConn = userConn;
    }
    
    

    @Override
    public int insert(ClienteDTO cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            String SQL_INSERT = "insert into cliente(id_cliente, email_cliente, fono_cliente) values(?,?,?)";
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, cliente.getId_cliente());
            stmt.setString(2, cliente.getEmail_cliente());
            stmt.setString(3, cliente.getFono_cliente());

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
    public int update(ClienteDTO cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            String SQL_UPDATE = "update cliente set email_cliente= ?, fono_cliente = ? where id_cliente = ?";
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getEmail_cliente());
            stmt.setString(2, cliente.getFono_cliente());
            stmt.setInt(3, cliente.getId_cliente());
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
    public int delete(int id_cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            String SQL_DELETE = "delete from cliente where id_cliente = ?";
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(3, id_cliente);
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
    public List<ClienteDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ClienteDTO clienteDTO = null;
        List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
        try{
            String SQL_SELECT = "select id_cliente, email_cliente, telefono_cliente from cliente";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                clienteDTO.setId_cliente(rs.getInt("id_cliente"));
                clienteDTO.setEmail_cliente(rs.getString("email_cliente"));
                clienteDTO.setFono_cliente(rs.getString("telefono_cliente"));
                clientes.add(clienteDTO);

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return clientes;
    }

    @Override
    public ClienteDTO selectById(int id_cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ClienteDTO clienteDTO = null;
        try{
            String SQL_SELECT = "select id_cliente, email_cliente, telefono_cliente from cliente";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                clienteDTO.setId_cliente(rs.getInt("id_cliente"));
                clienteDTO.setEmail_cliente(rs.getString("email_cliente"));
                clienteDTO.setFono_cliente(rs.getString("telefono_cliente"));

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return clienteDTO;
    }

    @Override
    public int contarClientes() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int total = 0;
        try{
            String SQL_SELECT = "select count(*) as total from cliente";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                total = rs.getInt("total");
            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return total;
    }
    
}
