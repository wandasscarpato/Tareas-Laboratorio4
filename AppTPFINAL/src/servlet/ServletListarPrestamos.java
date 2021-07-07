package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.cuenta;
import entidad.n_prestamo;
import negocio.cuentaNegocio;
import negocio.prestamosNegocio;
import negocioImplement.PrestamosNegocioImplement;
import negocioImplement.cuentaNegocioImplement;


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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btnListarPrestamos")!=null) {
			
			prestamosNegocio pNeg = new PrestamosNegocioImplement();
			
			//String dniUsuario = "Dali";
			//request.getSession().setAttribute("dniusu", dniUsuario);
			
			ArrayList<n_prestamo> listaPresDni = pNeg.listarPrestamosxDni(123);
			request.setAttribute("listaPresDni", listaPresDni);
			
			cuentaNegocio cNeg = new cuentaNegocioImplement();
			
			
			System.out.print("LLEGA AL SERVLET ALMENOS BRO");
			
			ArrayList<cuenta> listaCuentaDni = (ArrayList<cuenta>) cNeg.ObtenerxDni("123");
			request.setAttribute("listaCuentaDni", listaCuentaDni);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/PagoCuotas.jsp");
			rd.forward(request, response);
			
			/*//clienteDaoImplement cDao = new clienteDaoImplement();
			//ArrayList<cliente> lista = cDao.listarClientes();
			PrestamosNegocioImplement cNeg = new PrestamosNegocioImplement();
			ArrayList<n_prestamo> lista = cNeg.listarPrestamos();
			request.setAttribute("listaP",lista);
			RequestDispatcher rd = request.getRequestDispatcher("/PrestamosAceptados.jsp");
			rd.forward(request, response);
			
		}	
			if(request.getParameter("btnAutorizar")!=null) {
				int id = Integer.parseInt(request.getParameter("idPrestamo").toString());
				PrestamosNegocioImplement cNeg = new PrestamosNegocioImplement();
				cNeg.autorizar(id);
				
				ArrayList<n_prestamo> lista = cNeg.listarPrestamos();
				request.setAttribute("listaP",lista);
				
				RequestDispatcher rd = request.getRequestDispatcher("/AutorizacionPrestamos.jsp");
				rd.forward(request, response);
			} */
	}

}
}
