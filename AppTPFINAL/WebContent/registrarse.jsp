<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <link rel="stylesheet" href="./css/style.css">

    <title>Document</title>
</head>

<body>
    <header> <img src="" alt="">
        <img src="https://1.bp.blogspot.com/-Oxolc8k-Ub8/V-QmH4vkFGI/AAAAAAAABx8/TK7MzZsZ_TEqTaQxZGeh2qzFNtpOyGFQgCLcB/s1600/BAnk%2BOf%2Bamerica%2BLogo.jpg"
            alt="">
    </header>
    <div class="card--modif cm3"></div>
    <!--Finaliza el header-->
    <div class="registrarse">
        <form>
            <h2>   Registro de usuario
            </h2>
            <div class="form-div">
                <div>
                    <div class="card--modif"></div>
                    <label for="">Usuario</label> 
                    <input type="text" required> <br>
                    <label for="">Contraseña</label>
                    <input type="text" required><br>
                    <label for="">Nombre</label>
                    <input type="text" required><br>
                    <label for="">Apellido</label>
                    <input type="number" required><br>
                    <label for="">DNI</label>
                    <input type="number" required><br>
                    <label for="">CUIL</label>
                    <input type="text"><br>
                    <label for="">Sexo</label>
                    <select class="genero" name="" id="">
                        <option value="">Masculino</option>
                        <option value="">Femenino</option>
                        <option value="">Otro</option>
                    </select>
                    <label for="">Nacionalidad</label>
                    <input type="text"><br>
                    <label for="">Fecha de nacimiento</label>
                    <select class="fecha" name="" id="">
                        <option value="">1</option>
                        <option value="">2</option>
                        <option value="">3</option>
                    </select>
                    <select class="fecha" name="" id="">
                        <option value="">enero</option>
                        <option value="">febrero</option>
                        <option value="">marzo</option>
                    </select>
                    <select class="fecha" name="" id="">
                        <option value="">1999</option>
                        <option value="">2000</option>
                        <option value="">2001</option>
                    </select> <br>
                    <label for="">Direccion</label>
                    <input type="text"><br>
                    <label for="">Localidad</label>
                    <input type="text"><br>
                    <label for="">Provincia</label>
                    <input type="text"><br>
                    <label for="">Correo electronico</label>
                    <input type="text"><br>
                    <label for="">Telefonos</label>
                    <input type="text"><br>
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
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
    crossorigin="anonymous"></script>

</html>