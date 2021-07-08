<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
    integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/dd0dcbd0c6.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/cssIvan.css">
    <link rel="stylesheet" href="./css/styleVistas.css"> 
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
					<a class="dropdown-item" href="./ServletCuenta">Asignar cuentas</a>
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
      <div class="adminCuentas">
        <h1><%if(session.getAttribute("Session_usuario")!= null){ %>
        	Cambio de contraseña al usuario
        	<%=session.getAttribute("Session_usuario").toString()%>
        	<%}%>
        </h1>
      </div>
      <form method="get" action="ServletUsuario">
      	<div class="izda">
       		<p></p>
       			<label  for="">Ingrese el nuevo password:</label> 
       			<input type="password" name="txtPass" id="pass1" maxlength="20" required>
       		</div>
       		<p></p>
       	<div class="izda">
       			<label for="">Confirme el nuevo password: </label> 
       			<input type="password" name="txtPassConfirm" id="pass2" maxlength="20" required>
     	</div>
     		<p></p>
     	<div class="izda">
       			<input class="btnBuscar" type="submit" name= "btnModificar2" value="Modificar" style="width: 143px; "><br>
     	</div>
      </form>
      <p></p>
      <form method= "get" action="ServletUsuario">
                		<div align="left">
                		<%	if(request.getAttribute("resultado") !=null){
      						int resultado= Integer.parseInt(request.getAttribute("resultado").toString());
							if(resultado==1)
      						{
     					 %>
								*Cambio de contraseña realizado con exito. <button class="btnBuscar" name="btnList" style="width: 286px; ">Volver a "Administrar Cuentas"</button> 
      					<%
     						}
     						else{%>
      							*Las contraseñas no coinciden, intente nuevamente por favor.
     					  <%}
     						}
     						%>
                 		</div>
                 </form>
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
                 
</body>
</html>