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

import entidad.cuenta;
import negocioImplement.cuentaNegocioImplement;





/**
 * Servlet implementation class ServletDesplegablePrestamo
 */
@WebServlet("/ServletDesplegablePrestamo")
public class ServletDesplegablePrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDesplegablePrestamo() {
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
		List<cuenta> listarCuentas = new ArrayList<cuenta>();
    	cuentaNegocioImplement cNeg = new cuentaNegocioImplement();
    	listarCuentas = cNeg.ObtenerxDni("3");
    	
    	String SelectCuenta = "";
    	
    	for(cuenta cuen: listarCuentas){
    		String tipo="";
    		if(cuen.getTipo()=="1") {
    			tipo="Caja de ahorro $";
    		}
    		if(cuen.getTipo()=="2") {
    			tipo="Caja de ahorro USD";
    		}
    		if(cuen.getTipo()=="3") {
    			tipo="Cta cte en pesos";
    		}
    		if(cuen.getTipo()=="4") {
    			tipo="Cta cte en USD";
    		}
    		SelectCuenta +="<option value="+'"'+ cuen.getN_Cuenta() +'"'+ ">" +tipo+" ,Nro "+ cuen.getCBU() +", saldo actual "+"</option>";
		}
    	request.setAttribute("SelectCuenta",SelectCuenta);

    	RequestDispatcher rd = request.getRequestDispatcher("solicitarPrestamo.jsp");
		rd.forward(request, response);
		
	}

}
