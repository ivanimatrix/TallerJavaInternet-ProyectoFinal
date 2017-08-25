/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.MecanicoDAOImpl;
import DAO.UsuarioDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.MecanicoDTO;
import models.UsuarioDTO;

/**
 *
 * @author ivanimatrix
 */
public class MecanicosController extends HttpServlet {

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
            
            case "indexMecanicos" :
                request.getRequestDispatcher("taller/views/mantenedores/mecanicos/bandeja_mecanicos.jsp").forward(request, response);
                break;
                
            case "listadoMecanicos" : 
                listadoMecanicos(request, response);
                break;
                
            case "nuevoMecanico" : 
                nuevoMecanico(request, response);
                break;
                
            case "guardarMecanico" : 
                guardarMecanico(request, response);
                break;
                
            case "editarMecanico" : 
                editarMecanico(request, response);
                break;
                
            case "eliminarMecanico" : 
                eliminarMecanico(request, response);
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
    
    
    protected void listadoMecanicos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        MecanicoDAOImpl mecanicoDAO = new MecanicoDAOImpl();
        List<MecanicoDTO> mecanicos = null;
        
        try{
            mecanicos = mecanicoDAO.select();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("mecanicos", mecanicos);
        request.getRequestDispatcher("taller/views/mantenedores/mecanicos/grilla_mecanicos.jsp").forward(request, response);
        
    }
    
    
    
    protected void nuevoMecanico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("id_mecanico", 0);
        request.getRequestDispatcher("taller/views/mantenedores/mecanicos/form_mecanico.jsp").forward(request, response);
    }
    
    
    protected void guardarMecanico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        UsuarioDTO usuario = new UsuarioDTO();
        MecanicoDAOImpl mecanicoDAO = new MecanicoDAOImpl();
        MecanicoDTO mecanico = new MecanicoDTO();
        
        int id_mecanico = Integer.parseInt(request.getParameter("id_mecanico"));
        String nombres = request.getParameter("nombres_mecanico");
        String apellidos = request.getParameter("apellidos_mecanico");
        String rut = request.getParameter("rut_mecanico");
        String especialidad = request.getParameter("especialidad_mecanico");
        
        boolean estado = false;
        String mensaje = "";
        
        System.out.println(id_mecanico);
        
        if(id_mecanico == 0){
            String pass = request.getParameter("pass_mecanico");
            
            usuario.setRut_usuario(rut);
            usuario.setNombres_usuario(nombres);
            usuario.setApellidos_usuario(apellidos);
            usuario.setPass_usuario(pass);
            usuario.setPerfil_usuario(2);
            
            try{
                id_mecanico = usuarioDAO.insert(usuario);
                if(id_mecanico > 0){
                    mecanico.setId_mecanico(id_mecanico);
                    mecanico.setEspecialidad_mecanico(especialidad);
                    
                    mecanicoDAO.insert(mecanico);
                    
                    estado = true;
                    mensaje = "Los datos del mecánico han sido guardados";
                }
            } catch(SQLException e){
                System.out.println(e.getMessage());
                mensaje = "Hubo un error al guardar los datos";
            }
            
            
        }else{
            
            usuario.setRut_usuario(rut);
            usuario.setNombres_usuario(nombres);
            usuario.setApellidos_usuario(apellidos);
            usuario.setPerfil_usuario(2);
            usuario.setId_usuario(id_mecanico);
            try{
                if(usuarioDAO.update(usuario) > 0){
                    mecanico.setId_mecanico(id_mecanico);
                    mecanico.setEspecialidad_mecanico(especialidad);
                    
                    mecanicoDAO.update(mecanico);
                    
                    estado = true;
                    mensaje = "Los datos del mecánico han sido guardados";
                }
            } catch(SQLException e){
                System.out.println(e.getMessage());
                mensaje = "Hubo un error al guardar los datos";
            }
        }
        
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String respuesta = "{\"estado\":" + estado + ", \"mensaje\":\"" + mensaje + "\"}";
        
        out.println(respuesta);
    }
    
    
    protected void editarMecanico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_mecanico = Integer.parseInt(request.getParameter("id_mecanico"));
        
        MecanicoDAOImpl mecanicoDAO = new MecanicoDAOImpl();
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        
        MecanicoDTO mecanico = new MecanicoDTO();
        UsuarioDTO usuario = new UsuarioDTO();
        
        try{
            usuario = usuarioDAO.selectById(id_mecanico);
            mecanico = mecanicoDAO.selectById(id_mecanico);
        }catch(SQLException e){
            
        }
        
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("id_mecanico", id_mecanico);
        request.setAttribute("mecanico", mecanico);
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("taller/views/mantenedores/mecanicos/form_mecanico.jsp").forward(request, response);
    }
    
    
    protected void eliminarMecanico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_mecanico = Integer.parseInt(request.getParameter("id_mecanico"));
        
        boolean estado = false;
        String mensaje = "";
        
        MecanicoDAOImpl mecanicoDAO = new MecanicoDAOImpl();
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        
        try{
            if(mecanicoDAO.delete(id_mecanico) > 0){
                usuarioDAO.delete(id_mecanico);
                estado = true;
                mensaje = "Mecánico eliminado correctamente";
            }else{
                estado = false;
                mensaje = "Hubo un problema al eliminar al mecánico. Intente nuevamente";
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            estado = false;
                mensaje = "Error interno al eliminar";
        }
        
        
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String respuesta = "{\"estado\":" + estado + ", \"mensaje\":\"" + mensaje + "\"}";
        
        out.println(respuesta);
        
    }

}
