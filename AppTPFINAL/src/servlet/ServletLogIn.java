package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			Estado = udao.ValidarUsuario(request.getParameter("usuario").toString(),request.getParameter("pass").toString());
			System.out.print("Pass"+request.getParameter("pass").toString()+"Usuario"+request.getParameter("usuario").toString());
		}
		
		//REQUESTDISPATCHER
		request.setAttribute("CanFilas", Estado);
		RequestDispatcher rd = request.getRequestDispatcher("/InicioSesion.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
