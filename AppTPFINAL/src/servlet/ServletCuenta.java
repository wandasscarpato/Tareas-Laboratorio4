package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.cuenta;
import entidad.usuario;
import negocio.cuentaNegocio;
import negocio.usuarioNegocio;
import negocioImplement.cuentaNegocioImplement;
import negocioImplement.usuarioNegocioImplement;

/**
 * Servlet implementation class ServletCuenta
 */
@WebServlet("/ServletCuenta")
public class ServletCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int resultado=0;
		if(request.getParameter("btnActivar")!= null) {
		    cuenta cue = new cuenta();
		    cuentaNegocio cueNeg = new cuentaNegocioImplement();
			
		    cue.setN_Cuenta(Integer.parseInt(request.getSession().getAttribute("Session_cuenta").toString()));
			cue.setDNI(Integer.parseInt(request.getSession().getAttribute("Session_dni").toString()));
			
				if(cueNeg.modificarEstado(cue)) {
						HttpSession session = request.getSession();
						String estado="true";
						resultado= 1;
						session.setAttribute("Session_estado", estado);
						request.setAttribute("resultado", resultado);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/ModDeCuenta.jsp");
						dispatcher.forward(request, response);
						System.out.println("MODIFICA2");
				}	
				else {
					System.out.println("NO SE MODIFICO UN CHOTO");
				}
			}
		else if(request.getParameter("btnModificar2")!= null) {
				cuenta cue = new cuenta();
			    cuentaNegocio cueNeg = new cuentaNegocioImplement();
				
			    cue.setN_Cuenta(Integer.parseInt(request.getSession().getAttribute("Session_cuenta").toString()));
				cue.setDNI(Integer.parseInt(request.getSession().getAttribute("Session_dni").toString()));
				cue.setTipo(Integer.parseInt(request.getParameter("tipo")));
				
					if(cueNeg.modificarTipo(cue)) {
							resultado= 1;
							request.setAttribute("resultado2", resultado);
							RequestDispatcher dispatcher = request.getRequestDispatcher("/ModDeCuenta.jsp");
							dispatcher.forward(request, response);
							System.out.println("MODIFICA2");
					}	
					else {
						System.out.println("NO SE MODIFICO UN CHOTO");
					}
		}
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
						cueNeg.eliminar(c);
						//LLAMO A LA LISTA
						List<cuenta> lista = cueNeg.listarCuentas();
						request.setAttribute("ListarCuentas", lista);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/ABMLxCliente(Cuentas).jsp");
						dispatcher.forward(request, response);
						
					}				
				
		//Al presionarse btnModificar, se crean las Session correspondientes y nos dirije a ModDeCuenta.jsp
				else if(request.getParameter("btnModificar")!= null) {
				HttpSession session = request.getSession();
				
				String cuenta="";
				String dni="";
				String estado="";
				
				if(request.getParameter("N_Cuenta")!=null && request.getParameter("N_DNI")!=null)
				{
					cuenta=request.getParameter("N_Cuenta");
					dni=request.getParameter("N_DNI");
					estado=request.getParameter("ESTADO");
				}
				
				session.setAttribute("Session_dni", dni);
				session.setAttribute("Session_cuenta", cuenta);
				session.setAttribute("Session_estado", estado);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ModDeCuenta.jsp"); 
				dispatcher.forward(request, response);
				}
				//CUANDO NO ENCUENTRA NADA
				else {
					//PENSANDO EN PONER UNA ALERTA
					
				}
	}
}
