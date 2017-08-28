<% UsuarioDTO usuario = (UsuarioDTO) request.getAttribute("usuario");%>

<!DOCTYPE html>
<html>
    <%@include file="../head.html" %>
    <body>
        <div class="container">
            <%@include file="../menu.jsp" %>

            <div class="row">
                <div class="col-xs-12 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Mis Datos</h3>
                        </div>
                        <div class="panel-body">
                            <div class="col-xs-12">
                                <form class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label class="col-xs-12">Rut</label>
                                        <div class="col-xs-12 col-md-6">
                                            <input type="text" name="rut" class="form-control" id="rut" value="<%=usuario.getRut_usuario()%>" maxlength="10" placeholder="12345678-k" />
                                        </div>
                                    </div>
                                        
                                    <div class="row">
                                        <div class="col-xs-12 col-md-6">
                                            <div class="form-group">
                                                <label class="col-xs-12">Nombres</label>
                                                <div class="col-xs-12">
                                                    <input type="text" class="form-control" name="nombres" id="nombres" value="<%=usuario.getNombres_usuario()%>" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-md-6">
                                            <div class="form-group">
                                                <label class="col-xs-12">Apellidos</label>
                                                <div class="col-xs-12">
                                                    <input type="text" class="form-control" name="apellidos" id="apellidos" value="<%=usuario.getApellidos_usuario()%>" />
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                                
                                    <div class="text-right">
                                        <button type="button" class="btn btn-success" onclick="Usuarios.guardarMisDatos(this.form, this);" >Modificar mis datos</button>
                                    </div>
                                </form>
                            </div>
                            

                        </div>
                    </div>
                </div>
                
                <div class="col-xs-12 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Mi contraseña</h3>
                        </div>
                        <div class="panel-body">
                            <div class="col-xs-12">
                                <form class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label class="col-xs-12">Nueva contraseña</label>
                                        <div class="col-xs-12">
                                            <input type="password" class="form-control" name="nueva_pass" id="nueva_pass" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-xs-12">Repetir contraseña</label>
                                        <div class="col-xs-12">
                                            <input type="password" class="form-control" name="repetir_pass" id="repetir_pass" />
                                        </div>
                                    </div>
                                    <div class="text-right">
                                        <button type="button" class="btn btn-success" onclick="Usuarios.guardarPassword(this.form, this);">Actualizar contraseña</button>
                                    </div>
                                        
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <script type="text/javascript" charset="utf-8" src="/ProyectoTallerMecanico/taller/resources/js/usuarios/usuarios.js"></script>
</html>