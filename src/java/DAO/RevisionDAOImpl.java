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
import models.RevisionDTO;

/**
 *
 * @author ivanimatrix
 */
public class RevisionDAOImpl implements RevisionDAO{
    
    private Connection userConn;    

    public RevisionDAOImpl() {
    }

    public RevisionDAOImpl(Connection userConn) {
        this.userConn = userConn;
    }
    
    

    @Override
    public int insert(RevisionDTO revision) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            String SQL_INSERT = "insert into revision(fk_vehiculo_revision, estado_revision) values(?,?)";
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT ,Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, revision.getFk_vehiculo_revision());
            stmt.setInt(2, revision.getEstado_revision());

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
    public int update(RevisionDTO revision) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            String SQL_UPDATE = "update revision set fk_vehiculo_revision = ?, estado_revision = ? where id_revision = ?";
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, revision.getFk_vehiculo_revision());
            stmt.setInt(2, revision.getEstado_revision());
            stmt.setInt(3, revision.getId_revision());
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
    public int delete(int id_revision) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            String SQL_DELETE = "delete from revision where id_revision = ?";
            conn = (this.userConn != null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_revision);
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
    public List<RevisionDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        RevisionDTO revisionDTO = null;
        List<RevisionDTO> revisiones = new ArrayList<RevisionDTO>();
        try{
            String SQL_SELECT = "select id_revision, fk_vehiculo_revision, estado_revision from revision";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                revisionDTO = new RevisionDTO();
                revisionDTO.setId_revision(rs.getInt("id_revision"));
                revisionDTO.setFk_vehiculo_revision(rs.getInt("fk_vehiculo_revision"));
                revisionDTO.setEstado_revision(rs.getInt("estado_revision"));
                revisiones.add(revisionDTO);

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                    Conexion.close(conn);
            }
        }

        return revisiones;
    }

    @Override
    public List<RevisionDTO> selectByVehiculo(int id_vehiculo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        RevisionDTO revisionDTO = null;
        List<RevisionDTO> revisiones = new ArrayList<RevisionDTO>();
        try{
            String SQL_SELECT = "select id_revision, fk_vehiculo_revision, estado_revision from revision where fk_vehiculo_revision = ?";
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, id_vehiculo);
            rs = stmt.executeQuery();
            while(rs.next()){
                revisionDTO = new RevisionDTO();
                revisionDTO.setId_revision(rs.getInt("id_revision"));
                revisionDTO.setFk_vehiculo_revision(rs.getInt("fk_vehiculo_revision"));
                revisionDTO.setEstado_revision(rs.getInt("estado_revision"));
                revisiones.add(revisionDTO);

            }
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn == null){
                    Conexion.close(conn);
            }
        }

        return revisiones;
    }

    @Override
    public int contarRevisionesVehiculo(int id_vehiculo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int total = 0;
        try{
            String SQL_SELECT = "select count(*) as total from revision where fk_vehiculo_revision = ?";
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
    
}
