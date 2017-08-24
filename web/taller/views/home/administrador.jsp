<!DOCTYPE html>
<html>
    <%@include file="../head.html" %>
    <body>
        <div class="container">
            <%@include file="../menu.jsp" %>

            <div class="row">
                <div class="col-xs-12 col-md-6">
                    <div class="alert alert-info">
                        <h4>Vehículos</h4>
                        <i class="fa fa-car fa-5x"></i>
                        <span class="badge pull-right fa-5x">55</span>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6">
                    <div class="alert alert-warning">
                        <h4>Clientes</h4>
                        <i class="fa fa-users fa-5x"></i>
                        <span class="badge pull-right fa-5x"><%=request.getAttribute("total_clientes")%></span>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>