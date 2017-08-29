
<%@page import="models.FormularioContactoDTO"%>

<% FormularioContactoDTO mensaje = (FormularioContactoDTO) request.getAttribute("mensaje"); %>
<div class="row">
    
    <div class="col-xs-12">
        <div class="form-group">
            <label>Fecha</label>
            <p><%=mensaje.getFecha_contacto()%></p>
        </div>
        <div class="form-group">
            <label>Nombres</label>
            <p><%=mensaje.getNombres_contacto()%></p>
        </div>
        <div class="form-group">
            <label>Apellidos</label>
            <p><%=mensaje.getApellidos_contacto()%></p>
        </div>
        <div class="form-group">
            <label>Email</label>
            <p><%=mensaje.getEmail_contacto()%></p>
        </div>
        <div class="form-group">
            <label>Teléfono</label>
            <p><%=mensaje.getTelefono_contacto()%></p>
        </div>
        <div class="form-group">
            <label>Mensaje</label>
            <p><%=mensaje.getMensaje_contacto()%></p>
        </div>
    </div>
    
</div>