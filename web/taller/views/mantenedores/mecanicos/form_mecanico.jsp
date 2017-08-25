<%@page import="models.UsuarioDTO"%>
<%@page import="models.MecanicoDTO"%>

<% MecanicoDTO mecanico = (MecanicoDTO) request.getAttribute("mecanico"); %>
<% UsuarioDTO usuario = (UsuarioDTO) request.getAttribute("usuario"); %>

<div class="row">
    <div class="col-xs-12">
        <form class="form-horizontal" role="form">
            <input type="hidden" name="action" id="action" value="guardarMecanico" />
            <input type="hidden" name="id_mecanico" id="id_mecanico" value="${id_mecanico}" />
            <div class="form-group">
                <label class="col-xs-12">Rut</label>
                <div class="col-xs-12 col-md-6">
                    <% if(mecanico == null){ %>
                    <input type="text" name="rut_mecanico" id="rut_mecanico" placeholder="12345678-9" class="form-control"  />
                    <% } else { %>
                    <input type="text" name="rut_mecanico" id="rut_mecanico" placeholder="12345678-9" class="form-control" value="<%=usuario.getRut_usuario()%>"  />
                    <% } %>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-md-6">
                    <div class="form-group">
                        <label class="col-xs-12">Nombres</label>
                        <div class="col-xs-12">
                            <% if(mecanico == null){ %>
                            <input type="text" name="nombres_mecanico" id="nombres_mecanico" class="form-control"  />
                            <% } else { %>
                            <input type="text" name="nombres_mecanico" id="nombres_mecanico" class="form-control" value="<%=usuario.getNombres_usuario()%>" />
                            <% } %>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6">
                    <div class="form-group">
                        <label class="col-xs-12">Apellidos</label>
                        <div class="col-xs-12">
                            <% if(mecanico == null){ %>
                            <input type="text" name="apellidos_mecanico" id="apellidos_mecanico" class="form-control" />
                            <% } else { %>
                            <input type="text" name="apellidos_mecanico" id="apellidos_mecanico" class="form-control" value="<%=usuario.getApellidos_usuario()%>" />
                            <% } %>
                        </div>
                    </div>
                </div>
            </div>

            <% if(mecanico == null){ %>
            <div class="form-group">
                <label class="col-xs-12">Password</label>
                <div class="col-xs-12">
                    <input type="password" name="pass_mecanico" id="pass_mecanico" class="form-control" />
                </div>
            </div>
            <% } %>

            <div class="form-group">
                <label class="col-xs-12">Especialidad</label>
                <div class="col-xs-12">
                    <% if (mecanico == null) { %>
                    <input type="text" name="especialidad_mecanico" id="especialidad_mecanico" class="form-control" />
                    <% } else { %>
                    <input type="text" name="especialidad_mecanico" id="especialidad_mecanico" class="form-control" value="<%=mecanico.getEspecialidad_mecanico()%>" />
                    <% } %>
                </div>
            </div>
            
            <div class="text-right">
                <button type="button" class="btn btn-success" onclick="Mecanicos.guardarMecanico(this.form, this);">Guardar</button>
            </div>

        </form>
    </div>
</div>
