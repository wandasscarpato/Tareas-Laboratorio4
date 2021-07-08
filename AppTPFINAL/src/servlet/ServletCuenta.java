package servlet;

import java.awt.Window;
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
import javax.swing.JOptionPane;

import com.sun.java.swing.plaf.windows.resources.windows;

import dao.cuentaDao;
import daoImplement.cuentaDaoImplement;
import entidad.AceptarCuenta;
import entidad.cuenta;
import entidad.movimientos;
import entidad.usuario;
import negocio.cuentaNegocio;
import negocio.movimientosNegocio;
import negocio.usuarioNegocio;
import negocioImplement.cuentaNegocioImplement;
import negocioImplement.movimientosNegocioImplement;
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
				}
			}
		else if(request.getParameter("btnModificar2")!= null) {
				cuenta cue = new cuenta();
			    cuentaNegocio cueNeg = new cuentaNegocioImplement();
				
			    cue.setN_Cuenta(Integer.parseInt(request.getSession().getAttribute("Session_cuenta").toString()));
				cue.setDNI(Integer.parseInt(request.getSession().getAttribute("Session_dni").toString()));
				cue.setTipo(request.getParameter("tipo"));
				
					if(cueNeg.modificarTipo(cue)) {
							resultado= 1;
							request.setAttribute("resultado2", resultado);
							RequestDispatcher dispatcher = request.getRequestDispatcher("/ModDeCuenta.jsp");
							dispatcher.forward(request, response);
							System.out.println("MODIFICA2");
					}	
					else {
						//No se modifico
					}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void listarcuentas_btnList(HttpServletRequest request, HttpServletResponse response,String page) throws ServletException, IOException {
		cuentaNegocio cueNeg = new cuentaNegocioImplement();
		if(cueNeg.listarCuentas()!=null) {
			List<cuenta> lista= cueNeg.listarCuentas();
			request.setAttribute("ListarCuentas", lista);	
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		}
	}
	
	private void listarcuentas_btnTranferir_H(HttpServletRequest request, HttpServletResponse response,String page) throws ServletException, IOException {

		cuentaNegocio cueNeg = new cuentaNegocioImplement();
		System.out.println("DNI DEL USUARIO LOGEADO: " + request.getSession().getAttribute("DNI").toString());
		if(cueNeg.ObtenerxDni(request.getSession().getAttribute("DNI").toString())!=null) {
			List<cuenta> lista= cueNeg.ObtenerxDni(request.getSession().getAttribute("DNI").toString());
			request.setAttribute("ListarC_Tranfe", lista);	
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//LISTA TODO
				if(request.getParameter("btnList") != null) 
				{
					listarcuentas_btnList(request, response,"/ABMLxCliente(Cuentas).jsp");
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
								//
								//MOSTRAR ALERTA DE QUE NO SE ESCRIBIO NADA EN EL TXTBOX
								//
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
						c.setEstado(0);
						
						if(cueNeg.eliminar(c)) {
							//LLAMO A LA LISTA COMPLETA SI SE MODIFICO
							List<cuenta> lista = cueNeg.listarCuentas();
							request.setAttribute("ListarCuentas", lista);
							RequestDispatcher dispatcher = request.getRequestDispatcher("/ABMLxCliente(Cuentas).jsp");
							dispatcher.forward(request, response);
						}
						else { //SI NO SE MODIFICA
							//
							//MOSTRAR ALERTA DE QUE NO SE PUEDE DAR DE BAJA 2 VECES A LA MISMA CUENTA
							//
						}
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
				else if(request.getParameter("btnTranferir_H") != null) 
				{
					//TESTO LA VARIABLE SESSION
					listarcuentas_btnTranferir_H(request, response, "/transferencias.jsp");
					
				}
				else if(request.getParameter("btnTrans") != null ){
					cuentaNegocio cueNeg = new cuentaNegocioImplement();
					cuenta c_debito = new cuenta();
					cuenta c_credito = new cuenta();
					//PARA MODIFICAR MI NUEVO SALDO
					c_debito.setN_Cuenta(Integer.parseInt( request.getParameter("ddlCuentas")));
					int cbu_enviar=0;
					Double monto_ing=0.0,monto_t=0.0,monto_credito=0.0;
					
					//MOVIMIENTOS
					movimientosNegocio movNeg = new movimientosNegocioImplement();
					movimientos m_debito = new movimientos();
					movimientos m_credito = new movimientos();
					//VERIFICA QUE SE OBTENGA EL SALDO
					if(cueNeg.ObtenerSaldo(c_debito) != 0) {
						monto_ing = Double.parseDouble(request.getParameter("txtMonto_T"));
						//VERIFICA QUE EL SALDO INGRESADO SEA MENOR AL QUE TIENE EN EL CUENTA
						if( monto_ing <= cueNeg.ObtenerSaldo(c_debito) ){
							cbu_enviar =Integer.parseInt((String) request.getParameter("txtCBU_T"));
							monto_ing = Double.parseDouble(request.getParameter("txtMonto_T"));
							monto_t= (Double) (cueNeg.ObtenerSaldo(c_debito)-monto_ing);
							
							//DEBITO SALDO DEL USUARIO
							c_debito.setSaldo(monto_t);
							cueNeg.modificarSaldo(c_debito);
							//ACREDITO SALDO DEL USUARIO 
							c_credito.setCBU(cbu_enviar);
							monto_credito = (Double) (cueNeg.ObtenerSaldo(c_credito)+monto_ing);
							c_credito.setSaldo(monto_credito);
							cueNeg.modificarSaldo(c_credito);
							
							//GENERA LOS MOVIMIENTOS DEBITO
							m_debito.setImporte(monto_t.floatValue());
							m_debito.setID_Movimiento(4);
							m_debito.setDetalle("Debito");
							m_debito.setN_Cuenta(Integer.parseInt( request.getParameter("ddlCuentas")));
							movNeg.InsertMovimientos(m_debito);
							//GENERA LOS MOVIMIENTOS CREDITO
							m_credito.setImporte(monto_ing.floatValue());
							m_credito.setID_Movimiento(4);
							m_credito.setDetalle("Credito");
							m_credito.setN_Cuenta(cueNeg.ObtenerN_Cuenta(c_credito));
							movNeg.InsertMovimientos(m_credito);
						}
						else {
							//MONTO MAYOR INGRESADO AL SALDO DISPONIBLE
						}
					}
					//MUESTRO DATOS EN EL DROPDOWNLIST
					listarcuentas_btnTranferir_H(request, response, "/transferencias.jsp");

				}
				else if (request.getParameter("btnVerMovimientos") != null) {
				      HttpSession session = request.getSession();
				      String n_cuenta = request.getParameter("ncuenta").toString();
				      session.setAttribute("Session_cuenta", n_cuenta);
				      session.setAttribute("Session_cuenta", Integer.valueOf(n_cuenta));
				      RequestDispatcher dispatcher = request.getRequestDispatcher("ServletMovimientos?btnList");
				      dispatcher.forward((ServletRequest)request, (ServletResponse)response);
				    }
				else if (request.getParameter("btnListxDni") != null) {
				      cuentaNegocioImplement cuentaNegocioImplement = new cuentaNegocioImplement();
				      if (request.getSession().getAttribute("DNI") != null) {
				        String dni = request.getSession().getAttribute("DNI").toString();
				        if (cuentaNegocioImplement.ObtenerxDni(dni) != null) {
				          List<cuenta> lista = cuentaNegocioImplement.ObtenerxDni(dni);
				          request.setAttribute("ListaC", lista);
				          RequestDispatcher dispatcher = request.getRequestDispatcher("/misCuentas.jsp");
				          dispatcher.forward((ServletRequest)request, (ServletResponse)response);
				        } 
				      } 
				    } 
				
				if(request.getParameter("btnCargar")!=null) {
					cuentaNegocio cNeg = new cuentaNegocioImplement();
					ArrayList<AceptarCuenta> ListarAceptarCuenta = cNeg.listarAceptarCuentas();
					
					request.setAttribute("ListarC", ListarAceptarCuenta);
					
					RequestDispatcher rd = request.getRequestDispatcher("/AceptarCuentas(Admin).jsp");
					rd.forward(request, response);
				 }
				
				if(request.getParameter("btnRechazar")!=null) {
					int N_Cuenta = Integer.parseInt(request.getParameter("N_Cuenta"));
					cuentaDao cDao = new cuentaDaoImplement();
					cDao.ModificarEstadoCuenta(N_Cuenta, false);
					ArrayList<AceptarCuenta> ListarAceptarCuenta = cDao.ListarAceptarCuenta();
					
					request.setAttribute("ListarC", ListarAceptarCuenta);
					
					RequestDispatcher rd = request.getRequestDispatcher("/AceptarCuentas(Admin).jsp");
					rd.forward(request, response);
				}
				
				if(request.getParameter("btnAceptar")!=null) {
					int N_Cuenta = Integer.parseInt(request.getParameter("N_Cuenta"));
					cuentaDao cDao = new cuentaDaoImplement();
					cDao.ModificarEstadoCuenta(N_Cuenta, true);
					ArrayList<AceptarCuenta> ListarAceptarCuenta = cDao.ListarAceptarCuenta();
					
					request.setAttribute("ListarC", ListarAceptarCuenta);
					
					RequestDispatcher rd = request.getRequestDispatcher("/AceptarCuentas(Admin).jsp");
					rd.forward(request, response);
				}			
				if(request.getParameter("btnCargar")!=null) {
					cuentaNegocio cNeg = new cuentaNegocioImplement();
					ArrayList<AceptarCuenta> ListarAceptarCuenta = cNeg.listarAceptarCuentas();
					
					request.setAttribute("ListarC", ListarAceptarCuenta);
					
					RequestDispatcher rd = request.getRequestDispatcher("/AceptarCuentas(Admin).jsp");
					rd.forward(request, response);
				 }
				
	}
}