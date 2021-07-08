package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.n_prestamo;
import entidad.usuario;
import negocio.usuarioNegocio;
import negocio.prestamosNegocio;
import negocioImplement.PrestamosNegocioImplement;
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
		prestamosNegocio pNeg = new PrestamosNegocioImplement();
		
		System.out.println("ENTRO AL SERVLET");
		
		if(request.getParameter("admin")!=null) {
				
				usuarioNegocio udao = new usuarioNegocioImplement();
				String Usuario = request.getParameter("usuario").toString();
				String Pass = request.getParameter("pass").toString();
				Estado = udao.ValidarAdmin(Usuario,Pass);
				//System.out.println(Estado);
				if(Estado!=0 && pNeg.listarReporte_1() != null) {
					List<n_prestamo> lista = pNeg.listarReporte_1();

					request.setAttribute("Reporte1", lista);
					
					session.setAttribute("TipoLog", "Administrador");
					//response.sendRedirect("Reportes.jsp");
					RequestDispatcher rd = request.getRequestDispatcher("/Reportes.jsp");
					rd.forward(request, response);
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
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("ServletCliente?btnList");
			    dispatcher.forward((ServletRequest)request, (ServletResponse)response);
			}else {
				session.setAttribute("TipoLog", "");
				RequestDispatcher rd = request.getRequestDispatcher("/InicioSesion.jsp?error=1");
				rd.forward(request, response);
			}
				

		}
	}

}
