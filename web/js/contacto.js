/**
 * Funcion para quitar borde rojo de campos erroneos en formulario de contacto
 */
function limpiarCamposRojos(){
    $(".has-error").each(function(){
        $(this).removeClass('has-error');
    });
}

/**
 * Funcion para validar y enviar formulario de contacto
 * @param formulario Formulario enviado
 * @param boton Boton que genera el envio
 */
function enviarFormulario(formulario, boton){

    limpiarCamposRojos();

    var textoBoton = $(boton).prop('disabled', true).html();
    $(boton).html('<i class="fa fa-spin fa-spinner"></i> Enviando');

    var error = false;

    if(formulario.nombres.value == ""){
        $(formulario.nombres).parent().addClass('has-error');
        error = true;
    }

    if(formulario.apellidos.value == ""){
        $(formulario.apellidos).parent().addClass('has-error');
        error = true;
    }

    if(formulario.mensaje.value == ""){
        $(formulario.mensaje).parent().addClass('has-error');
        error = true;
    }

    if(error){
        $("#mensaje-error").html('<i class="fa fa-exclamation-circle"></i> <strong>Revise los campos marcados en rojo</strong>');
        $("#contenedor-mensaje-error").removeClass('hidden');
        $(boton).html(textoBoton).prop('disabled', false);
    }else{
        limpiarCamposRojos();
        $("#contenedor-mensaje-error").addClass('hidden');
        alert("Por el momento el envio de mensajes se encuentra deshabilitado");

    }
}

