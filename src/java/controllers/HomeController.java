/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.ClienteDAOImpl;
import DAO.MecanicoDAOImpl;
import DAO.TrabajoDAOImpl;
import DAO.VehiculoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.UsuarioDTO;

/**
 *
 * @author ivanimatrix
 */
public class HomeController extends HttpServlet {

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
        
        HttpSession sesion = request.getSession();
        UsuarioDTO user = (UsuarioDTO) sesion.getAttribute("usuario");
        
        switch (user.getPerfil_usuario()) {
            case 1:
                int total_clientes = 0;
                try{
                    ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
                    total_clientes = clienteDAO.contarClientes();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                
                int total_vehiculos = 0;
                try{
                    VehiculoDAOImpl vehiculoDAO = new VehiculoDAOImpl();
                    total_vehiculos = vehiculoDAO.contarVehiculos();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                
                int total_mecanicos = 0;
                try{
                    MecanicoDAOImpl mecanicoDAO = new MecanicoDAOImpl();
                    total_mecanicos = mecanicoDAO.contarMecanicos();
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                
                
                request.setAttribute("total_clientes", total_clientes);
                request.setAttribute("total_vehiculos", total_vehiculos);
                request.setAttribute("total_mecanicos", total_mecanicos);
                request.getRequestDispatcher("taller/views/home/administrador.jsp").forward(request, response);
                break;
            case 2:
                
                int total_trabajos = 0;
                try{
                    TrabajoDAOImpl trabajoDAO = new TrabajoDAOImpl();
                    
                    total_trabajos = trabajoDAO.contarTrabajosMecanico(user.getId_usuario());
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                
                request.setAttribute("total_trabajos", total_trabajos);
                request.getRequestDispatcher("taller/views/home/mecanico.jsp").forward(request, response);
                break;
            case 3:
                int total_vehiculos_cliente = 0;
                try{
                    VehiculoDAOImpl vehiculoDAO = new VehiculoDAOImpl();
                    total_vehiculos_cliente = vehiculoDAO.contarVehiculosCliente(user.getId_usuario());
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                
                request.setAttribute("total_vehiculos", total_vehiculos_cliente);
                request.getRequestDispatcher("taller/views/home/cliente.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("taller/views/404.jsp").forward(request, response);
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
        //processRequest(request, response);
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

}
