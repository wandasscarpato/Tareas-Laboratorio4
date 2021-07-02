package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.cuenta;
import negocio.cuentaNegocio;
import negocioImplement.cuentaNegocioImplement;

/**
 * Servlet implementation class ServletListarCuentas
 */
@WebServlet("/ServletListarCuentas")
public class ServletListarCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarCuentas() {
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
		System.out.println("-----------------ENTRO EN SERVLET-----------------");
		if(request.getParameter("btnBuscar") != null){
			cuentaNegocio cueNeg = new cuentaNegocioImplement();
			if(cueNeg.listarCuentas() != null) {
				List<cuenta> lista = cueNeg.listarCuentas();
				request.setAttribute("ListarCuentas", lista);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ABMLxCliente(Cuentas).jsp");
				dispatcher.forward(request, response);
			}
			else {
				System.out.println("-----------------FALLO LISTADO DE CUENTAS-----------------");
			}
		}
	}

}
