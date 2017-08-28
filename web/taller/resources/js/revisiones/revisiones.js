

var Revisiones = {
    
    
    buscarPatente : function(form, btn){
        console.log(form);
        var btnText = $(btn).prop('disabled', true).html();
        $(btn).html('Buscando...<i class="fa fa-spin fa-spinner"></i>');
        
        if(form.patente.value === ""){
            Modal.danger("Debe ingresar la patente a buscar", function(){
                $(btn).html(btnText).prop('disabled', false);
            });
        }else{
            $.ajax({
                url : BASE_URI + 'RevisionesController?action=buscarPatente',
                type : 'post',
                data : {patente: form.patente.value},
                dataType : 'html',
                success :  function(response){
                    $("#contenedor-resultado-patente").html(response);
                    $(btn).html(btnText).prop('disabled', false);
                },
                error : function(){
                    Modal.danger("Error interno", function(){
                        $(btn).html(btnText).prop('disabled', false);
                    });
                }
                
            });
        }
    },
    
    
    nuevoTrabajo : function(vehiculo){
        Modal.open(BASE_URI + 'RevisionesController?action=nuevoTrabajo&id_vehiculo='+vehiculo, 'Nuevo Trabajo');
    },
    
    /**
     * Guardar el trabajo ingresado
     * @param {type} form
     * @param {type} btn
     * @returns {undefined}
     */
    guardarTrabajo : function(form, btn){
        var btnText = $(btn).prop('disabled', true).html();
        $(btn).html('Guardando...<i class="fa fa-spin fa-spinner"></i>');
        
        var error = "";
        
        if(form.descripcion.value === ""){
            error += "Debe ingresar la descripción del trabajo<br/>";
        }
        if(form.fecha.value === ""){
            error += "Debe seleccionar la fecha del trabajo<br/>";
        }
        if(form.valor.value === ""){
            error += "Debe ingresar valor deł trabajo realizado<br/>";
        }
        
        if(error !== ""){
            Modal.danger(error, function(){
                $(btn).html(btnText).prop('disabled', false);
            });
        }else{
            $.ajax({
                url : BASE_URI + 'RevisionesController?action=guardarTrabajo',
                data :  $(form).serializeArray(),
                type : 'post',
                dataType : 'json',
                success : function(response){
                    if(response.estado === true){
                        Modal.success(response.mensaje, function(){
                            Modal.closeAll();
                            $("#total_trabajos").html(response.total_trabajos);
                        });
                    }else{
                        Modal.danger(response.mensaje, function(){
                            $(btn).html(btnText).prop('disabled', false);
                        });
                    }
                },
                error : function(){
                    Modal.danger("Error interno", function(){
                        $(btn).html(btnText).prop('disabled', false);
                    });
                }
            });
        }
        
    },
    
    
    cargarListadoTrabajoVehiculo : function(vehiculo){
        Modal.open(BASE_URI + 'RevisionesController?action=listadoTrabajos&id_vehiculo='+vehiculo, 'Listado de Trabajos');
    },
    
    
    cargarListadoTrabajosMecanico : function(mecanico){
        
    }
    
}