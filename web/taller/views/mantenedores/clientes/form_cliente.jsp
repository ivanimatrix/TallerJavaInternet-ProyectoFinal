<%@page import="models.UsuarioDTO"%>
<%@page import="models.ClienteDTO"%>

<% ClienteDTO cliente = (ClienteDTO) request.getAttribute("cliente"); %>
<% UsuarioDTO usuario = (UsuarioDTO) request.getAttribute("usuario"); %>

<div class="row">
    <div class="col-xs-12">
        <form class="form-horizontal" role="form">
            <input type="hidden" name="action" id="action" value="guardarCliente" />
            <input type="hidden" name="id_cliente" id="id_cliente" value="${id_cliente}" />
            <div class="form-group">
                <label class="col-xs-12">Rut</label>
                <div class="col-xs-12 col-md-6">
                    <% if(cliente == null){ %>
                    <input type="text" name="rut_cliente" id="rut_cliente" placeholder="12345678-9" class="form-control"  />
                    <% } else { %>
                    <input type="text" name="rut_cliente" id="rut_cliente" placeholder="12345678-9" class="form-control" value="<%=usuario.getRut_usuario()%>"  />
                    <% } %>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-md-6">
                    <div class="form-group">
                        <label class="col-xs-12">Nombres</label>
                        <div class="col-xs-12">
                            <% if(cliente == null){ %>
                            <input type="text" name="nombres_cliente" id="nombres_clientes" class="form-control"  />
                            <% } else { %>
                            <input type="text" name="nombres_cliente" id="nombres_clientes" class="form-control" value="<%=usuario.getNombres_usuario()%>" />
                            <% } %>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6">
                    <div class="form-group">
                        <label class="col-xs-12">Apellidos</label>
                        <div class="col-xs-12">
                            <% if(cliente == null){ %>
                            <input type="text" name="apellidos_cliente" id="apellidos_cliente" class="form-control" />
                            <% } else { %>
                            <input type="text" name="apellidos_cliente" id="apellidos_cliente" class="form-control" value="<%=usuario.getApellidos_usuario()%>" />
                            <% } %>
                        </div>
                    </div>
                </div>
            </div>

            <% if(cliente == null){ %>
            <div class="form-group">
                <label class="col-xs-12">Password</label>
                <div class="col-xs-12">
                    <input type="password" name="pass_cliente" id="pass_cliente" class="form-control" />
                </div>
            </div>
            <% } %>

            <div class="row">
                <div class="col-xs-12 col-md-6">
                    <div class="form-group">
                        <label class="col-xs-12">Email</label>
                        <div class="col-xs-12">
                            <% if (cliente == null) { %>
                            <input type="email" name="email_cliente" id="email_cliente" class="form-control" />
                            <% } else { %>
                            <input type="email" name="email_cliente" id="email_cliente" class="form-control" value="<%=cliente.getEmail_cliente()%>" />
                            <% } %>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6">
                    <div class="form-group">
                        <label class="col-xs-12">Teléfono</label>
                        <div class="col-xs-12">
                            <% if (cliente == null) { %>
                            <input type="email" name="telefono_cliente" id="telefono_cliente" class="form-control" />
                            <% } else { %>
                            <input type="email" name="telefono_cliente" id="telefono_cliente" class="form-control" value="<%=cliente.getFono_cliente()%>" />
                            <% } %>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="text-right">
                <button type="button" class="btn btn-success" onclick="Clientes.guardarCliente(this.form, this);">Guardar</button>
            </div>

        </form>
    </div>
</div>
