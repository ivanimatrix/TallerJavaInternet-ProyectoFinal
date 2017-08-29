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
import models.TrabajoDTO;

/**
 *
 * @author ivanimatrix
 */
public class TrabajoDAOImpl implements TrabajoDAO {
    
    private Connection userConn;

    public TrabajoDAOImpl() {
    }

    public TrabajoDAOImpl(Connection userConn) {
        this.userConn = userConn;
    }

    @Override
    public int insert(TrabajoDTO trabajo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            String SQL_INSERT = "insert into trabajo(fk_mecanico_trabajo, fecha_trabajo, descripcion_trabajo, valor_trabajo, fk_vehiculo_trabajo) values(?,?,?,?,?)";
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, trabajo.getFk_mecanico_trabajo());
            stmt.setString(2, trabajo.getFecha_trabajo());
            stmt.setString(3, trabajo.getDescripcion_trabajo());
            stmt.setInt(4, trabajo.getValor_trabajo());
            stmt.setInt(5, trabajo.getFk_vehiculo_trabajo());

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
    public int update(TrabajoDTO trabajo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            String SQL_UPDATE = "update trabajo set fk_mecanico_trabajo = ?, fecha_trabajo = ?, descripcion_trabajo = ?, valor_trabajo = ?, fk_vehiculo_trabajo = ? where id_trabajo = ?";
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, trabajo.getFk_mecanico_trabajo());
            stmt.setString(2, trabajo.getFecha_trabajo());
            stmt.setString(3, trabajo.getDescripcion_trabajo());
            stmt.setInt(4, trabajo.getValor_trabajo());
            stmt.setInt(5, trabajo.getFk_vehiculo_trabajo());
            stmt.setInt(6, trabajo.getId_trabajo());

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
    public int delete(int id_trabajo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            String SQL_DELETE = "delete from where id_trabajo = ?";
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_trabajo);

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
    public List<TrabajoDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TrabajoDTO trabajoDTO = null;
        List<TrabajoDTO> trabajos = new ArrayList<TrabajoDTO>();
        try{
            String SQL_SELECT = "select id_trabajo, fk_mecanico_trabajo, fecha_trabajo, descripcion_trabajo, valor_trabajo, fk_vehiculo_trabajo from trabajo";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                trabajoDTO = new TrabajoDTO();
                trabajoDTO.setId_trabajo(rs.getInt("id_trabajo"));
                trabajoDTO.setFk_mecanico_trabajo(rs.getInt("fk_mecanico_trabajo"));
                trabajoDTO.setFecha_trabajo(rs.getString("fecha_trabajo"));
                trabajoDTO.setDescripcion_trabajo(rs.getString("descripcion_trabajo"));
                trabajoDTO.setValor_trabajo(rs.getInt("valor_trabajo"));
                trabajoDTO.setFk_vehiculo_trabajo(rs.getInt("fk_vehiculo_trabajo"));
                trabajos.add(trabajoDTO);

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return trabajos;
    }

    @Override
    public List<TrabajoDTO> selectByVehiculo(int id_vehiculo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TrabajoDTO trabajoDTO = null;
        List<TrabajoDTO> trabajos = new ArrayList<TrabajoDTO>();
        try{
            String SQL_SELECT = "select id_trabajo, fk_mecanico_trabajo, fecha_trabajo, descripcion_trabajo, valor_trabajo, fk_vehiculo_trabajo from trabajo where fk_vehiculo_trabajo = ?";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, id_vehiculo);
            rs = stmt.executeQuery();
            while(rs.next()){
                trabajoDTO = new TrabajoDTO();
                trabajoDTO.setId_trabajo(rs.getInt("id_trabajo"));
                trabajoDTO.setFk_mecanico_trabajo(rs.getInt("fk_mecanico_trabajo"));
                trabajoDTO.setFecha_trabajo(rs.getString("fecha_trabajo"));
                trabajoDTO.setDescripcion_trabajo(rs.getString("descripcion_trabajo"));
                trabajoDTO.setValor_trabajo(rs.getInt("valor_trabajo"));
                trabajoDTO.setFk_vehiculo_trabajo(rs.getInt("fk_vehiculo_trabajo"));
                trabajos.add(trabajoDTO);

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return trabajos;
    }

    @Override
    public List<TrabajoDTO> selectByMecanico(int id_mecanico) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TrabajoDTO trabajoDTO = null;
        List<TrabajoDTO> trabajos = new ArrayList<TrabajoDTO>();
        try{
            String SQL_SELECT = "select id_trabajo, fk_mecanico_trabajo, fecha_trabajo, descripcion_trabajo, valor_trabajo, fk_vehiculo_trabajo from trabajo where fk_mecanico_trabajo = ?";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, id_mecanico);
            rs = stmt.executeQuery();
            while(rs.next()){
                trabajoDTO = new TrabajoDTO();
                trabajoDTO.setId_trabajo(rs.getInt("id_trabajo"));
                trabajoDTO.setFk_mecanico_trabajo(rs.getInt("fk_mecanico_trabajo"));
                trabajoDTO.setFecha_trabajo(rs.getString("fecha_trabajo"));
                trabajoDTO.setDescripcion_trabajo(rs.getString("descripcion_trabajo"));
                trabajoDTO.setValor_trabajo(rs.getInt("valor_trabajo"));
                trabajoDTO.setFk_vehiculo_trabajo(rs.getInt("fk_vehiculo_trabajo"));
                trabajos.add(trabajoDTO);

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return trabajos;
    }
    
    
    @Override
    public int contarTrabajosVehiculo(int id_vehiculo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int total = 0;
        try{
            String SQL_SELECT = "select count(*) as total from trabajo where fk_vehiculo_trabajo = ?";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, id_vehiculo);
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
    
    
    @Override
    public int contarTrabajosMecanico(int id_mecanico) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int total = 0;
        try{
            String SQL_SELECT = "select count(*) as total from trabajo where fk_mecanico_trabajo = ?";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, id_mecanico);
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
