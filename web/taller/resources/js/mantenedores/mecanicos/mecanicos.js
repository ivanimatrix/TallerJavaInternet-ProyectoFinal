

var Mecanicos = {
    
    
    initBandeja : function(){
        
        $.ajax({
            url : BASE_URI + 'MecanicosController',
            type : 'get',
            dataType : 'html',
            async : false,
            data : {action : 'listadoMecanicos'},
            success : function(response){
                $("#contenedor-grilla-mecanicos").html(response);
            }
        });
        
    },
    
    
    nuevoMecanico : function(){
        Modal.open('/ProyectoTallerMecanico/MecanicosController?action=nuevoMecanico','Nuevo Mecánico');
    },
    
    
    editarMecanico : function(cliente){
        Modal.open('/ProyectoTallerMecanico/MecanicosController?action=editarMecanico&id_mecanico='+cliente,'Editar Mecánico');
    },
    
    
    guardarMecanico : function(form, btn){
        var btnText = $(btn).prop('disabled', true).html();
        $(btn).html('Guardando... <i class="fa fa-spin fa-spinner"></i>');
        
        var error = "";
        
        
        if(error !== ""){
            Modal.danger(error, function(){
                $(btn).prop('disabled', false).html(btnText);
            });
        }else{
            var formulario = $(form).serializeArray();
            $.ajax({
                url : '/ProyectoTallerMecanico/MecanicosController?action=guardarMecanico',
                type : 'post',
                dataType : 'json',
                data : formulario,
                success : function(response){
                    if(response.estado === true){
                        Modal.success(response.mensaje, function(){
                            Modal.closeAll();
                            Mecanicos.initBandeja();
                        });
                    }else{
                        Modal.danger(response.mensaje, function(){
                            $(btn).prop('disabled', false).html(btnText);
                        });
                    }
                },
                error : function(){
                    Modal.danger('Error interno', function(){
                        $(btn).prop('disabled', false).html(btnText);
                    });
                }
            });
        }
    },
    
    
    eliminarMecanico : function(mecanico){
        Modal.confirm("Desea eliminar este mecánico?", function(){
            $.ajax({
                url : BASE_URI + 'MecanicosController?action=eliminarMecanico',
                type : 'post',
                dataType : 'json',
                data : {id_mecanico : mecanico},
                success : function(response){
                    if(response.estado === true){
                        Modal.success(response.mensaje, function(){
                            Mecanicos.initBandeja();
                        });
                    }else{
                        Modal.danger(response.mensaje);
                    }
                },
                error : function(){
                    Modal.danger('Error interno');
                }
            });
        });
    }
    
    
}
