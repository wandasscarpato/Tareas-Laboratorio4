<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidad.n_prestamo"%>
<%@page import="daoImplement.prestamosDaoImplement"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/cssAdriel.css">
<link rel="stylesheet" href="./css/jquery.dataTables.min.css">

<title>Document</title>
<script src="https://kit.fontawesome.com/dd0dcbd0c6.js"
	crossorigin="anonymous"></script>
</head>
<body>

	<!--Finaliza el header-->
	<header>
    <img src="https://1.bp.blogspot.com/-Oxolc8k-Ub8/V-QmH4vkFGI/AAAAAAAABx8/TK7MzZsZ_TEqTaQxZGeh2qzFNtpOyGFQgCLcB/s1600/BAnk%2BOf%2Bamerica%2BLogo.jpg" alt="">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                Administrador
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="Reportes.jsp">Inicio</a>
                    <a class="dropdown-item" href="ServletLogout">Cerrar sesion</a>
              </div>
            </li>
             <li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
				aria-haspopup="true" aria-expanded="false"> 
				Cuentas 
				</a>
				<form class="form-divModContra" method= "post" action="ServletCuenta">
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<button class="dropdown-item" name="btnList">Administrar cuentas</button>
					<a class="dropdown-item" href="nuevaCuenta(ADMIN).jsp">Asignar cuentas</a>
				</div>
				</form>
			</li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                Prestamos
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="./PrestamosAceptados.jsp">Prestamos autorizados</a>
                                <a class="dropdown-item" href="./ServletAutorizarPrestamos">Prestamos a autorizar</a>

              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                Usuarios-Clientes
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="./registrarse.jsp">Crear usuario</a>
                <a class="dropdown-item" href="./ServletBMLxCli">Administras datos</a>
                <form method="post" action="ServletUsuario">
                    <button class="dropdown-item" name="btnList">Cambio de contraseñas</button>
                </form>
            </div>
            </li>
          </ul>
          <form class="form-inline my-2 my-lg-0">
          </form>
        </div>
      </nav>
</header>
	<div class="card--modif cm"></div>
	<!--Finaliza el header-->
<%if(session.getAttribute("TipoLog")=="Administrador"){
    } else {
    	if(session.getAttribute("DNI")!=null){
    		%><script>
        	location.href = "PerfilCliente.jsp";
        	</script><%
    	} else {%>
	    	<script>
	    	location.href = "InicioSesion.jsp";
	    	</script>
    	<%}
    }
    %>

	<div class="prestamo">
		<h1>Prestamos autorizados</h1>


		<table id="tablaClientes" class="tablaClientes display" border="1">
			<thead>
				<tr>
					<th>Nro Prestamo</th>
					<th>DNI</th>
					<th>Importe Solicitado</th>
					<th>Intereses</th>
					<th>Monto por mes</th>
					<th>Cuotas</th>
					<th>Nro de cuenta a Depositar</th>
				</tr>
			<thead>
			<tbody>


				<%
					prestamosDaoImplement pDao = new prestamosDaoImplement();
					ArrayList<n_prestamo> listaPrestamos = (ArrayList<n_prestamo>) pDao.listarPrestamos();

					for (n_prestamo presta : listaPrestamos) {
				%>
				
					<%if(presta.isEstado() != false){ %>
					<tr>
					<td><%=presta.getN_Prestamo()%></td>
					<td><%=presta.getDNI()%></td>
					<td><%=presta.getImporte_pedido()%></td>
					<td><%=presta.getImporte_intereses()%></td>
					<td><%=presta.getMontoxMes()%></td>
					<td><%=presta.getCuotas()%></td>
					<td><%=presta.getN_cuentaADepositar()%></td>
					</tr>
					<%}%>
					
				
				<%
					}
				%>
			</tbody>
		</table>


	</div>
	<!--Comienza el footer-->
	<footer>
	<div>
		<span>Navegacion</span>
		<ul>
			<li>¿Quienes somos?</li>
			<li>Seguridad</li>
			<li>Ayuda</li>
			<li>Protocolos</li>
			<li>Contacto</li>
		</ul>
	</div>
	<div>
		<span>Legales</span>
		<ul>
			<li>Régimen de transparencia</li>
			<li>Usuario Bancario</li>
			<li>Código de Conducta</li>
			<li>Estados contables</li>
			<li>Términos y condiciones</li>
		</ul>
	</div>
	<div>
		<img src="https://www.brubank.com/static/usuariosfinancieros.png"
			alt="">
	</div>
	<div>
		<ul>
			<li><i class="fab fa-twitter footer-icono"></i></li>
			<li><i class="fab fa-facebook footer-icono"></i></li>
			<li><i class="fab fa-instagram footer-icono"></i></li>
		</ul>
	</div>
	</footer>
	<%if(session.getAttribute("TipoLog")=="Administrador"){
} else {
    if(session.getAttribute("TipoLog")=="Usuario"){
        %><script>
        location.href = "PerfilCliente.jsp";
        </script><%
    } else {
        %><script>
        location.href = "InicioSesion.jsp?NoLog=1&Redirect=PAGINAINTENTOENTRAR";
        </script><%
    }
}
%>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="./js/jquery.dataTables.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#tablaClientes').DataTable();
		});
	</script>
	<script type="text/javascript" src="./js/jquery.dataTables.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#tablaClientes').DataTable();
		});
	</script>
</body>
</html>