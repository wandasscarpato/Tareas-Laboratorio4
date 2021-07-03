package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.usuario;
import negocio.usuarioNegocio;
import negocioImplement.usuarioNegocioImplement;

/**
 * Servlet implementation class ServletLogIn
 */
@WebServlet("/ServletLogIn")
public class ServletLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Estado = 0;
		if(request.getParameter("btnAceptar")!=null){
			usuarioNegocio udao = new usuarioNegocioImplement();
			String Usuario = request.getParameter("usuario").toString();
			String Pass = request.getParameter("pass").toString();
			Estado = udao.ValidarUsuario(Usuario,Pass);
			
		}
		
		if(Estado != 0) {
			String Usuario = request.getParameter("usuario").toString();
			String Pass = request.getParameter("pass").toString();
			usuario usu = new usuario(Usuario, Pass);
			HttpSession Sesion = request.getSession();
			Sesion.setAttribute("usuario", usu);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else
		{
			//REQUESTDISPATCHER
			request.setAttribute("CanFilas", Estado);
			RequestDispatcher rd = request.getRequestDispatcher("/InicioSesion.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
