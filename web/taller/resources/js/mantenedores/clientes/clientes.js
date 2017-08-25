

var Clientes = {
    
    
    initBandeja : function(){
        
        $.ajax({
            url : '/ProyectoTallerMecanico/ClientesController',
            type : 'get',
            dataType : 'html',
            async : false,
            data : {action : 'listadoClientes'},
            success : function(response){
                $("#contenedor-grilla-clientes").html(response);
            }
        });
        
    },
    
    
    nuevoCliente : function(){
        Modal.open('/ProyectoTallerMecanico/ClientesController?action=nuevoCliente','Nuevo Cliente');
    },
    
    
    editarCliente : function(cliente){
        Modal.open('/ProyectoTallerMecanico/ClientesController?action=editarCliente&id_cliente='+cliente,'Nuevo Cliente');
    },
    
    
    guardarCliente : function(form, btn){
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
                url : '/ProyectoTallerMecanico/ClientesController?action=guardarCliente',
                type : 'post',
                dataType : 'json',
                data : formulario,
                success : function(response){
                    if(response.estado === true){
                        Modal.success(response.mensaje, function(){
                            Modal.closeAll();
                            Clientes.initBandeja();
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
    }
    
    
}
