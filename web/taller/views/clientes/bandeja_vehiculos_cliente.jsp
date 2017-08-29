<%@page import="models.VehiculoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
                            <h3 class="panel-title">Bandeja de Mis Vehículos</h3>
                        </div>
                        <div class="panel-body">
                            <div class="col-xs-12">
                                <div class="">
                                    <div class="table-responsive top-spaced" id="contenedor-grilla-vehiculos">
                                        <table class="table table-bordered table-hover table-striped" id="grilla-vehiculos">
                                            <thead>
                                                <tr>
                                                    <th>Patente</th>
                                                    <th>Marca</th>
                                                    <th>Modelo</th>
                                                    <th>Año</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% List<VehiculoDTO> listado = (ArrayList<VehiculoDTO>) request.getAttribute("vehiculos"); %>
                                                <% if (listado.size() == 0) { %>
                                                <tr>
                                                    <td colspan="6" class="text-center">
                                                        <div class="alert alert-warning">
                                                            <p>No existen vehículos registrados en el sistema</p>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <% } else { %>
                                                <% for (VehiculoDTO vehiculo : listado) { %>
                                                <tr>
                                                    <td class="text-center"><%=vehiculo.getPatente_vehiculo()%></td>
                                                    <td class="text-center"><%=vehiculo.getMarca_vehiculo()%></td>
                                                    <td class="text-center"><%=vehiculo.getModelo_vehiculo()%></td>
                                                    <td class="text-center"><%=vehiculo.getAnyo_vehiculo()%></td>
                                                    <td class="text-center">
                                                        <div class="btn-group-sm">
                                                            <button type="button" class="btn btn-warning" onclick="Vehiculos.verTrabajosVehiculo(<%=vehiculo.getId_vehiculo()%>)" title="Ver Trabajos"><i class="fa fa-search"></i></button>
                                                        </div>
                                                    </td>
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