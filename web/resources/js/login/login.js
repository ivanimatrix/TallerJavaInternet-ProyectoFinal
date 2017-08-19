

var Login = {
    
    
    validar : function(form, btn){
        $("#contenedor-mensaje-error").addClass('hidden');
        var btnText = $(btn).prop('disabled',true).html();
        $(btn).html('Validando... <i class="fa fa-spin fa-spinner"></i>');
        
        var error = "";
        
        if(form.usuario.value === "" || form.pass.value === ""){
            error = "Debe ingresar las credenciales";
        }
        
        if(error !== ""){
            $("#mensaje-error").html(error);
            $("#contenedor-mensaje-error").removeClass('hidden');
            $(btn).html(btnText).prop('disabled',false);
        }else{
            
            var formulario = $(form).serializeArray();
            $.ajax({
                url : '/Biblioteca/LoginUsuario',
                data : formulario,
                dataType : 'json',
                type : 'post',
                success : function(response){
                    if(response.estado == true){
                        window.location.href = "/Biblioteca/Menu";
                    }else{
                        $(btn).html(btnText).prop('disabled',false);
                        BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DANGER,
                            title: 'Error',
                            message: response.mensaje,
                            buttons: [{
                                label: 'Cerrar',
                                cssClass : 'btn-danger',
                                action : function(dialogItself){
                                    dialogItself.close();
                                }
                            }]
                        });
                    }
                }
            });
        }
        
    },
    
    
    registroNuevoUsuario : function(){
        BootstrapDialog.show({
            title : 'Registro Nuevo Usuario',
            message : $('<div></div>').load('views/registro.jsp'),
            buttons : [
                {
                    label: 'Cerrar',
                    action: function(dialogItself){
                        dialogItself.close();
                    }
                },
                {
                    label: 'Registrar',
                    cssClass : 'btn-success',
                    action: function(dialogItself){
                        var $button = this;
                        $button.disable();
                        Login.guardarRegistroNuevoUsuario(dialogItself, this);
                        //$button.spin();
                        //dialogItself.close();
                    }
                }
            ]
        });
    },
    
    
    guardarRegistroNuevoUsuario : function(modal, btn){
        
        limpiarFormularioErrores();
        
        var error = "";
        var $button = btn;
        
        if($("#rut").val() == ""){
            error += "Debe ingresar su rut<br/>";
            $("#rut").parent().addClass('has-error');
        }
        if($("#nombres").val() == ""){
            error += "Debe ingresar su nombre  <br/>";
            $("#nombres").parent().addClass('has-error');
        }
        if($("#apellidos").val() == ""){
            error += "Debe ingresar su apellido  <br/>";
            $("#apellidos").parent().addClass('has-error');
        }
        if($("#clave").val() == ""){
            error += "Debe definir su contraseña  <br/>";
            $("#clave").parent().addClass('has-error');
        }
        
        
        if(error !== ""){
            BootstrapDialog.show({
                type: BootstrapDialog.TYPE_DANGER,
                title: 'Error',
                message: error,
                buttons: [{
                    label: 'Cerrar',
                    cssClass : 'btn-danger',
                    action : function(dialogItself){
                        $button.enable();
                        dialogItself.close();
                    }
                }]
            });   
        }else{
            var formulario = $("#form-registrar-usuario").serializeArray();
            $.ajax({
                url : '/Biblioteca/RegistrarUsuario',
                type : 'post',
                dataType : 'json',
                data : formulario,
                success : function(response){
                    console.log(response);
                    if(response.estado == true){
                        BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_SUCCESS,
                            title: 'Registro',
                            message: response.mensaje,
                            buttons: [{
                                label: 'Aceptar',
                                cssClass : 'btn-success',
                                action : function(dialogItself){
                                    $button.enable();
                                    dialogItself.close();
                                    modal.close();
                                }
                            }]
                        });   
                    }else{
                        BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DANGER,
                            title: 'Error',
                            message: response.mensaje,
                            buttons: [{
                                label: 'Aceptar',
                                cssClass : 'btn-danger',
                                action : function(dialogItself){
                                    $button.enable();
                                    dialogItself.close();
                                }
                            }]
                        });   
                    }
                },
                error : function(){
                    BootstrapDialog.show({
                        type: BootstrapDialog.TYPE_DANGER,
                        title: 'Error',
                        message: 'Error en sistema. Intente nuevamente',
                        buttons: [{
                            label: 'Aceptar',
                            cssClass : 'btn-danger',
                            action : function(dialogItself){
                                $button.enable();
                                dialogItself.close();
                            }
                        }]
                    });  
                }
            });
        }
        
    }
    
    
}