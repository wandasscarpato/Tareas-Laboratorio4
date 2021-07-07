package servlet;

import entidad.cuenta;
import entidad.movimientos;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocioImplement.movimientosNegocioImplement;

@WebServlet({"/ServletMovimientos"})
public class ServletMovimientos extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (request.getParameter("btnList") != null) {
      cuenta cue = new cuenta();
      cue.setN_Cuenta(Integer.parseInt(request.getSession().getAttribute("Session_cuenta").toString()));
      movimientosNegocioImplement movimientosNegocioImplement = new movimientosNegocioImplement();
      if (movimientosNegocioImplement.ObtenerxN_Cuenta(cue.getN_Cuenta()) != null) {
        List<movimientos> lista = movimientosNegocioImplement.ObtenerxN_Cuenta(cue.getN_Cuenta());
        request.setAttribute("listaM", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Movimientos.jsp");
        dispatcher.forward((ServletRequest)request, (ServletResponse)response);
      } 
    } 
  }
}
