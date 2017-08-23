

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
        
    }
    
    
}
