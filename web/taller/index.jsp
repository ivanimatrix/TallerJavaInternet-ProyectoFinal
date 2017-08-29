
<!DOCTYPE html>
<html>

    <head>
        <title>Taller Java Internet :: Proyecto Final</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="resources/css/theme-cosmo.bootstrap.min.css" rel="stylesheet" />
        <link href="resources/css/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
        <link href="resources/css/bootstrap-dialog.min.css" rel="stylesheet" />
        <link href="resources/css/style.css" rel="stylesheet" />

        <script src="resources/js/jquery-3.2.1.min.js"></script>
        <script src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="resources/js/bootstrap-dialog.min.js"></script>
        <script src="resources/js/modal.js"></script>
        <script src="resources/js/base.js"></script>
    </head>
    
    <body>

        <!-- contenedor principal -->
        <div class="container" style="margin-top:200px">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading"><h3 class="panel-title text-center"><strong>Bienvenido a Taller Mecánico </strong></h3>
                        
                    </div>

                    <div class="panel-body">
                        <form role="form">
                            <input type="hidden" name="action" value="loginUsuario" />
                            <div class="alert alert-danger hidden" id="contenedor-mensaje-error">
                                <a class="close" data-dismiss="alert" href="#">×</a><span id="mensaje-error"></span>
                            </div>
                            <div style="margin-bottom: 12px" class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                <input id="usuario" type="text" class="form-control" name="usuario" value="" maxlength="10" placeholder="ej.: 12345678-9">                                        
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
