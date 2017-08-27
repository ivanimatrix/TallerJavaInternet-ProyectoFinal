/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.FormularioContactoDAO;
import DAO.FormularioContactoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.FormularioContactoDTO;

/**
 *
 * @author ivanimatrix
 */
public class ContactoController extends HttpServlet {

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
        
        switch(action) {
            case "enviarFormularioContacto" :
                enviarFormularioContacto(request, response);
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

    protected void enviarFormularioContacto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String mensaje = request.getParameter("mensaje");
        
        boolean estado = false;
        String mensaje_final = "";
        
        FormularioContactoDAOImpl formularioContactoDAO = new FormularioContactoDAOImpl();
        FormularioContactoDTO formularioContacto = new FormularioContactoDTO();
        
        try{
            formularioContacto.setNombres_contacto(nombres);
            formularioContacto.setApellidos_contacto(apellidos);
            formularioContacto.setEmail_contacto(email);
            formularioContacto.setTelefono_contacto(telefono);
            formularioContacto.setMensaje_contacto(mensaje);
            
            if(formularioContactoDAO.insert(formularioContacto) > 0){
                estado = true;
                mensaje_final = "Su mensaje ha sido enviado. Pronto nos estaremos comunicando con Ud. Gracias";
            }else{
                mensaje_final = "Hubo un problema al enviar su mensaje. Intente nuevamente";
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            mensaje_final = "Hubo un problema al enviar su mensaje. Intente nuevamente";
        }
        
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String respuesta = "{\"estado\":" + estado + ", \"mensaje\":\"" + mensaje_final + "\"}";
        
        out.println(respuesta);
        
    }
}
