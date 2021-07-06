
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="daoImplement.localidadesDaoImplement" %>
<%@page import="entidad.localidad" %>
<%@page import="daoImplement.ProvinciasDaoImplement" %>
<%@page import="entidad.provincia" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/dd0dcbd0c6.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/style.css">
 <script src="sweetalert2.min.js"></script>
<link rel="stylesheet" href="sweetalert2.min.css">
    <title>Registro de Cliente</title>
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
                <a class="dropdown-item" href="./ServletBMLxCli">Administras datos</a>
              </div>
            </li>
          </ul>
          <form class="form-inline my-2 my-lg-0">
          </form>
        </div>
      </nav>
</header>
    <div class="card--modif cm3"></div>
    <!--Finaliza el header-->
    <div class="registrarse">
        <h1>   Registro de Cliente
        </h1>
        <form action="ServletRegistrarCliente" method="post" onsubmit="return validarClaves();">
            <div class="form-div">
                <div>
                    <div class="card--modif"></div>
                    <label for="">Usuario</label> 
                    <input name="usuario" type="text" required> <br>
                    <label for="">Contraseña</label>
                    <input id="clave1" name="pass1" type="password" required><br> 
                    <label  for="">Repita la contraseña</label>
                    <input id="clave2" name="pass2" type="password" required><br>
                    <label for="">Nombre</label>
                    <input  name="nombre"type="text" required><br>
                    <label for="">Apellido</label>
                    <input  name="apellido" type="text" required><br>
                    <label for="">DNI</label>
                    <input  name="DNI" type="number" required><br>
                    <label for="">CUIL</label>
                    <input  name="CUIL" type="number" required><br>
                    <label for="">Sexo</label>
                    <select class="genero" name="genero" id="genero" required>
                        <option value="Masculino">Masculino</option>
                        <option value="Femeninio">Femenino</option>
                    </select>
                    <label for="">Fecha de nacimiento</label>
                    <input  name="nacimiento" type="date" required><br>
                    <label for="">Direccion</label>
                    <input name="direccion" type="text" required><br>
                    <label for="">Localidad</label>
                     <select class="genero" name="localidad" id="localidad" required>
                         <%=request.getAttribute("SelectLoc") %>
                    </select>
                    <label for="">Provincia</label>
                     <select class="genero" name="provincia" id="provincia" required>
                        <%=request.getAttribute("SelectProv") %>
                    </select>
                    <label for="">Correo electronico</label>
                    <input name="email" type="text" required><br>
                    <label for="">Telefonos</label>
                    <input name="telefono" type="number" required><br>            
                    <input class="btnRegistro" type="submit" value="Registrarlo">
                         
                    <div class="card--modif cm2"></div>
                </div>
            </div>
           
        </form>
        
    </div>
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
<script>
function confirmarEnvio(){
	
}
function validarClaves(){
	var clave1 = document.getElementById("clave1").value;
	var clave2 = document.getElementById("clave2").value;
	if(clave1===clave2){
		return true;
	}
	else{
		swal("Las contraseñas no coinciden", "", "error");
		return false;
	}
	
}
</script>
<script src="sweetalert2.all.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
    crossorigin="anonymous"></script>
<script>
var queryString = window.location.search;
var urlParams = new URLSearchParams(queryString);
var ParamStatus = urlParams.get('Status');
if(ParamStatus == "true"){
	swal("Cliente agregado correctamente", "podra visualizarlo en Admin datos clientes", "success");
}else if(ParamStatus == "false"){ 
	swal("Hubo un error al cargar el cliente", "posiblemente ya se encuentre registrado", "error");
}
</script>
</html>