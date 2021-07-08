package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ServletPrestamosAceptados
 */
@WebServlet("/ServletPrestamosAceptados")
public class ServletPrestamosAceptados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrestamosAceptados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrestamosNegocioImplement pNeg = new PrestamosNegocioImplement();
		ArrayList<n_prestamo> listaPrestamos = (ArrayList<n_prestamo>) pNeg.listarPrestamos();
		String tabla = "";
		
		for (n_prestamo presta : listaPrestamos) {
			
				if(presta.isEstado() == 1){ 
				tabla+="<tr>";
				tabla+="<td>"+presta.getN_Prestamo()+"</td>";
				tabla+="<td>"+presta.getDNI()+"</td>";
				tabla+="<td>"+presta.getImporte_pedido()+"</td>";
				tabla+="<td>"+presta.getImporte_intereses()+"</td>";
				tabla+="<td>"+presta.getMontoxMes()+"</td>";
				tabla+="<td>"+presta.getCuotas()+"</td>";
				tabla+="<td>"+presta.getN_cuentaADepositar()+"</td>";
				tabla+="</tr>";
				}
		}
		request.setAttribute("tabla",tabla);
		RequestDispatcher rd = request.getRequestDispatcher("PrestamosAceptados.jsp");
		rd.forward(request, response);	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnFechas") != null) 
		{
			String date_1 = request.getParameter("primeraFecha");
			System.out.println("LA PRIMERA FECHA ES: "+request.getParameter("primeraFecha"));
			String date_2 = request.getParameter("segundaFecha");
			System.out.println("LA SEGUNDA FECHA ES: "+request.getParameter("segundaFecha"));
			
			prestamosNegocio pNeg = new PrestamosNegocioImplement();
			
				if(pNeg.Filter_reporte_1(date_1, date_2) != null) {
					List<n_prestamo> lista= pNeg.Filter_reporte_1(date_1, date_2);
					request.setAttribute("Reporte1", lista);	
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Reportes.jsp");
					dispatcher.forward(request, response);
				}
			
		}
	}

}
