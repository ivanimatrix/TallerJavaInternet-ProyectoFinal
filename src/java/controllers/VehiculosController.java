/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.ClienteDAOImpl;
import DAO.MecanicoDAOImpl;
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
import models.ClienteDTO;
import models.MecanicoDTO;
import models.UsuarioDTO;
import models.VehiculoDTO;

/**
 *
 * @author ivanimatrix
 */
public class VehiculosController extends HttpServlet {

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
            
            case "indexVehiculos" :
                request.getRequestDispatcher("taller/views/mantenedores/vehiculos/bandeja_vehiculos.jsp").forward(request, response);
                break;
                
            case "listadoVehiculos" : 
                listadoVehiculos(request, response);
                break;
                
            case "nuevoVehiculo" : 
                nuevoVehiculo(request, response);
                break;
                
            case "guardarVehiculo" : 
                guardarVehiculo(request, response);
                break;
                
            case "editarVehiculo" : 
                editarVehiculo(request, response);
                break;
                
            case "eliminarVehiculo" : 
                eliminarVehiculo(request, response);
                break;
            
            case "indexVehiculosCliente" :
                vehiculosCliente(request, response);
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

    
    protected void listadoVehiculos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        VehiculoDAOImpl vehiculoDAO = new VehiculoDAOImpl();
        List<VehiculoDTO> vehiculos = null;
        
        try{
            vehiculos = vehiculoDAO.select();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("vehiculos", vehiculos);
        request.getRequestDispatcher("taller/views/mantenedores/vehiculos/grilla_vehiculos.jsp").forward(request, response);
        
    }
    
    
    
    protected void nuevoVehiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
        List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
        
        try{
            clientes = clienteDAO.select();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("id_vehiculo", 0);
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("taller/views/mantenedores/vehiculos/form_vehiculo.jsp").forward(request, response);
    }
    
    
    protected void guardarVehiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        VehiculoDAOImpl vehiculoDAO = new VehiculoDAOImpl();
        VehiculoDTO vehiculo = new VehiculoDTO();
        
        int id_vehiculo = Integer.parseInt(request.getParameter("id_vehiculo"));
        int id_cliente = Integer.parseInt(request.getParameter("propietario"));
        String patente = request.getParameter("patente").toUpperCase();
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        int anyo = Integer.parseInt(request.getParameter("anyo"));
        
        boolean estado = false;
        String mensaje = "";
        
        if(id_vehiculo == 0){
            
            vehiculo.setPatente_vehiculo(patente);
            vehiculo.setMarca_vehiculo(marca);
            vehiculo.setModelo_vehiculo(modelo);
            vehiculo.setAnyo_vehiculo(anyo);
            vehiculo.setFk_cliente_vehiculo(id_cliente);
            
            try{
                id_vehiculo = vehiculoDAO.insert(vehiculo);
                if(id_vehiculo > 0){
                    estado = true;
                    mensaje = "Los datos del vehículo han sido guardados";
                }
            } catch(SQLException e){
                System.out.println(e.getMessage());
                mensaje = "Hubo un error al guardar los datos";
            }
            
            
        }else{
            
            vehiculo.setPatente_vehiculo(patente);
            vehiculo.setMarca_vehiculo(marca);
            vehiculo.setModelo_vehiculo(modelo);
            vehiculo.setAnyo_vehiculo(anyo);
            vehiculo.setFk_cliente_vehiculo(id_cliente);
            vehiculo.setId_vehiculo(id_vehiculo);
            try{
                if(vehiculoDAO.update(vehiculo) > 0){
                    
                    estado = true;
                    mensaje = "Los datos del vehículo han sido guardados";
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
    
    
    protected void editarVehiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_vehiculo = Integer.parseInt(request.getParameter("id_vehiculo"));
        
        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
        List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
        
        VehiculoDAOImpl vehiculoDAO = new VehiculoDAOImpl();
        VehiculoDTO vehiculo = new VehiculoDTO();
        
        try{
            clientes = clienteDAO.select();
            vehiculo = vehiculoDAO.selectById(id_vehiculo);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("id_vehiculo", id_vehiculo);
        request.setAttribute("vehiculo", vehiculo);
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("taller/views/mantenedores/vehiculos/form_vehiculo.jsp").forward(request, response);
    }
    
    
    protected void eliminarVehiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_vehiculo = Integer.parseInt(request.getParameter("id_vehiculo"));
        
        boolean estado = false;
        String mensaje = "";
        
        VehiculoDAOImpl vehiculoDAO = new VehiculoDAOImpl();
        
        
        try{
            if(vehiculoDAO.delete(id_vehiculo) > 0){
                estado = true;
                mensaje = "Vehículo eliminado correctamente";
            }else{
                estado = false;
                mensaje = "Hubo un problema al eliminar el vehículo. Intente nuevamente";
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
    
    
    protected void vehiculosCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
        List<VehiculoDTO> vehiculos = null;
        VehiculoDAOImpl vehiculoDAO = new VehiculoDAOImpl();
        
        try{
            vehiculos = vehiculoDAO.selectByCliente(usuario.getId_usuario());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        request.setAttribute("vehiculos", vehiculos);
        request.getRequestDispatcher("taller/views/clientes/bandeja_vehiculos_cliente.jsp").forward(request, response);
    }
}
