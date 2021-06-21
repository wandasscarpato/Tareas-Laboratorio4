<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
    integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/dd0dcbd0c6.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/style.css">

    <title>Document</title>
</head>
<body>
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
                    <a class="dropdown-item" href="transferencias.jsp">Transferir</a>
                    <a class="dropdown-item" href="#">Historial</a>
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
                      <a class="dropdown-item" href="PagoCuotas.jsp">Pagos</a>
                    </div>
                  </li>
              </ul>
            </div>
          </nav>
    </header>
    <div class="card--modif cm"></div>
      <!--Finaliza el header-->
		      <p></p>
	<div>
		<form>
			<table style="margin: 0 auto;" border="1">	
			<tr>
				<td><strong>Nº de cuota</strong></td>
				<td><strong>Fecha</strong></td>
				<td><strong>Importe</strong></td>
				<td><strong>Pagado</strong></td>
			</tr>
			<tr>
				<td>1/60</td>
				<td>21-01-2021</td>
				<td>1.666,66</td>
				<td><input type="radio" name="Chec1" = Value="true" style-alig></td>
			</tr>
			<tr>
				<td>2/60</td>
				<td>21-02-2021</td>
				<td>1.666,66</td>
				<td><input type="radio" name="Chec2" = Value="true" style-alig></td>
			</tr>
			<tr>
				<td>3/60</td>
				<td>21-03-2021</td>
				<td>1.666,66</td>
				<td><input type="radio" name="Chec3" = Value="true" style-alig></td>
			</tr>
			<tr>
				<td>4/60</td>
				<td>21-04-2021</td>
				<td>1.666,66</td>
				<td><input type="radio" name="Chec4" = Value="true" style-alig></td>
			</tr>
			<tr>
				<td>5/60</td>
				<td>21-05-2021</td>
				<td>1.666,66</td>
				<td><input type="radio" name="Chec5" = Value="true" style-alig></td>
			</tr>
			<tr>
				<td>6/60</td>
				<td>21-06-2021</td>
				<td>1.666,66</td>
				<td><input type="radio" name="Chec6" = Value="true" style-alig></td>
			</tr>
			</table>
		</form>
     </div>
     <p></p>
     <input class="btnEnviarAutorizacionP" type="button" value="Pagar">
      <p></p>
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
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
  integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>


</html>