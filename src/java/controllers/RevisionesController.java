/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.RevisionDAOImpl;
import DAO.UsuarioDAOImpl;
import DAO.VehiculoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.UsuarioDTO;
import models.VehiculoDTO;

/**
 *
 * @author ivanimatrix
 */
public class RevisionesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        switch (action){
            
            case "indexRevisiones" :
                request.getRequestDispatcher("taller/views/revisiones/bandeja_revisiones.jsp").forward(request, response);
                break;
                
            case "buscarPatente" :
                buscarPatente(request, response);
                break;
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    protected void buscarPatente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String patente = request.getParameter("patente");
        
        VehiculoDAOImpl vehiculoDAO = new VehiculoDAOImpl();
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        RevisionDAOImpl revisionDAO = new RevisionDAOImpl();
        
        VehiculoDTO vehiculo = null;
        
        try{
            vehiculo = vehiculoDAO.selectByPatente(patente);
            if(vehiculo != null){
                UsuarioDTO usuario = usuarioDAO.selectById(vehiculo.getFk_cliente_vehiculo());
                int totalRevisiones = revisionDAO.contarRevisionesVehiculo(vehiculo.getId_vehiculo());

                request.setAttribute("vehiculo", vehiculo);
                request.setAttribute("usuario", usuario);
                request.setAttribute("totalRevisiones", totalRevisiones);
            }
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            request.setAttribute("mensajeError", "Hubo un error en la búsqueda");
        }

        request.getRequestDispatcher("taller/views/revisiones/resultado_busqueda.jsp").forward(request, response);
    }

}
