<%@page import="DAO.UsuarioDAOImpl"%>
<%@page import="models.UsuarioDTO"%>
<%@page import="java.util.List"%>
<%@page import="models.TrabajoDTO"%>

<% List<TrabajoDTO> trabajos = (List<TrabajoDTO>) request.getAttribute("trabajos"); %>
<% UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl(); %>
<% UsuarioDTO usuario = new UsuarioDTO(); %>

<div class="row">
    
    <div class="col-xs-12">
        <table class="table table-hover table-striped table-condensed">
            <thead>
                <tr>
                    <th>Fecha</th>
                    <th>Mecánico</th>
                    <th>Descripción</th>
                    <th>Valor</th>
                </tr>
            </thead>
            <tbody>
                <% if(trabajos == null) { %>
                <tr>
                    <td colspan="4" class="text-center">
                        <div class="alert alert-info">
                            El vehículo no presenta trabajos realizados
                        </div>
                    </td>
                </tr>
                <% } else { %>
                <% for(TrabajoDTO trabajo : trabajos) { %>
                <% usuario = usuarioDAO.selectById(trabajo.getFk_mecanico_trabajo());%>
                <tr>
                    <td class="text-center"><%=trabajo.getFecha_trabajo()%></td>
                    <td class="text-center"><%=usuario.getNombres_usuario()%> <%=usuario.getApellidos_usuario()%></td>
                    <td class="text-center"><%=trabajo.getDescripcion_trabajo()%></td>
                    <td class="text-center">$ <%=trabajo.getValor_trabajo()%></td>
                </tr>
                <% } %>
                <% } %>
            </tbody>
        </table>
    </div>
    
</div>
