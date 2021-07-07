package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.n_prestamo;
import negocioImplement.PrestamosNegocioImplement;

/**
 * Servlet implementation class ServletSolicitarPrestamo
 */
@WebServlet("/ServletSolicitarPrestamo")
public class ServletSolicitarPrestamo extends HttpServlet {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrestamosNegocioImplement prestamoNeg = new PrestamosNegocioImplement();
		n_prestamo pres = new n_prestamo();
		//guardo el monto solicitado
		float inicial=(Integer.parseInt(request.getParameter("monto")));
		//guardo la cantidad de cuotas
		int cuo=(Integer.parseInt(request.getParameter("cuotas")));
		//
		float interes= 5 / 4 ;
		float montoint = (inicial*interes);
		float montoFinal= montoint+inicial;
		
		float mensual= montoFinal/12;
		
		int plazo=cuo/12;
		
		pres.setMontoxMes(mensual);
		pres.setPlazo(plazo);
		pres.setImporte_intereses(montoint);
		pres.setDNI(Integer.parseInt(request.getParameter("dni")));
		pres.setImporte_pedido(inicial);
		pres.setCuotas(Integer.parseInt(request.getParameter("cuotas")));
		pres.setN_cuentaADepositar(Integer.parseInt(request.getParameter("cuentas")));
		if(prestamoNeg.insert(pres)) {
			//me redirije
System.out.println("PASO!!!!!!!");
			response.sendRedirect("solicitarPrestamo.jsp?Status=true");
		} else {
			//me redirije
			response.sendRedirect("solicitarPrestamo.jsp?Status=false");
		}
	}

}
