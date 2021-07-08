<%@page import="entidad.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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

    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/cssIvan.css" type=â€text/cssâ€>
    <link rel="stylesheet" href="./css/styleVistas.css"> 

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
                    Inicio
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <form method="post" action="ServletCliente">
                    <button class="dropdown-item" name="btnList">Mis datos</button>
                </form>
                    <a class="dropdown-item" href="ServletLogout">Cerrar sesion</a>
                  </div>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Transferencias
                  </a>
                  <form class="form-divModContra" method= "post" action="ServletCuenta">
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <button class="dropdown-item" name="btnTranferir_H">Tranferir</button>
                    <a class="dropdown-item" href="#">Historial</a>
                  </div>
                  </form>
                </li>
                <li class="nav-item dropdown">
                  <form method="post" action="ServletCuenta">
                        <button class="dropdown-item" name="btnListxDni">Mis cuentas</button>
                    </form>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                   
                  </div>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Prestamos
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="ServletSolicitarPrestamo">Solicitar prestamo</a> 
                  </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                      aria-haspopup="true" aria-expanded="false">
                      Menu de pagos
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <form method= "post" action="ServletListarPrestamos">
                    <button class="dropdown-item" name="btnListarPrestamos">Mis Prestamos</button>
                    </form>
                    </div>
                  </li>
              </ul>
              <div class="form-inline my-2 my-lg-0">
              <h6 style="font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif; font-size:2rem; color:red"class="usuarioLogueado">Usuario: <%= session.getAttribute("Usuario") %> <!--  DNI: <%= session.getAttribute("DNI") %> --></h6>
             </div>
            </div>
          </nav>
    </header>
    <div class="card--modif cm"></div>
    <!--Finaliza el header-->
    <br>
   <section class="sectionTiposDeCuenta">
        <div class="tiposDeCuentas tiposDeCuentas--modif">
			<div>
			<%
			List<cliente> lista = new ArrayList<cliente>();
			String loc="";
			String prov="";
			if (request.getAttribute("ListaCliente") != null && request.getAttribute("Localidad") != null) {
				lista = (List<cliente>) request.getAttribute("ListaCliente");
				loc= request.getAttribute("Localidad").toString();
				prov= request.getAttribute("Provincia").toString();
			for (cliente clie : lista) {
			%>
			<h2><%=clie.getApellido()%>, <%=clie.getNombre()%></h2>
			<table class="table" style="width:200">
			<tr>
				<td>DNI: </td>
				<td><%=clie.getDNI()%></td>
			</tr>
			<tr>
				<th>CUIL: </th>
				<th><%=clie.getCUIL()%></th>
			</tr>
			<tr>
				<th>SEXO: </th>
				<th><%=clie.getSexo()%></th>
			</tr>
			<tr>
				<th>NACIMIENTO: </th>
				<th><%=clie.getNacimiento()%></th>
			</tr>
			<tr>
				<th>DIRECCION: </th>
				<th><%=clie.getDireccion()%></th>
			</tr>
			<tr>
				<th>LOCALIDAD: </th>
				<th><%=loc%></th>
			</tr>
			<tr>
				<th>PROVINCIA: </th>
				<th><%=prov%></th>
			</tr>	
			<%
			}
			}
			%>
			</table>
			</div>
	  	</div>
     </section>
	
      <div class="card--modif cm2"></div>
      <div class="card--modif cm3"></div>
   
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
<%if(session.getAttribute("TipoLog")=="Usuario"){
} else {
    if(session.getAttribute("TipoLog")=="Administrador"){
        %><script>
        location.href = "Reportes.jsp";
        </script><%
    } else {
        %><script>
        location.href = "InicioSesion.jsp?NoLog=1&Redirect=PAGINAINTENTOENTRAR";
        </script><%
    }
}
%>


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