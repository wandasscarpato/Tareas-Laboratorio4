<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./css/style.css">
  <!--fuentes-->
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <script src="https://kit.fontawesome.com/dd0dcbd0c6.js" crossorigin="anonymous"></script>
  <link href="https://fonts.googleapis.com/css2?family=Dela+Gothic+One&display=swap" rel="stylesheet">  <!--bootstrap-->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
    integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
  <title>Document</title>
</head>

<body>
  <header>
    <img
      src="https://1.bp.blogspot.com/-Oxolc8k-Ub8/V-QmH4vkFGI/AAAAAAAABx8/TK7MzZsZ_TEqTaQxZGeh2qzFNtpOyGFQgCLcB/s1600/BAnk%2BOf%2Bamerica%2BLogo.jpg"
      alt="">
    <div class="ingresar">
    <a href="./registrarse.jsp">Registrarme</a>
    <a href="./InicioSesion.jsp">Iniciar sesion</a>
    </div>
  </header>
  <div class="index">
    <div class="index-izquierda">
      <section>
      <h2>
        No somos solo un banco
      </h2>
      <h3>
        Somos mucho más. 
        <br>
        Descubrinos
      </h3>
      <input type="button" value="Registrarse"> 
      <br>
      <a href="InicioSesion.jsp">ya tengo cuenta</a>
    </section>
    </div>
    <div class="index-derecha">
      <img
        src="https://media.discordapp.net/attachments/748613515152982047/854455749019172934/PicsArt_06-15-05.21.02.jpg"
        alt="">
    </div>
  </div>
  <section class="container-tarjetas">
    <div class="card" style="width: 18rem;">
      <div class="tarjetas">
        <i class="far fa-smile-beam tarjetas-icono"></i>
      </div>
      <div class="card-body">
        <h5 class="card-title">Sin sorpresas</h5>
        <p class="card-text">Somos transparentes, no hay letra chica.</p>
      </div>
    </div>
    <div class="card" style="width: 18rem;">
      <div class="tarjetas">
        <i class="fas fa-university tarjetas-icono"></i>
      </div>
      <div class="card-body">
        <h5 class="card-title">Aprobado</h5>
        <p class="card-text">Estamos autorizados y regulados por el Banco Central.</p>
      </div>
    </div>
    <div class="card" style="width: 18rem;">
      <div class="tarjetas">
        <i class="fas fa-dollar-sign tarjetas-icono"></i>
      </div>
      <div class="card-body">
        <h5 class="card-title">Sin costos</h5>
        <p class="card-text">Todas tus operaciones diarias están incluidas.</p>
      </div>
    </div>
  </section>
  <section class="chamuyo">
    <div class="chamuyo-izquierda">
      <p>Registrate</p>
      <h4>Y comenza a disfrutar</h4>
      <p>Hace tus transferencias mas rapido</p>
      <i class="fas fa-edit chamuyo-izquierda-editar"></i>
      <h4>Hace las cosas a tu manera</h4>
    </div>
    <div class="chamuyo-derecha">
      <ul>
        <li>
          <i class="fas fa-plane-departure chamuyo-iconos"></i> 
          <span>Viaja</span>
        </li>
        <li>
          <i class="fab fa-shopify chamuyo-iconos"></i> 
          <span>Compra</span>
          
        </li>
        <li>
          <i class="fas fa-motorcycle chamuyo-iconos"></i> 
          <span>Pedi</span>
        </li>
        <li>
          <i class="fas fa-skiing-nordic chamuyo-iconos"></i> 
          <span>Disfruta</span>
        </li>
      </ul>
      <div class="card--modif"></div>
    </div>
  </section>
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