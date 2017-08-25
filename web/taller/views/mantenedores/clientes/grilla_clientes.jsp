<%@page import="DAO.UsuarioDAOImpl"%>
<%@page import="models.UsuarioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.ClienteDTO"%>
<%@page import="java.util.List"%>
<table class="table table-bordered table-hover table-striped" id="grilla-clientes">
    <thead>
        <tr>
            <th>Rut Cliente</th>
            <th>Nombres</th>
            <th>Apellidos</th>
            <th>Email</th>
            <th>Telefono</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <% List<ClienteDTO> listado = (ArrayList<ClienteDTO>) request.getAttribute("clientes"); %>
        <% if(listado.size() == 0){ %>
        <tr>
            <td colspan="6" class="text-center">
                <div class="alert alert-warning">
                    <p>No existen clientes registrados en el sistema</p>
                </div>
            </td>
        </tr>
        <% } else { %>
        <% for(ClienteDTO cliente : listado){ %>
        <% UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl(); %>
        <% UsuarioDTO usuario = usuarioDAO.selectById(cliente.getId_cliente()); %>
        <tr>
            <td class="text-center"><%=usuario.getRut_usuario()%></td>
            <td class="text-center"><%=usuario.getNombres_usuario()%></td>
            <td class="text-center"><%=usuario.getApellidos_usuario()%></td>
            <td class="text-center"><%=cliente.getEmail_cliente()%></td>
            <td class="text-center"><%=cliente.getFono_cliente()%></td>
            <td class="text-center">
                <div class="btn-group-sm">
                    <button type="button" class="btn btn-success" onclick="Clientes.editarCliente(<%=cliente.getId_cliente()%>)"><i class="fa fa-edit"></i></button>
                    <button type="button" class="btn btn-danger" onclick="Clientes.eliminarCliente(<%=cliente.getId_cliente()%>)"><i class="fa fa-trash"></i></button>
                </div>
            </td>
        </tr>
        <% } %>
        <% } %>
    </tbody>
</table>
