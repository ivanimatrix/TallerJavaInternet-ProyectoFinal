<div class="row">
    
    <div class="col-xs-12">
        
        <form class="form-horizontal" role="form">
            <input type="hidden" name="id_vehiculo" id="id_vehiculo" value="${id_vehiculo}" />
            
            <div class="form-group">
                <label class="col-xs-12">Fecha de la revisión</label>
                <div class="col-xs-12 col-sm-8 col-md-6">
                    <input type="date" class="form-control" name="fecha" id="fecha" />
                </div>
            </div>
            
            <div class="form-group">
                <label class="col-xs-12">Valor del trabajo</label>
                <div class="col-xs-12 col-sm-8 col-md-6">
                    <input type="number" class="form-control" name="valor" id="valor" min="0"/>
                </div>
            </div>  
            
            <div class="form-group">
                <label class="col-xs-12">Descripción del trabajo</label>
                <div class="col-xs-12">
                    <textarea class="form-control" name="descripcion" id="descripcion" rows="6"></textarea>
                </div>
            </div>
            
            <div class="text-right">
                <button type="button" class="btn btn-success" onclick="Revisiones.guardarTrabajo(this.form, this);">Guardar</button>
            </div>
        </form>
        
    </div>
    
</div>