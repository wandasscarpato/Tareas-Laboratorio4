<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.util.ArrayList"%>
	<%@page import="java.util.List"%>
	<%@page import="entidad.n_prestamo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
    integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/dd0dcbd0c6.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/styleVistas.css">

    <title>Document</title>
</head>
<body>
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
					<a class="dropdown-item" href="./AceptarCuentas(Admin).jsp">Asignar cuentas</a>
				</div>
				</form>
			</li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                Prestamos
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="./ServletPrestamosAceptados">Prestamos autorizados</a>
                                <a class="dropdown-item" href="./ServletAutorizarPrestamos">Prestamos a autorizar</a>

              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                Usuarios-Clientes
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="./ServletRegistro">Crear usuario</a>
                <a class="dropdown-item" href="./ServletBMLxCli">Administras datos</a>
                <form method="post" action="ServletUsuario">
                    <button class="dropdown-item" name="btnList">Cambio de contrase�as</button>
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
      <p></p>
      <form method="post" action="ServletPrestamosAceptados">
      	<div class="buscadoresFechas">
		<div>
			<input class="primeraFecha" type="date" id="primeraFecha" name="primeraFecha" max='2000-13-13' requerid>
		</div>
		<div>
			<input class="segundaFecha" type="date" id="segundaFecha" name="segundaFecha" max='2000-13-13' requerid>
		</div>
		<div>
			<input class="btnBuscar" type="submit" value="Buscar" name="btnFechas">
		</div>
		</div>
		</form>
      <!--Comienza el review -->
		
	<!--Termina el review -->
		
	<!--Comienza el listado -->
			<table style="margin: 0 auto;" border="1">	
			<tr>
				<th><strong>TOTAL GANADO</strong></th>
				<th><strong>CANTIDAD DE PRESTAMOS</strong></th>
				<th><strong>FECHA</strong></th>
			</tr>
			<%
				if(request.getAttribute("Reporte1") !=null){
					List<n_prestamo> listaReporte = new ArrayList<n_prestamo>();
					listaReporte = (List<n_prestamo>) request.getAttribute("Reporte1");
					
					for(n_prestamo n_p: listaReporte){%>
					<tr>
						<td> <%= n_p.getImporte_intereses() %> </td>
						<td> <%= n_p.getDNI() %></td>
						<td> <%= n_p.getFecha() %></td>
					</tr>
					<%
					}
					}
					%>
			</table>
	  <!--Termina el listado -->
      
      <!--Comienza el footer-->
    <footer>
        <div>
            <span>Navegacion</span>
            <ul>
                <li>
                    �Quienes somos?
                </li>
                <li>
                    Seguridad
                </li>
                <li>
                    Ayuda
                </li>
                <li>
                    Protocolos
                </li>
                <li>
                    Contacto
                </li>
            </ul>
        </div>
        <div>
            <span>Legales</span>
            <ul>
                <li>
                    R�gimen de transparencia
                </li>
                <li>
                    Usuario Bancario
                </li>
                <li>
                    C�digo de Conducta
                </li>
                <li>
                    Estados contables
                </li>
                <li>
                    T�rminos y condiciones
                </li>
            </ul>
        </div>
        <div>
            <img src="https://www.brubank.com/static/usuariosfinancieros.png" alt="">
        </div>
        <div>
            <ul>
                <li>
                    <i class="fab fa-twitter footer-icono"></i>
                </li>
                <li>
                    <i class="fab fa-facebook footer-icono"></i>
                </li>
                <li>
                    <i class="fab fa-instagram footer-icono"></i>
                </li>
            </ul>
        </div>
    </footer>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
  integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

<script>
var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; //January is 0!
var yyyy = today.getFullYear();
 if(dd<10){
        dd='0'+dd
    } 
    if(mm<10){
        mm='0'+mm
    } 

today = yyyy+'-'+mm+'-'+dd;
document.getElementById("primeraFecha").setAttribute("max", today);
document.getElementById("segundaFecha").setAttribute("max", today);
</script>


</html>