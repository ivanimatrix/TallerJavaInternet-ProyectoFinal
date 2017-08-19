
<!DOCTYPE html>
<html>

    <%@include file="views/head.html" %>

    <body>

        <!-- contenedor principal -->
        <div class="container" style="margin-top:200px">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading"><h3 class="panel-title text-center"><strong>Bienvenido a Taller Mecánico </strong></h3>
                        
                    </div>

                    <div class="panel-body">
                        <form role="form">
                            <div class="alert alert-danger hidden" id="contenedor-mensaje-error">
                                <a class="close" data-dismiss="alert" href="#">×</a><span id="mensaje-error"></span>
                            </div>
                            <div style="margin-bottom: 12px" class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                <input id="usuario" type="text" class="form-control" name="usuario" value="" placeholder="ej.: 12345678-9">                                        
                            </div>

                            <div style="margin-bottom: 12px" class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                <input id="pass" type="password" class="form-control" name="pass" placeholder="contraseña">
                            </div>


                            <button type="button" class="btn btn-success" onclick="Login.validar(this.form,this);">Ingresar</button>

                            <hr style="margin-top:10px;margin-bottom:10px;" >

                        </form>
                    </div>
                </div>
            </div>
        </div>

    </body>
    
    <script src="resources/js/login/login.js"></script>
</html>
