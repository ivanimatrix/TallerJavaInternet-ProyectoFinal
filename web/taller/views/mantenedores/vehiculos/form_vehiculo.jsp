<%@page import="DAO.UsuarioDAOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.ClienteDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="models.UsuarioDTO"%>
<%@page import="models.VehiculoDTO"%>

<% VehiculoDTO vehiculo = (VehiculoDTO) request.getAttribute("vehiculo"); %>
<% List<ClienteDTO> clientes = (ArrayList<ClienteDTO>) request.getAttribute("clientes"); %>

<div class="row">
    <div class="col-xs-12">
        <form class="form-horizontal" role="form">
            <input type="hidden" name="action" id="action" value="guardarVehiculo" />
            <input type="hidden" name="id_vehiculo" id="id_vehiculo" value="${id_vehiculo}" />
            <div class="form-group">
                <label class="col-xs-12">Propietario</label>
                <div class="col-xs-12 col-sm-12 col-md-6">
                    <select class="form-control" name="propietario" id="propietario">
                        <option value="">Seleccione...</option>
                        <% if(clientes.size() > 0) { %>
                            <% for(ClienteDTO cliente : clientes) { %>
                            <% UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl(); %>
                            <% UsuarioDTO usuario = usuarioDAO.selectById(cliente.getId_cliente()); %>
                            <option value="<%=cliente.getId_cliente()%>" <% if(vehiculo != null && vehiculo.getFk_cliente_vehiculo() == cliente.getId_cliente()){ %> selected <% } %>  ><%=usuario.getNombres_usuario()%> <%=usuario.getApellidos_usuario()%></option>
                            <% } %>
                        <% } %>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-md-6">
                    <div class="form-group">
                        <label class="col-xs-12">Patente</label>
                        <div class="col-xs-12">
                            <input type="text" maxlength="6" minlength="6" name="patente" id="patente" class="form-control" <% if(vehiculo != null){ %> value="<%=vehiculo.getPatente_vehiculo()%>" <% } %> />
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6">
                    <div class="form-group">
                        <label class="col-xs-12">Marca</label>
                        <div class="col-xs-12">
                            <input type="text" class="form-control" name="marca" id="marca" <% if(vehiculo != null){ %> value="<%=vehiculo.getMarca_vehiculo()%>" <% } %> />
                        </div>
                    </div>
                </div>
            </div>
                        
            <div class="row">
                <div class="col-xs-12 col-md-6">
                    <div class="form-group">
                        <label class="col-xs-12">Modelo</label>
                        <div class="col-xs-12">
                            <input type="text" name="modelo" id="modelo" class="form-control" <% if(vehiculo != null){ %> value="<%=vehiculo.getModelo_vehiculo()%>" <% } %> />
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6">
                    <div class="form-group">
                        <label class="col-xs-12">Año</label>
                        <div class="col-xs-12">
                            <input type="number" min="0" class="form-control" name="anyo" id="anyo" <% if(vehiculo != null){ %> value="<%=vehiculo.getAnyo_vehiculo()%>" <% } %> />
                        </div>
                    </div>
                </div>
            </div>

            
            
            <div class="text-right">
                <button type="button" class="btn btn-success" onclick="Vehiculos.guardarVehiculo(this.form, this);">Guardar</button>
            </div>

        </form>
    </div>
</div>
