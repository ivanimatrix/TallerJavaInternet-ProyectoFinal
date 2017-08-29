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
                    <div class="alert alert-info">
                        <h4><a href="/ProyectoTallerMecanico/VehiculosController?action=indexVehiculos" class="caja-inicio">Vehículos</a></h4>
                        <i class="fa fa-car fa-5x"></i>
                        <span class="badge pull-right fa-5x">${total_vehiculos}</span>
                    </div>
                </div>
                <div class="col-xs-12 col-md-4">
                    
                </div>
            </div>
        </div>
    </body>
</html>