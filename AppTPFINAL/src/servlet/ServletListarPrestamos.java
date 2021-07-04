package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.n_prestamo;
import negocioImplement.PrestamosNegocioImplement;

/**
 * Servlet implementation class ServletListarPrestamos
 */
@WebServlet("/ServletListarPrestamos")
public class ServletListarPrestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarPrestamos() {
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
		// TODO Auto-generated method stub
			if(request.getParameter("btnMostrarPrestamos")!=null) {
			
			//clienteDaoImplement cDao = new clienteDaoImplement();
			//ArrayList<cliente> lista = cDao.listarClientes();
			PrestamosNegocioImplement cNeg = new PrestamosNegocioImplement();
			ArrayList<n_prestamo> lista = cNeg.listarPrestamos();
			request.setAttribute("listaP",lista);
			RequestDispatcher rd = request.getRequestDispatcher("/PrestamosAceptados.jsp");
			rd.forward(request, response);
			
		}	}

}