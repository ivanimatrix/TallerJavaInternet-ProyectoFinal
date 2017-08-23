<%@page import="models.UsuarioDTO"%>
<%
    HttpSession sesion = request.getSession();
    UsuarioDTO user = (UsuarioDTO) sesion.getAttribute("usuario");
%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Taller Mec�nico</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
            <ul class="nav navbar-nav">
                <li><a href="/ProyectoTallerMecanico/HomeController">Inicio <span class="sr-only">(current)</span></a></li>
                <li><a href="#">Trabajos</a></li>
                <% if(user.getPerfil_usuario() == 1){%>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Mantenedores <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/ProyectoTallerMecanico/ClientesController?action=indexClientes">Clientes</a></li>
                        <li><a href="#">Mec�nicos</a></li>
                        <li><a href="#">Veh�culos</a></li>
                    </ul>
                </li>
                <%}%>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><%=user.getNombres_usuario()%> <%=user.getApellidos_usuario()%> <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Mi cuenta</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="javascript:void(0);" onclick="cerrarSesion();">Cerrar Sesi�n</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
