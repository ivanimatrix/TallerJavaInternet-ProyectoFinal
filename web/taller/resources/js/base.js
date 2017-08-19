

function limpiarFormularioErrores(){
    $(".has-error").each(function(){
        $(this).removeClass('has-error');
    });
}


function fechaActual(){
    var f = new Date();
    var mes = f.getMonth() + 1;
    if(mes < 10){
        mes = "0"+mes;
    }
    return f.getDate() + "/" + mes + "/" + f.getFullYear();
}