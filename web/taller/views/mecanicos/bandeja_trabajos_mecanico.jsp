<%@page import="DAO.VehiculoDAOImpl"%>
<%@page import="models.TrabajoDTO"%>
<%@page import="models.VehiculoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<% List<TrabajoDTO> trabajos = (List<TrabajoDTO>) request.getAttribute("trabajos");%>
<% UsuarioDTO usuario = (UsuarioDTO) request.getAttribute("usuario");%>
<% VehiculoDTO vehiculo = new VehiculoDTO();%>
<% VehiculoDAOImpl vehiculoDAO = new VehiculoDAOImpl();%>

<!DOCTYPE html>
<html>
    <%@include file="../head.html" %>
    <body>
        <div class="container">
            <%@include file="../menu.jsp" %>

            <div class="row">
                <div class="col-xs-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Bandeja de Mis Trabajos</h3>
                        </div>
                        <div class="panel-body">
                            <div class="col-xs-12">
                                <div class="">
                                    <div class="table-responsive top-spaced" id="contenedor-grilla-vehiculos">
                                        <table class="table table-hover table-striped table-condensed table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Fecha</th>
                                                    <th>Patente</th>
                                                    <th>Descripción</th>
                                                    <th>Valor</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% if (trabajos == null) { %>
                                                <tr>
                                                    <td colspan="4" class="text-center">
                                                        <div class="alert alert-info">
                                                            Ud. no presenta trabajos realizados
                                                        </div>
                                                    </td>
                                                </tr>
                                                <% } else { %>
                                                <% for (TrabajoDTO trabajo : trabajos) { %>
                                                <% vehiculo = vehiculoDAO.selectById(trabajo.getFk_vehiculo_trabajo());%>
                                                <tr>
                                                    <td class="text-center"><%=trabajo.getFecha_trabajo()%></td>
                                                    <td class="text-center"><%=vehiculo.getPatente_vehiculo()%></td>
                                                    <td class="text-center"><%=trabajo.getDescripcion_trabajo()%></td>
                                                    <td class="text-center">$ <%=trabajo.getValor_trabajo()%></td>
                                                </tr>
                                                <% } %>
                                                <% }%>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <script type="text/javascript" charset="utf-8" src="/ProyectoTallerMecanico/taller/resources/js/mantenedores/vehiculos/vehiculos.js"></script>
</html>