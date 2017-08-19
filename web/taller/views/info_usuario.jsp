<%@page import="models.UsuarioDTO"%>
<%
HttpSession sesion = request.getSession(); 
UsuarioDTO user = (UsuarioDTO) sesion.getAttribute("usuario");
%>
<div class="row col-xs-12 col-md-3 pull-right">
    <div class="alert alert-success text-center">
        <i class="fa fa-user"></i>
        <span style="display:block">
            <%=user.getNombres_usuario()%> <%=user.getApellidos_usuario()%>
        </span>
        <a href="/Biblioteca/Logout" style="color:#fff"><i class="fa fa-sign-out"></i> Cerrar sesión</a>
    </div>
</div>