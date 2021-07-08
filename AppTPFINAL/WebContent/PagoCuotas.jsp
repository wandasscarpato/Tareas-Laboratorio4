<%@page import="com.sun.org.apache.bcel.internal.generic.Select"%>
<%@page import="entidad.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
                    Inicio
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="PerfilCliente.jsp">Mi cuenta</a>
                    <a class="dropdown-item" href="ServletLogout">Cerrar sesion</a>
                  </div>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Transferencias
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="transferencias.jsp">Transferir</a>
                  </div>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Cuentas
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="misCuentas.jsp">Mis cuentas</a>
                    <a class="dropdown-item" href="#">Solicitar cuentas</a>
                   
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
		      <p></p>
		      <form action="ServletListarPrestamos" method="post">
	<div>
		
			<table id="tablaClientes" class="tablaClientes display" border="1">
			<thead>
				<tr>
					<th>Nro Prestamo</th>
					<th>Importe Solicitado</th>
					<th>Intereses</th>
					<th>Monto por mes</th>
					<th>Cuotas</th>
					<th>Nro de cuenta a Depositar</th>
					<th>Cuota a pagar</th>
					<th>Cuenta a pagar</th>
					<th>PAGAR</th>
				</tr>
			<thead>
			<tbody>


				<%
					List <n_prestamo> listaPrestamos = new ArrayList <n_prestamo>();
					if(request.getAttribute("listaPresDni")!=null){
					
					listaPrestamos = (List<n_prestamo>)request.getAttribute("listaPresDni");
					
					for (n_prestamo presta : listaPrestamos) {
				%>
				
					<%if(presta.isEstado() == 1){ %>
					<tr>
					<td><%=presta.getN_Prestamo()%></td>
					<td><%=presta.getImporte_pedido()%></td>
					<td><%=presta.getImporte_intereses()%></td>
					<td><%=presta.getMontoxMes()%></td>
					<td><%=presta.getCuotas()%></td>
					<td><%=presta.getN_cuentaADepositar()%></td>
					<td><input name="cuotasAPagar" type="text" required style="width: ; height: 020"></td>
					<td><select name="ddlCuentas">
					
					<%
					List<cuenta> listacuentas = new ArrayList<cuenta>();
					if(request.getAttribute("listaCuentaDni") != null)
					{
					
					System.out.print("HOLA BROTHER");
					
					listacuentas = (List<cuenta>) request.getAttribute("listaCuentaDni");
					for(cuenta cue: listacuentas)
					{
					%>
					
					<option value ="<%=cue.getN_Cuenta() %>">Tipo de cuenta: <%= cue.getTipo()%> CBU: <%=cue.getCBU()%> DISPONIBLE $<%=cue.getSaldo() %></option>
					
					<%
					}
					
					}
					
					%>
					 
			
					
					</select></td>
					<td><a href= "servletListarPrestamos?action=pagarCuotas&Ncuenta=<%=request.getParameter("ddlCuentas")%>&cuotas=<%=presta.getCuotas() %>"> PAGAR</a></td>
					
					</tr>
					<%}%>
					
				
				<%
				}
					}
					System.out.print("LA CUENTA SELEC ES: "+request.getParameter("ddlCuentas") +" LAS CUOTAS SON");
				%>
			</tbody>
		</table>
		
     </div>
     </form>
     <p></p>
    
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
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
  integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>


</html>