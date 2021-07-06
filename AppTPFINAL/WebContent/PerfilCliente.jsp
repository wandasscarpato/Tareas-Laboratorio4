<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <link rel="stylesheet" href="./css/cssAdriel.css">

    <title>Document</title>
    <script src="https://kit.fontawesome.com/dd0dcbd0c6.js" crossorigin="anonymous"></script>
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
                    Cuenta
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="PerfilCliente.jsp">Inicio</a>
                    <a class="dropdown-item" href="ServletLogout">Cerrar sesion</a>
                  </div>
                </li>
				<li class="nav-item dropdown">
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Mis datos</a>
                    <a class="dropdown-item" href="misCuentas.jsp">Mis cuentas</a>
                    <a class="dropdown-item" href="#">Agregar cuenta</a>
                  </div>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Transferencias
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="transferencias.jsp">Cuenta</a>
                    <a class="dropdown-item" href="PerfilCliente.jsp">Inicio</a>
                    <a class="dropdown-item" href="/ServletLogout">Cerrar sesion</a>
                  </div>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Prestamos
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="solicitarPrestamo.jsp">Mis prestamos</a>
                  </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                      aria-haspopup="true" aria-expanded="false">
                      Menu de pagos
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <a class="dropdown-item" href="#">Pagos</a>
                    </div>
                  </li>
              </ul>
              <div class="form-inline my-2 my-lg-0">
              <h6>Usuario: <%= session.getAttribute("Usuario") %> DNI: <%= session.getAttribute("DNI") %></h6>
             </div>
            </div>
          </nav>
    </header>
    <div class="card--modif cm"></div>
    <!--Finaliza el header-->
    <br>
    <%if(session.getAttribute("TipoLog")!="Administrador" && session.getAttribute("DNI")!=null){
    } else {%>
	    	<script>
	    	location.href = "InicioSesion.jsp";
	    	</script>
    	<%
    }
    %>
   <form class="Form" >
    <div >
    <b><h2 class="Centar-Izquierda"><u>Mi Perfil</u></h2></b>
    	<br>
    		<div class="container" class="Centar">
  				<div class="row">
	    			<div class="col"><h5>Cuil:</h5></div>
	    			<!-- En un futuro cambiar la segunda columna por <!=Variable-->
	    			<div class="col">20413140790</div>
	    			<div class="w-100"></div>
	    			<div class="col"><h5>Nombre:</h5></div>
	    			<!-- En un futuro cambiar la segunda columna por <!=Variable-->
	    			<div class="col">Adriel</div>
	    			<div class="w-100"></div>
	    			<div class="col"><h5>Apellido:</h5></div>
	    			<!-- En un futuro cambiar la segunda columna por <!=Variable-->
	    			<div class="col">Lopez</div>
	    			<div class="w-100"></div>
	    			<div class="col"><h5>Nacionalidad:</h5> </div>
	    			<!-- En un futuro cambiar la segunda columna por <!=Variable-->
	    			<div class="col">Argentina</div>
	    			<div class="w-100"></div>
	    			<div class="col"><h5>Fecha de Nacimiento:<h5></div>
	    			<!-- En un futuro cambiar la segunda columna por <!=Variable-->
	    			<div class="col">16/02/1999</div>
	    			<div class="w-100"></div>
	    			<div class="col"><h5>Direccion:</h5></div>
	    			<!-- En un futuro cambiar la segunda columna por <!=Variable-->
	    			<div class="col">Las Retamas 916</div>
	    			<div class="w-100"></div>
	    			<div class="col"><h5>Localidad:</h5></div>
	    			<!-- En un futuro cambiar la segunda columna por <!=Variable-->
	    			<div class="col">Escobar</div>
	    			<div class="w-100"></div>
	    			<div class="col"><h5>Provincia:</h5></div>
	    			<!-- En un futuro cambiar la segunda columna por <!=Variable-->
	    			<div class="col">Buenos Aires</div>
	    			<div class="w-100"></div>
  				</div>
			</div>
    		<br>
    		<br>
    		<br>
   		 </div>
    </form>
   
   
    <!--Comienza el footer-->
    <footer>
        <div>
            <span>Navegacion</span>
            <ul>
                <li>
                    ¿Quienes somos?
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
                    Régimen de transparencia
                </li>
                <li>
                    Usuario Bancario
                </li>
                <li>
                    Código de Conducta
                </li>
                <li>
                    Estados contables
                </li>
                <li>
                    Términos y condiciones
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

<script type="text/javascript"
src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
crossorigin="anonymous"></script>
<script
src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
crossorigin="anonymous"></script>
</html>