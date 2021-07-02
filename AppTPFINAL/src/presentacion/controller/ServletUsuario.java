package presentacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ModDeUsuario(Admin).jsp");
			dispatcher.forward(request, response);
		}
	}
}
