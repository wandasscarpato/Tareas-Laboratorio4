<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entidad.cuenta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/dd0dcbd0c6.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/cssIvan.css">
<link rel="stylesheet" href="./css/styleVistas.css">  



<title>Document</title>
</head>
<body>
	<header> <img
		src="https://1.bp.blogspot.com/-Oxolc8k-Ub8/V-QmH4vkFGI/AAAAAAAABx8/TK7MzZsZ_TEqTaQxZGeh2qzFNtpOyGFQgCLcB/s1600/BAnk%2BOf%2Bamerica%2BLogo.jpg"
		alt=""> <nav
		class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Administrador </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="Reportes.jsp">Inicio</a> <a
						class="dropdown-item" href="#">Cerrar sesion</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Cuentas </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="ABMLxCliente(Cuentas).jsp">Administrar
						cuentas</a> <a class="dropdown-item" href="nuevaCuenta(ADMIN).jsp">Asignar
						cuentas</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Prestamos </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="./PrestamosAceptados.jsp">Prestamos
						autorizados</a> <a class="dropdown-item"
						href="./AutorizacionPrestamos.jsp">Prestamos a autorizar</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Usuarios-Clientes </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="./registrarse.jsp">Crear usuario</a>
					<a class="dropdown-item" href="./BMLxCliente(Admin).jsp">Administras
						datos</a>
				</div></li>
		</ul>
		<form class="form-inline my-2 my-lg-0"></form>
	</div>
	</nav> </header>
	<div class="card--modif cm"></div>
	<!--Finaliza el header-->
	<div class="adminCuentas">
		<h1>Administraci�n de cuentas</h1>
		<form method="post" action="ServletListarCuentas">
			<div class="form-divAdminCuentas admincuentas2">
				<div class="card--modif"></div>

				<div class="buscadoresFechas">
					<div>
						<label>Ingrese el DNI del cliente:</label>
					</div>
					<div>
						<input type="text" name="txtDni">
					</div>
					<div>
						<input class="btnBuscar" type="submit" value="Buscar"
							name="btnBuscar">
					</div>
				</div>
			</div>
		</form>

		<p></p>
		<table style="margin: 0 auto;" border="1">
			<tr>
				<th><strong>N� CUENTA</strong></th>
				<th><strong>TIPO</strong></th>
				<th><strong>MONEDA</strong></th>
				<th><strong>CBU</strong></th>
				<th><strong>SALDO</strong></th>
				<th><strong>ESTADO</strong></th>
				<th><strong>BAJA CUENTA</strong></th>
				<th><strong>MOD. CUENTA</strong></th>
			</tr>
			<%
				//SE TRAE LA LISTA DE CUENTAS
				if (request.getAttribute("ListarCuentas") != null) {
					List<cuenta> listacuenta = new ArrayList<cuenta>();
					listacuenta = (List<cuenta>) request.getAttribute("ListarCuentas");

					for (cuenta cue : listacuenta) {
			%>
			<tr>
				<form action="ServletListarCuentas" method="post">
					<td><%=cue.getN_Cuenta()%> <input type="hidden"
						name="N_Cuenta" value="<%=cue.getN_Cuenta()%>"></td>
					<td><%=cue.getTipo()%></td>
					<td><%=cue.getMoneda()%></td>
					<td><%=cue.getCBU()%></td>
					<td><%=cue.getSaldo()%></td>
					<td><%=cue.getEstado()%></td>
					<td><input type="submit" name="btnBaja" value="Eliminar"></td>
					<td><input type="submit" name="btnModificar" value="Modificar"></td>
				</form>
			</tr>
			<%
				}
				}
			%>
		</table>
		</form>
	</div>
	<p></p>
	<section class="sectionMenuDeCuentas">
	<div class="menuDeCuentas">
		<div>
			<input class="btnMenuDeCuentas" type="button"
				value="Dar de alta nueva cuenta">
		</div>
		<div>
			<input class="btnMenuDeCuentas" type="button"
				value="Dar de baja cuenta seleccionada">
		</div>
		<div>
			<input class="btnMenuDeCuentas" type="button"
				value="Modificar cuenta seleccionada">
		</div>
	</div>
	</section>
	<!--Comienza el footer-->
	<footer>
	<div>
		<span>Navegacion</span>
		<ul>
			<li>�Quienes somos?</li>
			<li>Seguridad</li>
			<li>Ayuda</li>
			<li>Protocolos</li>
			<li>Contacto</li>
		</ul>
	</div>
	<div>
		<span>Legales</span>
		<ul>
			<li>R�gimen de transparencia</li>
			<li>Usuario Bancario</li>
			<li>C�digo de Conducta</li>
			<li>Estados contables</li>
			<li>T�rminos y condiciones</li>
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
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
</html>