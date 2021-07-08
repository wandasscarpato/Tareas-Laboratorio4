<%@page import="entidad.cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="negocioImplement.cuentaNegocioImplement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <script src="https://kit.fontawesome.com/dd0dcbd0c6.js" crossorigin="anonymous"></script>
  <link href="https://fonts.googleapis.com/css2?family=Dela+Gothic+One&display=swap" rel="stylesheet">  <!--bootstrap-->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
    integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
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
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Cuentas
                  </a>
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
                    <a class="dropdown-item" href="PagoCuotas.jsp">Mis pagos</a>
                    </div>
                  </li>
              </ul>
              <div class="form-inline my-2 my-lg-0">
              <h6 style="font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif; font-size:2rem; color:red"class="usuarioLogueado">Usuario: <%= session.getAttribute("Usuario") %> <!--  DNI: <%= session.getAttribute("DNI") %> --></h6>
             </div>
            </div>
          </nav>
    </header>
      <!--Finaliza el header-->
      <section class="transacciones">
        <h1>Transferir</h1>
        <div class="card--modif cm2"></div>
        <div>
          <form method="post" action="ServletCuenta" class="formulario-transaccion">
            <!-- Empieza el DROP DOWN -->
            <label for="">Seleccione la cuenta desde la cual transferir</label>
            <select name = "ddlCuentas" >
            	<option>---</option>
              <%
        			List<cuenta> listacuentas = new ArrayList<cuenta>();
              		if(request.getAttribute("ListarC_Tranfe") != null){
            		listacuentas = (List<cuenta>) request.getAttribute("ListarC_Tranfe");
            			for(cuenta cue: listacuentas){%>
            			<option value ="<%=cue.getN_Cuenta() %>">Tipo de cuenta: <%= cue.getTipo()%> CBU: <%=cue.getCBU()%> DISPONIBLE $<%=cue.getSaldo() %></option>
            			<%}
            		}%>
            </select>
            <!-- Termina el DROP DOWN -->
            <br>
            <label>Ingrese el CBU del destinatario</label>            <br>
			<!-- DEFINIR EL MAXIMO Y MINIMO DEL CBU -->
            <input type="number" name="txtCBU_T">
            <br>
            <label>Ingrese monto que desea transferir</label>            <br>
            <div class="card--modif cm1"></div>
            <input type="number" name="txtMonto_T">
            <br>
            <input type="reset" class="btnCancelar" value="CANCELAR">
            <input type="submit" class="btnTransferir" id="btnTrans" name="btnTrans" value="TRANSFERIR">
            </form>
        </div>
        <div class="card--modif cm"></div>
      </section>
     <!--Empieza footer-->
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
<script>
var e = document.getElementById("ddlCuentas");
var strUser = e.value;
</script>

</html>