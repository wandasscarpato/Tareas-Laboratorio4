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

import entidad.cuenta;
import entidad.n_prestamo;
import negocioImplement.PrestamosNegocioImplement;
import negocioImplement.clienteNegocioImplement;
import negocioImplement.cuentaNegocioImplement;

/**
 * Servlet implementation class ServletSolicitarPrestamo
 */
@WebServlet("/ServletSolicitarPrestamo")
public class ServletSolicitarPrestamo extends HttpServlet {
	HttpSession session;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSolicitarPrestamo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session = request.getSession(true);
		
		List<cuenta> listarCuentas = new ArrayList<cuenta>();
    	cuentaNegocioImplement cNeg = new cuentaNegocioImplement();
    	listarCuentas = cNeg.ObtenerxDni(session.getAttribute("DNI").toString());
    	
    	String SelectCuenta = "";
    	
    	if(!(listarCuentas.isEmpty())) {
    		
	    	for(cuenta cuen: listarCuentas){
	    		String tipo="";
	    		if(Integer.parseInt(cuen.getTipo())==1) {
	    			tipo="Caja de ahorro $";
	    		}
	    		if(Integer.parseInt(cuen.getTipo())==2) {
	    			tipo="Caja de ahorro USD";
	    		}
	    		if(Integer.parseInt(cuen.getTipo())==3) {
	    			tipo="Cta cte en pesos";
	    		}
	    		if(Integer.parseInt(cuen.getTipo())==4) {
	    			tipo="Cta cte en USD";
	    		}
	    		SelectCuenta +="<option value="+'"'+ cuen.getN_Cuenta() +'"'+ ">" + tipo +" ,CBU "+ cuen.getCBU() +", saldo actual "+cuen.getSaldo()+"</option>";
			}
    	}else{
    		SelectCuenta = null;
    	}
    	
    	request.setAttribute("SelectCuenta",SelectCuenta);
    	
    	//System.out.println(SelectCuenta);

    	RequestDispatcher rd = request.getRequestDispatcher("solicitarPrestamo.jsp");
    	rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*INVIO DE FORMULARIO CON LOS DATOS*/
		PrestamosNegocioImplement prestamoNeg = new PrestamosNegocioImplement();
		n_prestamo pres = new n_prestamo();
		//guardo el monto solicitado
		float inicial=Float.parseFloat(request.getParameter("monto"));
		//guardo la cantidad de cuotas
		int cuo=(Integer.parseInt(request.getParameter("cuotas")));
		//
		float interes= 5 / 4 ;
		float montoint = (inicial*interes);
		float montoFinal= montoint+inicial;
		
		float mensual= montoFinal/12;
		
		
		pres.setMontoxMes(mensual);
		pres.setImporte_intereses(montoint);
		pres.setDNI(Integer.parseInt(request.getParameter("dni")));
		pres.setImporte_pedido(inicial);
		pres.setCuotas(Integer.parseInt(request.getParameter("cuotas")));
		pres.setN_cuentaADepositar(Integer.parseInt(request.getParameter("cuentas")));
		if(prestamoNeg.insert(pres)) {
			//me redirije
			response.sendRedirect("ServletSolicitarPrestamo?Status=true");
		} else {
			//me redirije
			response.sendRedirect("ServletSolicitarPrestamo?Status=false");
		}
	}

}
