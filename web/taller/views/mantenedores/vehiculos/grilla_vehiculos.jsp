<%@page import="DAO.UsuarioDAOImpl"%>
<%@page import="models.UsuarioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.VehiculoDTO"%>
<%@page import="java.util.List"%>
<table class="table table-bordered table-hover table-striped" id="grilla-vehiculos">
    <thead>
        <tr>
            <th>Patente</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Año</th>
            <th>Propietario</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <% List<VehiculoDTO> listado = (ArrayList<VehiculoDTO>) request.getAttribute("vehiculos"); %>
        <% if(listado.size() == 0){ %>
        <tr>
            <td colspan="6" class="text-center">
                <div class="alert alert-warning">
                    <p>No existen vehículos registrados en el sistema</p>
                </div>
            </td>
        </tr>
        <% } else { %>
        <% for(VehiculoDTO vehiculo : listado){ %>
        <% UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl(); %>
        <% UsuarioDTO usuario = usuarioDAO.selectById(vehiculo.getFk_cliente_vehiculo()); %>
        <tr>
            <td class="text-center"><%=vehiculo.getPatente_vehiculo()%></td>
            <td class="text-center"><%=vehiculo.getMarca_vehiculo()%></td>
            <td class="text-center"><%=vehiculo.getModelo_vehiculo()%></td>
            <td class="text-center"><%=vehiculo.getAnyo_vehiculo()%></td>
            <td class="text-center"><%=usuario.getNombres_usuario()%> <%=usuario.getApellidos_usuario()%></td>
            <td class="text-center">
                <div class="btn-group-sm">
                    <button type="button" class="btn btn-success" onclick="Vehiculos.editarVehiculo(<%=vehiculo.getId_vehiculo()%>)"><i class="fa fa-edit"></i></button>
                    <button type="button" class="btn btn-danger" onclick="Vehiculos.eliminarVehiculo(<%=vehiculo.getId_vehiculo()%>)"><i class="fa fa-trash"></i></button>
                </div>
            </td>
        </tr>
        <% } %>
        <% } %>
    </tbody>
</table>
