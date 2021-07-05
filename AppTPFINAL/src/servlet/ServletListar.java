package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.cliente;
import negocio.clienteNegocio;
import negocioImplement.clienteNegocioImplement;


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
		int dnibaja;
		boolean estado;
		if(request.getParameter("action").equals("cambiarEstado"))
			{
				dnibaja =Integer.parseInt(request.getParameter("dni"));
				estado = Boolean.parseBoolean(request.getParameter("estado"));
				clienteNegocio cneg = new clienteNegocioImplement();
				cneg.delete(dnibaja,estado);
			}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/BMLxCliente(Admin).jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btnMostrarClientes")!=null) {
			
			//clienteDaoImplement cDao = new clienteDaoImplement();
			//ArrayList<cliente> lista = cDao.listarClientes();
			clienteNegocioImplement cNeg=new clienteNegocioImplement();
			ArrayList<cliente> lista = cNeg.listarClientes();
			request.setAttribute("listaU",lista);
			RequestDispatcher rd = request.getRequestDispatcher("/BMLxCuenta(Cuentas).jsp");
			rd.forward(request, response);
			
		}
	}

}
