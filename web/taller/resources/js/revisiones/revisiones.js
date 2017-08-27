

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
    }
    
    
}