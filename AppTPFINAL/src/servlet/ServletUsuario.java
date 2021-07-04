package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnModificar2")!= null) {
			int resultado=0;
		    usuario usu = new usuario();
		    usuarioNegocio usuNeg = new usuarioNegocioImplement();
			
		    usu.setUsuario(request.getSession().getAttribute("Session_usuario").toString());
			usu.setDNI(Integer.parseInt(request.getSession().getAttribute("Session_dni").toString()));
			
			if(request.getParameter("txtPass").toString().equals(request.getParameter("txtPassConfirm").toString())) {
				usu.setPass(request.getParameter("txtPass").toString());
				if(usuNeg.modificar(usu)) {
					if(usuNeg.listarUsuarios()!=null) {
						resultado= 1;
						request.setAttribute("resultado", resultado);	
						RequestDispatcher dispatcher = request.getRequestDispatcher("/ModDeUsuario.jsp");
						dispatcher.forward(request, response);
						
					}	
				}
			}
			else {
				request.setAttribute("resultado", resultado);	
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ModDeUsuario.jsp");
				dispatcher.forward(request, response);
			}
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnList")!= null)
			
		{	
			usuarioNegocio usuNeg = new usuarioNegocioImplement();
			if(usuNeg.listarUsuarios()!=null) {
				List<usuario> lista= usuNeg.listarUsuarios();
				request.setAttribute("listaU", lista);	
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ModxUsuario(Admin).jsp");
				dispatcher.forward(request, response);
			}
		}
		else if(request.getParameter("btnBuscar")!= null) {
			usuarioNegocio usuNeg = new usuarioNegocioImplement();
			
			int dni = Integer.parseInt(request.getParameter("txtDNI").toString()) ;
			
            List<usuario> lista= usuNeg.obtenerUno(dni);
			request.setAttribute("listaU", lista);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ModxUsuario(Admin).jsp");
			dispatcher.forward(request, response);
		}
		else if(request.getParameter("btnModificar")!= null) {
			HttpSession session = request.getSession();
			
			String usuario="";
			String dni="";
			
			if(request.getParameter("usuario")!=null && request.getParameter("dni")!=null)
			{
				usuario=request.getParameter("usuario");
				dni=request.getParameter("dni");
			}
			
			session.setAttribute("Session_dni", dni);
			session.setAttribute("Session_usuario", usuario);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ModDeUsuario.jsp"); 
			dispatcher.forward(request, response);
		}		
	}
}
