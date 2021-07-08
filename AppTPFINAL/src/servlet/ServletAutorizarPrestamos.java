package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImplement.prestamosDaoImplement;
import entidad.movimientos;
import entidad.n_prestamo;
import negocioImplement.PrestamosNegocioImplement;
import negocioImplement.movimientosNegocioImplement;

@WebServlet("/ServletAutorizarPrestamos")
public class ServletAutorizarPrestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletAutorizarPrestamos() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		prestamosDaoImplement pDao = new prestamosDaoImplement();
		ArrayList<n_prestamo> listaPrestamos = (ArrayList<n_prestamo>) pDao.listarPrestamos();
		
		String tabla = "";

		for (n_prestamo presta : listaPrestamos) {
			if(presta.isEstado() == 0){
			
				tabla +="<tr><form method=" + '"' + "post" + '"' + " action=" + '"' + "ServletAutorizarPrestamos" + '"' + "onsubmit=" + '"' + "return validar()" + '"' + ">";
				tabla +="<td>" + presta.getN_Prestamo() + "<input name="+'"'+"idPrestamo" + '"' + "value=" +'"' + presta.getN_Prestamo() + '"' + " type=" + '"' + "hidden" + '"' + "></td>";
				tabla +="<td>" + presta.getDNI() + "</td>";
				tabla +="<td>" + presta.getImporte_pedido() + "<input name="+'"'+"pedido" + '"' + "value=" +'"' + presta.getImporte_pedido() + '"' + " type=" + '"' + "hidden" + '"' + "></td>";
				tabla +="<td>" + presta.getImporte_intereses() + "<input name="+'"'+"interes" + '"' + "value=" +'"' + presta.getImporte_intereses() + '"' + " type=" + '"' + "hidden" + '"' + "></td>";
				tabla +="<td>" + presta.getMontoxMes() + "</td>";
				tabla +="<td>" + presta.getCuotas() + "</td>";
				tabla +="<td>" + presta.getN_cuentaADepositar()+ "<input name="+'"'+"nroCuenta" + '"' + "value=" +'"' + presta.getN_cuentaADepositar() + '"' + " type=" + '"' + "hidden" + '"' + "></td>";
				tabla +="<td><input class='btnEnviarAutorizacionP'"+ "name=" + '"' + "btnAutorizar" + '"' + "type=" + '"' + "submit" + '"' + "value=" + '"' + "Autorizar" + '"' + "></td></form>";
				tabla +="<form method='post' action='ServletRechazarPrestamo' onsubmit='return validarRechazo()'><input name='idPrestamo' value= '"+ presta.getN_Prestamo() + "' type='hidden'><td><input class='btnEnviarAutorizacionP' name='btnRechazar'type='submit' value='Rechazar'></td></form></tr>";

			}
		}
		
		request.setAttribute("tabla",tabla);
		RequestDispatcher rd = request.getRequestDispatcher("AutorizacionPrestamos.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if(request.getParameter("btnAutorizar")!=null) {
			int id = Integer.parseInt(request.getParameter("idPrestamo").toString());
			float interes = Float.parseFloat(request.getParameter("interes").toString());
			float pedido = Float.parseFloat(request.getParameter("pedido").toString());
			float importeFinal=pedido+interes;
			PrestamosNegocioImplement cNeg = new PrestamosNegocioImplement();
			movimientosNegocioImplement mNeg = new movimientosNegocioImplement();
			
			movimientos mov = new movimientos();
			
			mov.setN_Cuenta(Integer.parseInt(request.getParameter("nroCuenta")));
			mov.setImporte(importeFinal);
			mov.setDetalle("Se autorizo el prestamo solicitado");
			
			mNeg.insertAltaPrestamo(mov);
			cNeg.autorizar(id);
			
			doGet(request, response);
		} 
	}


}
