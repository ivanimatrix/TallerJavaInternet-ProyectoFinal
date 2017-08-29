/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.ClienteDAOImpl;
import DAO.UsuarioDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ClienteDTO;
import models.UsuarioDTO;
import libs.Validar;

/**
 *
 * @author ivanimatrix
 */
public class ClientesController extends HttpServlet {

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

        Validar validar = new Validar();
        int[] perfiles = {2,3};
        if (!validar.validarAccionPerfil(request, response, perfiles)) {
            request.getRequestDispatcher("/HomeController").forward(request, response);
        } else {

            String action = request.getParameter("action");

            switch (action) {

                case "indexClientes":
                    request.getRequestDispatcher("taller/views/mantenedores/clientes/bandeja_clientes.jsp").forward(request, response);
                    break;

                case "listadoClientes":
                    listadoClientes(request, response);
                    break;

                case "nuevoCliente":
                    nuevoCliente(request, response);
                    break;

                case "guardarCliente":
                    guardarCliente(request, response);
                    break;

                case "editarCliente":
                    editarCliente(request, response);
                    break;

                case "eliminarCliente":
                    eliminarCliente(request, response);
                    break;

            }
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

    protected void listadoClientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
        List<ClienteDTO> clientes = null;

        try {
            clientes = clienteDAO.select();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("taller/views/mantenedores/clientes/grilla_clientes.jsp").forward(request, response);

    }

    protected void nuevoCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("id_cliente", 0);
        request.getRequestDispatcher("taller/views/mantenedores/clientes/form_cliente.jsp").forward(request, response);
    }

    protected void guardarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        UsuarioDTO usuario = new UsuarioDTO();
        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
        ClienteDTO cliente = new ClienteDTO();

        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        String nombres_cliente = request.getParameter("nombres_cliente");
        String apellidos_cliente = request.getParameter("apellidos_cliente");
        String rut_cliente = request.getParameter("rut_cliente");
        String email_cliente = request.getParameter("email_cliente");
        String telefono_cliente = request.getParameter("telefono_cliente");

        boolean estado = false;
        String mensaje = "";

        System.out.println(id_cliente);

        if (id_cliente == 0) {
            String pass_cliente = request.getParameter("pass_cliente");

            usuario.setRut_usuario(rut_cliente);
            usuario.setNombres_usuario(nombres_cliente);
            usuario.setApellidos_usuario(apellidos_cliente);
            usuario.setPass_usuario(pass_cliente);
            usuario.setPerfil_usuario(3);

            try {
                id_cliente = usuarioDAO.insert(usuario);
                if (id_cliente > 0) {
                    cliente.setId_cliente(id_cliente);
                    cliente.setEmail_cliente(email_cliente);
                    cliente.setFono_cliente(telefono_cliente);

                    clienteDAO.insert(cliente);

                    estado = true;
                    mensaje = "Los datos del cliente han sido guardados";
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                mensaje = "Hubo un error al guardar los datos";
            }

        } else {

            usuario.setRut_usuario(rut_cliente);
            usuario.setNombres_usuario(nombres_cliente);
            usuario.setApellidos_usuario(apellidos_cliente);
            usuario.setPerfil_usuario(3);
            usuario.setId_usuario(id_cliente);
            try {
                if (usuarioDAO.update(usuario) > 0) {
                    cliente.setId_cliente(id_cliente);
                    cliente.setEmail_cliente(email_cliente);
                    cliente.setFono_cliente(telefono_cliente);

                    clienteDAO.update(cliente);

                    estado = true;
                    mensaje = "Los datos del cliente han sido guardados";
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                mensaje = "Hubo un error al guardar los datos";
            }
        }

        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String respuesta = "{\"estado\":" + estado + ", \"mensaje\":\"" + mensaje + "\"}";

        out.println(respuesta);
    }

    protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));

        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();

        ClienteDTO cliente = new ClienteDTO();
        UsuarioDTO usuario = new UsuarioDTO();

        try {
            usuario = usuarioDAO.selectById(id_cliente);
            cliente = clienteDAO.selectById(id_cliente);
        } catch (SQLException e) {

        }

        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("id_cliente", id_cliente);
        request.setAttribute("cliente", cliente);
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("taller/views/mantenedores/clientes/form_cliente.jsp").forward(request, response);
    }

    protected void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));

        boolean estado = false;
        String mensaje = "";

        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();

        try {
            if (clienteDAO.delete(id_cliente) > 0) {
                usuarioDAO.delete(id_cliente);
                estado = true;
                mensaje = "Cliente eliminado correctamente";
            } else {
                estado = false;
                mensaje = "Hubo un problema al eliminar al cliente. Intente nuevamente";
            }
        } catch (SQLException e) {
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
