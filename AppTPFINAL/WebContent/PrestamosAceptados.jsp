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
                Administrador
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="Reportes.jsp">Inicio</a>
                <a class="dropdown-item" href="#">Cerrar sesion</a>
              </div>
            </li>
             <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                Cuentas
              </a>  
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="ABMLxCliente(Cuentas).jsp">Administrar cuentas</a>
                <a class="dropdown-item" href="nuevaCuenta(ADMIN).jsp">Asignar cuentas</a>
              </div> 
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                Prestamos
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="./PrestamosAceptados.jsp">Prestamos autorizados</a>
                <a class="dropdown-item" href="./AutorizacionPrestamos.jsp">Prestamos a autorizar</a>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                Usuarios-Clientes
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="./registrarse.jsp">Crear usuario</a>
                <a class="dropdown-item" href="./BMLxCliente(Admin).jsp">Administras datos</a>
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
    
    <br>
    
  <form class="Form">
    <div >
    <b><h2 class="Centar">Prestamos</h2></b>
    	<br>
    		<div class="container" class="Centar">
  				<div class="row">
	    			<div class="container">
  						<div class="row row-cols-5">
    						<div class="col"><h5>Detalles</h5></div>
    						<div class="col"><h5>Fecha de Aprobacion</h5></div>
    						<div class="col"><h5>Fecha de Expiracion</h5></div>
    						<div class="col"><h5>Cuotas a pagar</h5></div>
    						<div class="col"><h5>Monto</h5></div>
  						</div>
					</div>
					<div class="container">
  						<div class="row row-cols-5">
    						<div class="col"><h5>Prestamos de Hipoteca</h5></div>
    						<div class="col">12/06/2022</div>
    						<div class="col">12/07/2022</div>
    						<div class="col">3 de $638,62</div>
    						<div class="col">$1.915,86</div>
  						</div>
					</div>
					<div class="container">
  						<div class="row row-cols-5">
    						<div class="col"><h5>Prestamos Personales</h5></div>
    						<div class="col">07/05/2022</div>
    						<div class="col">08/09/2022</div>
    						<div class="col">2 de $1.207,92</div>
    						<div class="col">$2.415,84</div>
  						</div>
					</div>
					<div class="container">
  						<div class="row row-cols-5">
    						<div class="col"><h5>Prestamos al Consumo</h5></div>
    						<div class="col">04/10/2019</div>
    						<div class="col">04/12/2020</div>
    						<div class="col">6 de $528,098</div>
    						<div class="col">$3.168,59</div>
  						</div>
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
</html>