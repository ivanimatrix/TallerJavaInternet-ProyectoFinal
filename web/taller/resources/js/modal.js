
var Modal = {

    /**
     * Modal para dialogo de confirmacion
     * @param message Mensaje o texto a mostrar
     * @param callback_ok funcion a ejecutar al apretar SI
     * @param callback_no funcion a ejecutar al apretar NO
     */
    confirm : function(message, callback_ok, callback_no){
        BootstrapDialog.confirm({
            title: 'Confirmación',
            message: message,
            type: BootstrapDialog.TYPE_WARNING,
            btnCancelLabel: 'No',
            btnCancelClass : 'btn-flat btn-default',
            btnOKLabel: 'Si',
            btnOKClass: 'btn-flat btn-warning',
            callback: function(result) {
                if(result) {
                    if(typeof callback_ok === 'function'){
                        callback_ok();
                    }
                }else {
                    if(typeof callback_no === 'function'){
                        callback_no();
                    }
                }
            }

        })
    },

    /**
     * Modal para mostrar mensajes de error
     * @param message mensaje a mostrar
     * @param callback funcion a ejecutar
     */
    danger : function(message, callback){
        BootstrapDialog.alert({
            title: 'Error',
            message: message,
            type: BootstrapDialog.TYPE_DANGER,
            buttonLabel: 'Aceptar',
            callback: function(result) {
                if(typeof callback === 'function'){
                    callback();
                }

            }
        });
    },

    /**
     * Modal para mostrar mensajes de exito
     * @param message
     * @param callback
     */
    success : function(message, callback){
        BootstrapDialog.alert({
            title: 'Éxito',
            message: message,
            type: BootstrapDialog.TYPE_SUCCESS,
            buttonLabel: 'Aceptar',
            callback: function(result) {
                if(typeof callback === 'function'){
                    callback();
                }

            }
        });
    },
    
    info : function(message, callback){
        BootstrapDialog.alert({
            title: 'Información',
            message: message,
            type: BootstrapDialog.TYPE_INFO,
            buttonLabel: 'Aceptar',
            callback: function(result) {
                if(typeof callback === 'function'){
                    callback();
                }

            }
        });
    },
    
    warning : function(message, callback){
        BootstrapDialog.alert({
            title: 'Atención',
            message: message,
            type: BootstrapDialog.TYPE_WARNING,
            buttonLabel: 'Aceptar',
            callback: function(result) {
                if(typeof callback === 'function'){
                    callback();
                }

            }
        });
    },

    /**
     * Modal para abrir pop up con otra vista o pagina
     * @param url Url de la vista a cargar
     * @param title Titulo para el modal
     * @param buttons Arreglo de botones de acciones para el modal. Si no se especifican, se crea solo el boton Cerrar modal
     * @param size Tamaño del modal. Puede ser 'sm' para pequeño o 'lg' para ancho
     */
    open : function(url,title,size){

        var modal_size = BootstrapDialog.SIZE_NORMAL;
        if(size == 'sm'){
            modal_size = BootstrapDialog.SIZE_SMALL;
        }else if(size == 'lg'){
            modal_size = BootstrapDialog.SIZE_WIDE;
        }


        BootstrapDialog.show({
            size : modal_size,
            closable : true,
            title : title,
            message: $('<div></div>').load(url),
            buttons : [{
                label: 'Cerrar',
                cssClass: 'btn-default btn-flat',
                action: function(dialogItself){
                    dialogItself.close();
                }
            }]
        });
    },

    /**
     * Cerrar todos los modales abiertos
     */
    closeAll : function(){
        BootstrapDialog.closeAll();
    }


}