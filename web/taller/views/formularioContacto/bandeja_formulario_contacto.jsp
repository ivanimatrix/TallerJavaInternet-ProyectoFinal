
<%@page import="models.FormularioContactoDTO"%>
<%@page import="java.util.List"%>

<% List<FormularioContactoDTO> listado = (List<FormularioContactoDTO>) request.getAttribute("listado"); %>

<!DOCTYPE html>
<html>
    <%@include file="../head.html" %>
    <body>
        <div class="container">
            <%@include file="../menu.jsp" %>

            <div class="row">
                <div class="col-xs-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Bandeja de Mensajes (Formulario Contacto Web Corporativa)</h3>
                        </div>
                        <div class="panel-body">
                            <div class="col-xs-12">
                                <div class="">
                                    <div class="table-responsive top-spaced" id="contenedor-grilla-vehiculos">
                                        <table class="table table-hover table-striped table-condensed table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Fecha</th>
                                                    <th>Nombres</th>
                                                    <th>Apellidos</th>
                                                    <th>Email</th>
                                                    <th>Teléfono</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% if (listado == null) { %>
                                                <tr>
                                                    <td colspan="4" class="text-center">
                                                        <div class="alert alert-info">
                                                            No existen mensajes enviados
                                                        </div>
                                                    </td>
                                                </tr>
                                                <% } else { %>
                                                <% for (FormularioContactoDTO contacto : listado) { %>
                                                <tr>
                                                    <td class="text-center"><%=contacto.getFecha_contacto()%></td>
                                                    <td class="text-center"><%=contacto.getNombres_contacto()%></td>
                                                    <td class="text-center"><%=contacto.getApellidos_contacto()%></td>
                                                    <td class="text-center"><%=contacto.getEmail_contacto()%></td>
                                                    <td class="text-center"><%=contacto.getTelefono_contacto()%></td>
                                                    <td class="text-center">
                                                        <button type="button" class="btn btn-primary btn-sm" title="Ver Mensaje" onclick="Modal.open('/ProyectoTallerMecanico/ContactoController?action=verMensaje&id_mensaje=<%=contacto.getId_contacto()%>','Ver Mensaje');"><i class="fa fa-search"></i></button>
                                                    </td>
                                                </tr>
                                                <% } %>
                                                <% }%>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

    
</html>