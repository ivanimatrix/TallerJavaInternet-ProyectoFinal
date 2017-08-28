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
                            <h3 class="panel-title">Revisiones</h3>
                        </div>
                        <div class="panel-body">
                            
                            <div class="col-xs-12">
                                <form class="form-inline" role="form">
                                    <label>Patente</label>
                                    <div class="input-group">
                                        <input type="text" minlength="6" maxlength="6" class="form-control" name="patente" id="patente" />
                                        <div class="input-group-btn">
                                            <button type="button" class="btn btn-primary" onclick="Revisiones.buscarPatente(this.form, this);" >Buscar</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            
                            <div class="top-spaced" id="contenedor-resultado-patente">
                                
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <script type="text/javascript" charset="utf-8" src="/ProyectoTallerMecanico/taller/resources/js/revisiones/revisiones.js"></script>
</html>