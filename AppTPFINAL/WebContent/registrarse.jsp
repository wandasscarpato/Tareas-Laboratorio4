
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

    <title>Registro de Cliente</title>
</head>

<body>
    <header>
    	<a href="index.jsp">
			<img src="./imgs/logo.png">
        </a>
    </header>
    <div class="card--modif cm3"></div>
    <!--Finaliza el header-->
    <div class="registrarse">
        <h1>   Registro de Cliente
        </h1>
        <form action="RegistrarClienteServlet" method="post">
            <a class="volver" href="./index.jsp">volver al menu principal</a>
            <div class="form-div">
                <div>
                    <div class="card--modif"></div>
                    <label for="">Usuario</label> 
                    <input name="usuario" type="text" required> <br>
                    <label for="">Contraseña</label>
                    <input  name="pass" type="password" required><br> 
                    <label for="">Nombre</label>
                    <input  name="nombre"type="text" required><br>
                    <label for="">Apellido</label>
                    <input  name="apellido" type="text" required><br>
                    <label for="">DNI</label>
                    <input  name="DNI" type="number" required><br>
                    <label for="">CUIL</label>
                    <input  name="CUIL" type="number"><br>
                    <label for="">Sexo</label>
                    <select class="genero" name="genero" id="genero">
                        <option value="1">Masculino</option>
                        <option value="2">Femenino</option>
                        <option value="0">Otro</option>
                    </select>
                    <label for="">Fecha de nacimiento</label>
                    <input  name="nacimiento" type="date"><br>
                    <label for="">Direccion</label>
                    <input name="direccion" type="text"><br>
                    <label for="">Localidad</label>
                     <select class="genero" name="localidad" id="localidad">
                        <option value="1">Pacheco</option>
                        <option value="2">Almagro</option>
                        <option value="3">Loma Verde</option>
                    </select>
                    <label for="">Provincia</label>
                     <select class="genero" name="provincia" id="provincia">
                        <option value="1">Argentino</option>
                        <option value="2">Brasilero</option>
                        <option value="3">Italiano</option>
                    </select>
                    <label for="">Correo electronico</label>
                    <input name="email" type="text"><br>
                    <label for="">Telefonos</label>
                    <input name="telefono" type="number"><br>
                    <input class="btnRegistro" type="submit" value="Registrarme">
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
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
    crossorigin="anonymous"></script>
    <script>
<% 
  if (request.getParameter("Status")!=null){%>
 	 	
 		swal("Cliente creado", "", "success")
 	 <%
  }%>
</script>
</html>