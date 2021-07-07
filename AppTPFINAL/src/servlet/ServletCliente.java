package servlet;

import entidad.cliente;
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
import javax.servlet.http.HttpSession;

import negocioImplement.clienteNegocioImplement;
import negocioImplement.localidadesNegocioImplement;
import negocioImplement.provinciasNegocioImplement;

@WebServlet({"/ServletCliente"})
public class ServletCliente extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
	  HttpSession session = request.getSession();
	  
	  if (request.getParameter("btnList") != null) {
	      cliente clie = new cliente();
	      clie.setDNI(Integer.parseInt(session.getAttribute("DNI").toString()));
	      
	      clienteNegocioImplement clienteNegocioImplement = new clienteNegocioImplement();
	      localidadesNegocioImplement localidadesNegocioImplement = new localidadesNegocioImplement();
	      provinciasNegocioImplement provinciasNegocioImplement = new provinciasNegocioImplement();
	      
	      String localidad = "";
	      String provincia = "";
	      
	      if (clienteNegocioImplement.listarClienteLogueado(clie.getDNI()) != null) {
		      
	    	  List<cliente> lista = clienteNegocioImplement.listarClienteLogueado(clie.getDNI());
		      
		      for (cliente clien : lista) {
		        localidad = localidadesNegocioImplement.buscarNombreLocalidad(clien.getID_Localodad());
		        provincia = provinciasNegocioImplement.buscarNombreprovincia(clien.getID_Provincia());
		      } 
		      
		      request.setAttribute("ListaCliente", lista);
		      request.setAttribute("Localidad", localidad);
		      request.setAttribute("Provincia", provincia);
		      
		      RequestDispatcher dispatcher = request.getRequestDispatcher("/PerfilCliente.jsp");
		      dispatcher.forward((ServletRequest)request, (ServletResponse)response);
	      } 
    } 
  }
}