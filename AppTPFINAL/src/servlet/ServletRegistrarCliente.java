package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daoImplement.clienteDaoImplement;
import daoImplement.usuarioDaoImplement;
import entidad.cliente;
import entidad.usuario;

import javax.servlet.http.HttpSession;


@WebServlet("/ServletRegistrarCliente")
public class ServletRegistrarCliente extends HttpServlet {
	HttpSession session;
	private static final long serialVersionUID = 1L;
       

    public ServletRegistrarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		clienteDaoImplement clienteDao = new clienteDaoImplement();
		cliente cli = new cliente();
		
		cli.setDNI(Integer.parseInt(request.getParameter("DNI")));
        cli.setCUIL(Integer.parseInt(request.getParameter("CUIL")));
        cli.setID_Localodad(Integer.parseInt(request.getParameter("localidad")));
        cli.setID_Provincia(Integer.parseInt(request.getParameter("provincia")));
        cli.setTelefono(Integer.parseInt(request.getParameter("telefono")));
        cli.setApellido(request.getParameter("apellido"));
        cli.setNombre(request.getParameter("nombre"));
        cli.setEmail(request.getParameter("email"));
        cli.setDireccion(request.getParameter("direccion"));
        cli.setNacimiento(request.getParameter("nacimiento"));
        cli.setSexo(request.getParameter("genero"));
        cli.setApellido(request.getParameter("apellido"));
		
        usuarioDaoImplement usuDao = new usuarioDaoImplement();
        usuario usu = new usuario();
        
        usu.setDNI(Integer.parseInt(request.getParameter("DNI")));
        usu.setUsuario(request.getParameter("usuario"));
        usu.setPass(request.getParameter("pass1"));
        
		if(clienteDao.insert(cli) && usuDao.insert(usu)) {
			//me redirije
			response.sendRedirect("ServletRegistro?Status=true");
		} else {
			//me redirije
			response.sendRedirect("ServletRegistro?Status=false");
		}
	}

}
