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

import daoImplement.clienteDaoImplement;
import daoImplement.usuarioDaoImplement;
import entidad.cliente;
import entidad.usuario;

/**
 * Servlet implementation class ServletListar
 */
@WebServlet("/ServletListar")
public class ServletListar extends HttpServlet {
	HttpSession session;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btnMostrarClientes")!=null) {
			
			clienteDaoImplement cDao = new clienteDaoImplement();
			ArrayList<cliente> lista = cDao.listarClientes();
			request.setAttribute("listaU",lista);
			RequestDispatcher rd = request.getRequestDispatcher("/BMLxCuenta(Cuentas).jsp");
			rd.forward(request, response);
			
		}
	}

}
