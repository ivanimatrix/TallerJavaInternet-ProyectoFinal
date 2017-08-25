<!DOCTYPE html>
<html>
    <%@include file="../../head.html" %>
    <body>
        <div class="container">
            <%@include file="../../menu.jsp" %>

            <div class="row">
                <div class="col-xs-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Bandeja de Mecánicos</h3>
                        </div>
                        <div class="panel-body">
                            <div class="col-xs-12 text-right">
                                <button type="button" class="btn btn-success" onclick="Mecanicos.nuevoMecanico()();" > Nuevo Mecánico</button>
                            </div>
                            <div class="col-xs-12">
                                <div class="">
                                    <div class="table-responsive top-spaced" id="contenedor-grilla-mecanicos">
                                        <!-- grilla de mecanicos -->
                                        
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <script type="text/javascript" charset="utf-8" src="/ProyectoTallerMecanico/taller/resources/js/mantenedores/mecanicos/mecanicos.js"></script>
    <script>Mecanicos.initBandeja();</script>
</html>