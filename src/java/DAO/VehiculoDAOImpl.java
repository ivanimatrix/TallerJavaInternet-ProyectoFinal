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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.ClienteDTO;
import models.VehiculoDTO;

/**
 *
 * @author ivanimatrix
 */
public class VehiculoDAOImpl implements VehiculoDAO{
    
    private Connection userConn;

    public VehiculoDAOImpl() {
    }

    public VehiculoDAOImpl(Connection userConn) {
        this.userConn = userConn;
    }

    @Override
    public int insert(VehiculoDTO vehiculo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            String SQL_INSERT = "insert into vehiculo(patente_vehiculo, marca_vehiculo, modelo_vehiculo, anyo_vehiculo, fk_cliente_vehiculo) values(?,?,?,?,?)";
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, vehiculo.getPatente_vehiculo());
            stmt.setString(2, vehiculo.getMarca_vehiculo());
            stmt.setString(3, vehiculo.getModelo_vehiculo());
            stmt.setInt(4, vehiculo.getAnyo_vehiculo());
            stmt.setInt(5, vehiculo.getFk_cliente_vehiculo());

            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                rows = rs.getInt(1);
            }

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
    public int update(VehiculoDTO vehiculo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            String SQL_UPDATE = "update vehiculo set patente_vehiculo = ?, marca_vehiculo = ?, modelo_vehiculo = ?, anyo_vehiculo = ?, fk_cliente_vehiculo = ? where id_vehiculo = ?";
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vehiculo.getPatente_vehiculo());
            stmt.setString(2, vehiculo.getMarca_vehiculo());
            stmt.setString(3, vehiculo.getModelo_vehiculo());
            stmt.setInt(4, vehiculo.getAnyo_vehiculo());
            stmt.setInt(5, vehiculo.getFk_cliente_vehiculo());
            stmt.setInt(6, vehiculo.getId_vehiculo());
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
    public int delete(int id_vehiculo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            String SQL_DELETE = "delete from vehiculo where id_vehiculo = ?";
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_vehiculo);
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
    public List<VehiculoDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        VehiculoDTO vehiculoDTO = null;
        List<VehiculoDTO> vehiculos = new ArrayList<VehiculoDTO>();
        try{
            String SQL_SELECT = "select id_vehiculo, patente_vehiculo, marca_vehiculo, modelo_vehiculo, anyo_vehiculo, fk_cliente_vehiculo from vehiculo";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                vehiculoDTO = new VehiculoDTO();
                vehiculoDTO.setId_vehiculo(rs.getInt("id_vehiculo"));
                vehiculoDTO.setPatente_vehiculo(rs.getString("patente_vehiculo"));
                vehiculoDTO.setMarca_vehiculo(rs.getString("marca_vehiculo"));
                vehiculoDTO.setModelo_vehiculo(rs.getString("modelo_vehiculo"));
                vehiculoDTO.setAnyo_vehiculo(rs.getInt("anyo_vehiculo"));
                vehiculoDTO.setFk_cliente_vehiculo(rs.getInt("fk_cliente_vehiculo"));
                vehiculos.add(vehiculoDTO);

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return vehiculos;
    }

    @Override
    public VehiculoDTO selectById(int id_vehiculo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        VehiculoDTO vehiculoDTO = null;
        try{
            String SQL_SELECT = "select id_vehiculo, patente_vehiculo, marca_vehiculo, modelo_vehiculo, anyo_vehiculo, fk_cliente_vehiculo from vehiculo where id_vehiculo = ?";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, id_vehiculo);
            rs = stmt.executeQuery();
            while(rs.next()){
                vehiculoDTO = new VehiculoDTO();
                vehiculoDTO.setId_vehiculo(rs.getInt("id_vehiculo"));
                vehiculoDTO.setPatente_vehiculo(rs.getString("patente_vehiculo"));
                vehiculoDTO.setMarca_vehiculo(rs.getString("marca_vehiculo"));
                vehiculoDTO.setModelo_vehiculo(rs.getString("modelo_vehiculo"));
                vehiculoDTO.setAnyo_vehiculo(rs.getInt("anyo_vehiculo"));
                vehiculoDTO.setFk_cliente_vehiculo(rs.getInt("fk_cliente_vehiculo"));

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return vehiculoDTO;
    }

    @Override
    public VehiculoDTO selectByPatente(String patente_vehiculo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        VehiculoDTO vehiculoDTO = null;
        try{
            String SQL_SELECT = "select id_vehiculo, patente_vehiculo, marca_vehiculo, modelo_vehiculo, anyo_vehiculo, fk_cliente_vehiculo from vehiculo where patente_vehiculo = ?";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, patente_vehiculo);
            rs = stmt.executeQuery();
            while(rs.next()){
                vehiculoDTO = new VehiculoDTO();
                vehiculoDTO.setId_vehiculo(rs.getInt("id_vehiculo"));
                vehiculoDTO.setPatente_vehiculo(rs.getString("patente_vehiculo"));
                vehiculoDTO.setMarca_vehiculo(rs.getString("marca_vehiculo"));
                vehiculoDTO.setModelo_vehiculo(rs.getString("modelo_vehiculo"));
                vehiculoDTO.setAnyo_vehiculo(rs.getInt("anyo_vehiculo"));
                vehiculoDTO.setFk_cliente_vehiculo(rs.getInt("fk_cliente_vehiculo"));

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return vehiculoDTO;
    }

    @Override
    public int contarVehiculos() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int total = 0;
        try{
            String SQL_SELECT = "select count(*) as total from vehiculo";
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
