<%@page import="DAO.UsuarioDAOImpl"%>
<%@page import="models.UsuarioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.MecanicoDTO"%>
<%@page import="java.util.List"%>
<table class="table table-bordered table-hover table-striped" id="grilla-mecanicos">
    <thead>
        <tr>
            <th>Rut Cliente</th>
            <th>Nombres</th>
            <th>Apellidos</th>
            <th>Especialidad</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <% List<MecanicoDTO> listado = (ArrayList<MecanicoDTO>) request.getAttribute("mecanicos"); %>
        <% if(listado.size() == 0){ %>
        <tr>
            <td colspan="5" class="text-center">
                <div class="alert alert-warning">
                    <p>No existen mecánicos registrados en el sistema</p>
                </div>
            </td>
        </tr>
        <% } else { %>
        <% for(MecanicoDTO mecanico : listado){ %>
        <% UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl(); %>
        <% UsuarioDTO usuario = usuarioDAO.selectById(mecanico.getId_mecanico()); %>
        <tr>
            <td class="text-center"><%=usuario.getRut_usuario()%></td>
            <td class="text-center"><%=usuario.getNombres_usuario()%></td>
            <td class="text-center"><%=usuario.getApellidos_usuario()%></td>
            <td class="text-center"><%=mecanico.getEspecialidad_mecanico()%></td>
            <td class="text-center">
                <div class="btn-group-sm">
                    <button type="button" class="btn btn-success" onclick="Mecanicos.editarMecanico(<%=mecanico.getId_mecanico()%>)"><i class="fa fa-edit"></i></button>
                    <button type="button" class="btn btn-danger" onclick="Mecanicos.eliminarMecanico(<%=mecanico.getId_mecanico()%>)"><i class="fa fa-trash"></i></button>
                </div>
            </td>
        </tr>
        <% } %>
        <% } %>
    </tbody>
</table>
