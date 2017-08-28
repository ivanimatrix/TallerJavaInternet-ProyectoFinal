<%@page import="models.UsuarioDTO"%>
<%@page import="models.VehiculoDTO"%>

<% VehiculoDTO vehiculo = (VehiculoDTO) request.getAttribute("vehiculo");%>
<% UsuarioDTO usuario = (UsuarioDTO) request.getAttribute("usuario"); %>

<div class="row">
    
        <% if(vehiculo == null) { %>
        <div class="col-xs-12 top-spaced">
            <div class="alert alert-warning">
                <i class="fa fa-exclamation-circle"></i> No se ha encontrado vehículo asociado a la patente 
            </div>
        </div>
        <% } else { %>
        <div class="col-xs-12">
            <div class="well well-sm top-spaced" style="overflow: hidden">
                <legend>Resultado para <%=vehiculo.getPatente_vehiculo()%> 
                    <div class="btn-group pull-right">
                    <button type="button" class="btn btn-success btn-sm pull-right" onclick="Revisiones.nuevoTrabajo(<%=vehiculo.getId_vehiculo()%>);"> Nuevo Trabajo</button>
                    <button type="button" class="btn btn-primary btn-sm pull-right" onclick="Revisiones.cargarListadoTrabajoVehiculo(<%=vehiculo.getId_vehiculo()%>);"> Revisar Trabajos</button>
                    </div>
                </legend>
                <div class="col-xs-12 col-md-6 text-left">
                    <div class="form-group">
                        <label>Patente</label>
                        <p><%=vehiculo.getPatente_vehiculo()%></p>
                    </div>
                    <div class="form-group">
                        <label>Propietario</label>
                        <p><%=usuario.getNombres_usuario()%> <%=usuario.getApellidos_usuario()%></p>
                    </div>
                    <div class="form-group">
                        <label>Total de Trabajos</label>
                        <p id="total_trabajos"><%=request.getAttribute("total_trabajos")%></p>
                    </div>
                    
                </div>
                <div class="col-xs-12 col-md-6">
                    
                    <div class="form-group">
                        <label>Marca</label>
                        <p><%=vehiculo.getMarca_vehiculo()%></p>
                    </div>
                    <div class="form-group">
                        <label>Modelo</label>
                        <p><%=vehiculo.getModelo_vehiculo()%></p>
                    </div>
                    <div class="form-group">
                        <label>Año</label>
                        <p><%=vehiculo.getAnyo_vehiculo()%></p>
                    </div>
                </div>
            </div>
        </div>
        
        <% } %>
        
</div>
