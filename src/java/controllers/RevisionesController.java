/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.RevisionDAOImpl;
import DAO.TrabajoDAOImpl;
import DAO.UsuarioDAOImpl;
import DAO.VehiculoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.TrabajoDTO;
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
            
            case "nuevoTrabajo" : 
                nuevoTrabajo(request, response);
                break;
                
            case "guardarTrabajo" :
                guardarTrabajo(request, response);
                break;
                
            case "listadoTrabajos" :
                listadoTrabajos(request, response);
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
        TrabajoDAOImpl trabajoDAO = new TrabajoDAOImpl();
        
        VehiculoDTO vehiculo = null;
        
        try{
            vehiculo = vehiculoDAO.selectByPatente(patente);
            if(vehiculo != null){
                UsuarioDTO usuario = usuarioDAO.selectById(vehiculo.getFk_cliente_vehiculo());
                int total_trabajos = trabajoDAO.contarTrabajosVehiculo(vehiculo.getId_vehiculo());

                request.setAttribute("vehiculo", vehiculo);
                request.setAttribute("usuario", usuario);
                request.setAttribute("total_trabajos", total_trabajos);
            }
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            request.setAttribute("mensajeError", "Hubo un error en la búsqueda");
        }

        request.getRequestDispatcher("taller/views/revisiones/resultado_busqueda.jsp").forward(request, response);
    }
    
    
    protected void nuevoTrabajo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        int id_vehiculo = Integer.parseInt(request.getParameter("id_vehiculo"));
        
        request.setAttribute("id_vehiculo", id_vehiculo);
        
        request.getRequestDispatcher("taller/views/revisiones/form_revision.jsp").forward(request, response);
    }
    
    
    protected void guardarTrabajo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        String fecha = request.getParameter("fecha");
        String descripcion = request.getParameter("descripcion");
        int valor = Integer.parseInt(request.getParameter("valor"));
        int id_vehiculo = Integer.parseInt(request.getParameter("id_vehiculo"));
        
        HttpSession session = request.getSession();
        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
        
        int id_mecanico = usuario.getId_usuario();
        
        String mensaje = "";
        boolean estado = false;
        int total_trabajos = 0;
        
        try{
            TrabajoDTO trabajo = new TrabajoDTO();
            TrabajoDAOImpl trabajoDAO = new TrabajoDAOImpl();
            
            trabajo.setFk_vehiculo_trabajo(id_vehiculo);
            trabajo.setFk_mecanico_trabajo(usuario.getId_usuario());
            trabajo.setFecha_trabajo(fecha);
            trabajo.setDescripcion_trabajo(descripcion);
            trabajo.setValor_trabajo(valor);
            
            if(trabajoDAO.insert(trabajo) > 0){
                estado = true;
                mensaje = "El trabajo ha sido registrado";
                
                total_trabajos = trabajoDAO.contarTrabajosVehiculo(id_vehiculo);
            }else{
                mensaje = "Hubo un problema al registrar el trabajo. Intente nuevamente";
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            mensaje = "Hubo un problema al registrar el trabajo. Intente nuevamente";
        }
        
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String respuesta = "{\"estado\":" + estado + ", \"mensaje\":\"" + mensaje + "\", \"total_trabajos\":\"" + total_trabajos + "\"}";
        
        out.println(respuesta);
        
    }
    
    
    protected void listadoTrabajos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        int id_vehiculo = Integer.parseInt(request.getParameter("id_vehiculo"));
        
        
        TrabajoDAOImpl trabajoDAO = new TrabajoDAOImpl();
        List<TrabajoDTO> trabajos = new ArrayList<TrabajoDTO>();
        
        try{
            trabajos = trabajoDAO.selectByVehiculo(id_vehiculo);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        request.setAttribute("id_vehiculo", id_vehiculo);
        request.setAttribute("trabajos", trabajos);

        request.getRequestDispatcher("taller/views/revisiones/revisar_trabajos.jsp").forward(request, response);
    }

}
