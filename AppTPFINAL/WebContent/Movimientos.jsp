<%@page import="entidad.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
    <link rel="stylesheet" href="./css/jquery.dataTables.min.css">

    <title>Document</title>
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
                    <a class="dropdown-item" href="misCuentas.jsp">Mis cuentas</a>
                    <a class="dropdown-item" href="nuevaCuenta.jsp">Solicitar cuenta</a>
                   
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
      
      <section>
      <div class="adminCuentas">
        <h1><%if(session.getAttribute("Session_cuenta")!= null){ %>
        	Movimientos de la cuenta N?:
        	<%=session.getAttribute("Session_cuenta").toString()%>
        	<%}%>
        </h1>
      </div>
      <table id="tablaMovimientos" class="tablaClientes display" border="1">	
			<tr>
				<th>ID</th>
				<th>Fecha</th>
				<th>Detalle</th>
				<th>Importe</th>
				<th>Tipo</th>
			</tr>
			<%
			List<movimientos> lista = new ArrayList<movimientos>();
			List<String> listaTipo = new ArrayList<String>();
			if (request.getAttribute("listaM") != null && request.getAttribute("tipo") != null) {
				lista = (List<movimientos>) request.getAttribute("listaM");
				listaTipo = (List<String>) request.getAttribute("tipo");
			}
			int i=0;
			
			if(lista!=null)
			for (movimientos mov : lista) {
			%>
			<tr>
			<form class="form-divModContra" method= "post" action="ServletMovimientos">
				<td><%=mov.getID_Movimiento()%></td>
				<td><%=mov.getFecha()%></td>
				<td><%=mov.getDetalle()%></td>
				<td><%=mov.getImporte()%></td>
				<td><%=listaTipo.get(i)%></td>
			</form>
			</tr>
			<%
			i++;
			}
			%>
			</table>
			<p></p>
			<form method= "post" action="ServletCuenta">
			<div style="text-align: center;">
				<button class="btnBuscar" name="btnListxDni" style="width: 286px; ">Volver a "Mis Cuentas"</button>
			</div>
			</form>
		</section>
      <!--Comienza el footer-->
    <footer>
        <div>
            <span>Navegacion</span>
            <ul>
                <li>
                    ?Quienes somos?
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
                    R?gimen de transparencia
                </li>
                <li>
                    Usuario Bancario
                </li>
                <li>
                    C?digo de Conducta
                </li>
                <li>
                    Estados contables
                </li>
                <li>
                    T?rminos y condiciones
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
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="./js/jquery.dataTables.min.js"></script>
<script>
	$(document).ready(function() {
		$('#tablaMovimientos').DataTable();
	});
</script>
</html>