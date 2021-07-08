package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocioImplement.PrestamosNegocioImplement;

@WebServlet("/ServletRechazarPrestamo")
public class ServletRechazarPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletRechazarPrestamo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btnRechazar")!=null) {
			int id = Integer.parseInt(request.getParameter("idPrestamo").toString());
			PrestamosNegocioImplement cNeg = new PrestamosNegocioImplement();
			
			if(cNeg.rechazar(id)) {
			
			response.sendRedirect("ServletAutorizarPrestamos?StatusS=true");
			}else {
				response.sendRedirect("ServletAutorizarPrestamos?StatusS=false");
			}
		}
	}

}
