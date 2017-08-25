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
import models.MecanicoDTO;

/**
 *
 * @author ivanimatrix
 */
public class MecanicoDAOImpl implements MecanicoDAO{
    
    private Connection userConn;

    public MecanicoDAOImpl() {
    }

    public MecanicoDAOImpl(Connection userConn) {
        this.userConn = userConn;
    }

    @Override
    public int insert(MecanicoDTO mecanico) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            String SQL_INSERT = "insert into mecanico(id_mecanico, especialidad_mecanico) values(?,?)";
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, mecanico.getId_mecanico());
            stmt.setString(2, mecanico.getEspecialidad_mecanico());

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
    public int update(MecanicoDTO mecanico) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            String SQL_UPDATE = "update mecanico set especialidad_mecanico = ? where id_mecanico = ?";
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, mecanico.getEspecialidad_mecanico());
            stmt.setInt(2, mecanico.getId_mecanico());
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
    public int delete(int id_mecanico) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            String SQL_DELETE = "delete from mecanico where id_mecanico = ?";
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_mecanico);
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
    public List<MecanicoDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MecanicoDTO mecanicoDTO = null;
        List<MecanicoDTO> mecanicos = new ArrayList<MecanicoDTO>();
        try{
            String SQL_SELECT = "select id_mecanico, especialidad_mecanico from mecanico";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                mecanicoDTO = new MecanicoDTO();
                mecanicoDTO.setId_mecanico(rs.getInt("id_mecanico"));
                mecanicoDTO.setEspecialidad_mecanico(rs.getString("especialidad_mecanico"));
                mecanicos.add(mecanicoDTO);

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return mecanicos;
    }

    @Override
    public MecanicoDTO selectById(int id_mecanico) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MecanicoDTO mecanicoDTO = null;
        try{
            String SQL_SELECT = "select id_mecanico, especialidad_mecanico from mecanico where id_mecanico = ? limit 1";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, id_mecanico);
            rs = stmt.executeQuery();
            while(rs.next()){
                mecanicoDTO = new MecanicoDTO();
                mecanicoDTO.setId_mecanico(rs.getInt("id_mecanico"));
                mecanicoDTO.setEspecialidad_mecanico(rs.getString("especialidad_mecanico"));

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                Conexion.close(conn);
            }
        }

        return mecanicoDTO;
    }

    @Override
    public int contarMecanicos() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int total = 0;
        try{
            String SQL_SELECT = "select count(*) as total from mecanico";
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
