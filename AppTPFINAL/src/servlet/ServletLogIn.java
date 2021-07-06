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
	HttpSession session;
	private static final long serialVersionUID = 1L;
       
    public ServletLogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int Estado = 0;
		int DNI = 0;
		session = request.getSession(true);

		if(request.getParameter("admin")!=null) {
				
				usuarioNegocio udao = new usuarioNegocioImplement();
				String Usuario = request.getParameter("usuario").toString();
				String Pass = request.getParameter("pass").toString();
				Estado = udao.ValidarAdmin(Usuario,Pass);
				if(Estado!=0) {
					session.setAttribute("TipoLog", "Administrador");
					response.sendRedirect("Reportes.jsp");
				} else {
					session.setAttribute("TipoLog", "");
					RequestDispatcher rd = request.getRequestDispatcher("/InicioSesion.jsp?error=1");
					rd.forward(request, response);
				
				}
			
		} else {
		
			usuarioNegocio udao = new usuarioNegocioImplement();
			String Usuario = request.getParameter("usuario").toString();
			String Pass = request.getParameter("pass").toString();
			Estado = udao.ValidarUsuario(Usuario,Pass);
			if(Estado!=0) {
				DNI = udao.buscarDNIUsuario(Usuario);
				session.setAttribute("TipoLog", "Usuario");
				session.setAttribute("DNI", DNI);
				session.setAttribute("Usuario", Usuario);
				response.sendRedirect("PerfilCliente.jsp");
			}else {
				session.setAttribute("TipoLog", "");
				RequestDispatcher rd = request.getRequestDispatcher("/InicioSesion.jsp?error=1");
				rd.forward(request, response);
			}
				

		}
	}

}
