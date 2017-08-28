

var Usuarios = {
    
    guardarMisDatos : function(form, btn){
        var btnText = $(btn).prop('disabled', true).html();
        $(btn).html('Modificando... <i class="fa fa-spin fa-spinner"></i>');
        
        var error = "";
        
        if(form.rut.value === ""){
            error += "- Su RUT no puede quedar vacío<br/>";
        }
        if(form.nombres.value === ""){
            error += "- Debe ingresar su(s) nombre(s)<br/>";
        }
        if(form.apellidos.value === ""){
            error += "- Debe ingresar su(s) apellido(s)<br/>";
        }
        
        if(error !== ""){
            Modal.danger(error, function(){
                $(btn).html(btnText).prop('disabled', false);
            });
        }else{
            $.ajax({
                url : BASE_URI + 'UsuarioController?action=guardarMisDatos',
                data : $(form).serializeArray(),
                type : 'post',
                dataType : 'json',
                success : function(response){
                    if(response.estado === true){
                        Modal.success(response.mensaje);
                    }else{
                        Modal.danger(response.mensaje);
                    }
                    $(btn).html(btnText).prop('disabled', false);
                },
                error : function(){
                    Modal.danger("Error interno. Intente nuevamente", function(){
                        $(btn).html(btnText).prop('disabled', false);
                    });
                }
            });
        }
    },
    
    
    guardarPassword : function(form, btn){
        var btnText = $(btn).prop('disabled', true).html();
        $(btn).html('Actualizando... <i class="fa fa-spin fa-spinner"></i>');
        
        var error = "";
        
        if(form.nueva_pass.value === ""){
            error += "- Su contraseña no puede quedar vacía<br/>";
        }
        if(form.nueva_pass.value !== form.repetir_pass.value){
            error += "- Las contraseñas no coinciden<br/>";
        }
        
        if(error !== ""){
            Modal.danger(error, function(){
                $(btn).html(btnText).prop('disabled', false);
            });
        }else{
            $.ajax({
                url : BASE_URI + 'UsuarioController?action=guardarPassword',
                data : $(form).serializeArray(),
                type : 'post',
                dataType : 'json',
                success : function(response){
                    if(response.estado === true){
                        Modal.success(response.mensaje);
                    }else{
                        Modal.danger(response.mensaje);
                    }
                    form.nueva_pass.value = "";
                    form.repetir_pass.value = "";
                    $(btn).html(btnText).prop('disabled', false);
                },
                error : function(){
                    Modal.danger("Error interno. Intente nuevamente", function(){
                        $(btn).html(btnText).prop('disabled', false);
                    });
                }
            });
        }
    }
    
}