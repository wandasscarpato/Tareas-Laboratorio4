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
<title>Insert title here</title>
</head>
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
					<form method= "post" action="ServletUsuario">
					<button class="dropdown-item" name="btnList">Cambio de contraseñas</button>
					</form>
			</li>
		</ul>
		<form class="form-inline my-2 my-lg-0"></form>
	</div>
	</nav> </header>
    <div class="card--modif cm"></div>
      <!--Finaliza el header-->
<body>
<div class="adminCuentas">
        <h1><%if(session.getAttribute("Session_dni")!= null && session.getAttribute("Session_cuenta")!= null){ %>
        	Modificar cuenta N° 
        	<%=session.getAttribute("Session_cuenta").toString()%>
        	del cliente DNI N ° 
        	<%=session.getAttribute("Session_dni").toString()%>
        	<%}%>
        </h1>
      </div>

      <form class="form-divModContra" method= "get" action="ServletCuenta">
                <div align= "left">
                	<%	if(request.getAttribute("resultado") !=null){
      						int resultado= Integer.parseInt(request.getAttribute("resultado").toString());
							if(resultado==1)
      						{
     				 %>
								*Cuenta activada con exito.
								<p></p>      
      				<%
     						}
      
     					}
                	if(session.getAttribute("Session_estado")!= null){

                		if(session.getAttribute("Session_estado").toString().equals("false")){%>
	                		La cuenta se encuentra desactivada, para activarla haga click aquí: 
	                		<input class="btnBuscar" type="submit" name= "btnActivar" value="Activar" style="width: 143px;"><br>
                		<%
                		if(request.getAttribute("resultado") !=null){
                			System.out.println(session.getAttribute("resultado"));
	                		if(session.getAttribute("resultado").equals("modificado")){%>
	                			*La cuenta se activó exitosamente.
                		<% }
                		}
                		}
                		else if(session.getAttribute("Session_estado").toString().equals("true")){%>
	                		<p></p>
	                		<div>
	                		Seleccione el nuevo tipo de cuenta:
	                		<select class="genero" name="tipo" id="tipo" style="width: 180px; ">
	                        <option value="1">Cuenta Corriente AR$</option>
	                        <option value="2">Caja de Ahorro AR$</option>
	                        <option value="3">Cuenta Corriente USD$</option>
	                        <option value="4">Caja de Ahorro USD$</option>
	                   		</select>
	                   		</div>
	                   		<p></p>
	                   		<div>
	                		<input class="btnBuscar" type="submit" name="btnModificar2" value="Modificar" style="width: 143px;">
	                		<input class="btnBuscar" type="submit" name="btnCancelar" value="Cancelar" style="width: 143px;"><br> 
	                		</div>	
                		<%}
                		}
                		%>
                </div>
        </form>
        		<form method= "post" action="ServletCuenta">
                		<div align="left">
                		<%	if(request.getAttribute("resultado2") !=null){
      						int resultado= Integer.parseInt(request.getAttribute("resultado2").toString());
							if(resultado==1)
      						{
     					 %>
								*Tipo de cuenta modificada con exito. <button class="btnBuscar" name="btnList" style="width: 286px; ">Volver a "Administrar Cuentas"</button> 
      					<%
     						}
      
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