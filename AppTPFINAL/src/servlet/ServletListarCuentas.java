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
		//LISTA TODO
		if(request.getParameter("btnList") != null) 
		{
			cuentaNegocio cueNeg = new cuentaNegocioImplement();
			if(cueNeg.listarCuentas()!=null) {
				List<cuenta> lista= cueNeg.listarCuentas();
				request.setAttribute("ListarCuentas", lista);	
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ABMLxCliente(Cuentas).jsp");
				dispatcher.forward(request, response);
			}
		}	
		//CUANDO SE BUSCA UN DNI
		else if(request.getParameter("btnBuscar") != null)
			{
				cuentaNegocio cueNeg = new cuentaNegocioImplement();
				String dni = request.getParameter("txtDni");
				if(dni != "") {
					if(cueNeg.ObtenerxDni(dni) != null) {
						List<cuenta> lista = cueNeg.ObtenerxDni(dni);
						request.setAttribute("ListarCuentas", lista);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/ABMLxCliente(Cuentas).jsp");
						dispatcher.forward(request, response);
						}
					else {
						//MOSTRAR ALERTA DE QUE NO ENCONTRO A NADIE
					}
				}
				else {
					List<cuenta> lista = cueNeg.listarCuentas();
					request.setAttribute("ListarCuentas", lista);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/ABMLxCliente(Cuentas).jsp");
					dispatcher.forward(request, response);
				}
				
			}
			//CUANDO SE DA DE BAJA UNA CUENTA
		else if(request.getParameter("btnBaja") != null)
			{
				cuentaNegocio cueNeg = new cuentaNegocioImplement();
				int N_cuenta = Integer.parseInt(request.getParameter("N_Cuenta").toString());
				String dni = request.getParameter("N_DNI").toString();
				cuenta c = new cuenta();
				
				c.setN_Cuenta(N_cuenta);
				c.setEstado(false);
				cueNeg.modificar(c);
				//LLAMO A LA LISTA
				List<cuenta> lista = cueNeg.listarCuentas();
				request.setAttribute("ListarCuentas", lista);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ABMLxCliente(Cuentas).jsp");
				dispatcher.forward(request, response);
				
			}
			//CUANDO NO ENCUENTRA NADA
			else {
				//PENSANDO EN PONER UNA ALERTA
				
			}
		
	}

}
