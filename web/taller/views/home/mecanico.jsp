<!DOCTYPE html>
<html>
    <%@include file="../head.html" %>
    <body>
        <div class="container">
            <%@include file="../menu.jsp" %>

            <div class="row">
                <div class="col-xs-12 col-md-4">
                    
                </div>
                <div class="col-xs-12 col-md-4">
                    <div class="alert alert-success">
                        <h4><a href="/ProyectoTallerMecanico/MecanicosController?action=indexTrabajosMecanico" class="caja-inicio">Trabajos Realizados</a></h4>
                        <i class="fa fa-wrench fa-5x"></i>
                        <span class="badge pull-right fa-5x">${total_trabajos}</span>
                    </div>
                </div>
                <div class="col-xs-12 col-md-4">
                    
                </div>
            </div>
        </div>
    </body>
</html>