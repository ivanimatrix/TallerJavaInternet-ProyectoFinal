

var Vehiculos = {
    
    
    initBandeja : function(){
        
        $.ajax({
            url : BASE_URI + 'VehiculosController',
            type : 'get',
            dataType : 'html',
            async : false,
            data : {action : 'listadoVehiculos'},
            success : function(response){
                $("#contenedor-grilla-vehiculos").html(response);
            }
        });
        
    },
    
    
    nuevoVehiculo : function(){
        Modal.open(BASE_URI + 'VehiculosController?action=nuevoVehiculo','Nuevo Vehículo');
    },
    
    
    editarVehiculo : function(vehiculo){
        Modal.open(BASE_URI + 'VehiculosController?action=editarVehiculo&id_vehiculo='+vehiculo,'Editar Vehículo');
    },
    
    
    guardarVehiculo : function(form, btn){
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
                url : BASE_URI + 'VehiculosController?action=guardarVehiculo',
                type : 'post',
                dataType : 'json',
                data : formulario,
                success : function(response){
                    if(response.estado === true){
                        Modal.success(response.mensaje, function(){
                            Modal.closeAll();
                            Vehiculos.initBandeja();
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
    
    
    eliminarVehiculo : function(vehiculo){
        Modal.confirm("Desea eliminar este vehículo?", function(){
            $.ajax({
                url : BASE_URI + 'VehiculosController?action=eliminarVehiculo',
                type : 'post',
                dataType : 'json',
                data : {id_vehiculo : vehiculo},
                success : function(response){
                    if(response.estado === true){
                        Modal.success(response.mensaje, function(){
                            Vehiculos.initBandeja();
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
    },
    
    
    verTrabajosVehiculo : function(vehiculo){
        Modal.open(BASE_URI + 'RevisionesController?action=listadoTrabajos&id_vehiculo='+vehiculo, 'Listado de Trabajos');
    }
    
    
}
