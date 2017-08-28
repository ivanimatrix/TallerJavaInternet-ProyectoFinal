/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.UsuarioDAOImpl;
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
public class UsuarioController extends HttpServlet {

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
        
        switch(action){
            case "loginUsuario":
                loginUsuario(request, response);
                break;
                
            case "logoutUsuario" : 
                logoutUsuario(request, response);
                break;
            
            case "miCuenta" : 
                miCuenta(request, response);
                break;
                
            case "guardarMisDatos" : 
                guardarMisDatos(request, response);
                break;
                
            case "guardarPassword" : 
                guardarPassword(request, response);
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
    
    
    protected void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String rut = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        
        String mensaje = "Hubo un problema al validar sus credenciales. Intente nuevamente";
        boolean estado = false;
        
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        UsuarioDTO usuario = null;
        try{
            usuario = usuarioDAO.validarUsuario(rut, pass);
            if(usuario != null){
                estado = true;
                mensaje = "";
                
                HttpSession session = request.getSession();
                
                session.setAttribute("usuario", usuario);
                
            }
            
        }catch(SQLException e){
            System.out.println("Error SQL : " + e.getMessage());
        }
        

        String respuesta = "{\"estado\":" + estado + ", \"mensaje\":\"" + mensaje + "\"}";
        
        out.println(respuesta);
    }
    
    protected void logoutUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        
        String redirect = "/ProyectoTallerMecanico/taller/index.jsp";
        String respuesta = "{\"redirect\":\"" + redirect + "\"}";
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        
        out.println(respuesta);
        
        
    }
    
    
    protected void miCuenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        UsuarioDTO usuarioSession = (UsuarioDTO) session.getAttribute("usuario");
        UsuarioDTO usuario = null;
        
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        
        try{
            usuario = usuarioDAO.selectById(usuarioSession.getId_usuario());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("taller/views/usuarios/mi_cuenta.jsp").forward(request, response);
        
        
    }
    
    
    protected void guardarMisDatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String mensaje = "";
        boolean estado = false;
        
        HttpSession session = request.getSession();
        UsuarioDTO usuarioSession = (UsuarioDTO) session.getAttribute("usuario");
        
        String rut = request.getParameter("rut");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        UsuarioDTO usuario = new UsuarioDTO();
        try{
            usuario.setId_usuario(usuarioSession.getId_usuario());
            usuario.setNombres_usuario(nombres);
            usuario.setApellidos_usuario(apellidos);
            usuario.setRut_usuario(rut);
            usuario.setPerfil_usuario(usuarioSession.getPerfil_usuario());
            if(usuarioDAO.update(usuario) > 0){
                estado = true;
                mensaje = "Sus datos han sido modificados";
                
                session.setAttribute("usuario", usuario);
                
            }else{
                mensaje = "Hubo problemas al actualizar la contraseña. Intente nuevamente";
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            mensaje = "Error interno al actualizar la contraseña. Intente nuevamente";
        }
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String respuesta = "{\"estado\":" + estado + ", \"mensaje\":\"" + mensaje + "\"}";
        PrintWriter out = response.getWriter();
        out.println(respuesta);
        
        
    }
    
    
    protected void guardarPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String mensaje = "";
        boolean estado = false;
        
        HttpSession session = request.getSession();
        UsuarioDTO usuarioSession = (UsuarioDTO) session.getAttribute("usuario");
        
        String pass = request.getParameter("nueva_pass");
        
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        
        try{
            if(usuarioDAO.updatePassword(usuarioSession.getId_usuario(), pass) > 0){
                estado = true;
                mensaje = "Su contraseña ha sido actualizada";
            }else{
                mensaje = "Hubo problemas al actualizar la contraseña. Intente nuevamente";
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            mensaje = "Error interno al actualizar la contraseña. Intente nuevamente";
        }
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String respuesta = "{\"estado\":" + estado + ", \"mensaje\":\"" + mensaje + "\"}";
        PrintWriter out = response.getWriter();
        out.println(respuesta);
        
        
    }

}
