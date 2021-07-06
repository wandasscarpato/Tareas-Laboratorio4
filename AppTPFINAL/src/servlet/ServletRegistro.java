package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImplement.ProvinciasDaoImplement;
import daoImplement.localidadesDaoImplement;
import entidad.localidad;
import entidad.provincia;

@WebServlet("/ServletRegistro")
public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletRegistro() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<provincia> listaProvincias = new ArrayList<provincia>();
    	ProvinciasDaoImplement pDao = new ProvinciasDaoImplement();
    	listaProvincias = pDao.listarProvincias();
    	
    	String SelectProv = "";
    	String SelectLoc = "";
    	
    	for(provincia prov: listaProvincias){
    		SelectProv +="<option value="+'"'+ prov.getID() +'"'+ ">" + prov.getProvincia() + "</option>";
		}
    	
    	ArrayList<localidad> listalocalidades = new ArrayList<localidad>();
    	localidadesDaoImplement lDao = new localidadesDaoImplement();
    	listalocalidades = lDao.listarLocalidades();
    	
    	for(localidad local: listalocalidades){
    		SelectLoc += "<option value="+'"'+local.getID()+'"'+">"+local.getLocalidad()+"</option>";
    	}
    	
    	request.setAttribute("SelectProv",SelectProv);
    	request.setAttribute("SelectLoc",SelectLoc);
		RequestDispatcher rd = request.getRequestDispatcher("registrarse.jsp");
		rd.forward(request, response);
	}

}
