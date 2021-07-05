package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImplement.clienteDaoImplement;
import daoImplement.usuarioDaoImplement;
import entidad.cliente;
import entidad.usuario;
import negocio.clienteNegocio;
import negocioImplement.clienteNegocioImplement;

/**
 * Servlet implementation class ServletBMLxCli
 */
@WebServlet("/ServletBMLxCli")
public class ServletBMLxCli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletBMLxCli() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int dnibaja;
		boolean estado;
		
		try {
		if(request.getParameter("action").equals("cambiarEstado"))
			{
				dnibaja =Integer.parseInt(request.getParameter("dni"));
				estado = Boolean.parseBoolean(request.getParameter("estado"));
				clienteNegocio cneg = new clienteNegocioImplement();
				cneg.delete(dnibaja,estado);
			}
		}
		catch(Exception e) {}
		
		ArrayList<cliente> listacliente = new ArrayList<cliente>();
		clienteDaoImplement cDao = new clienteDaoImplement();
		ArrayList<cliente> lista = cDao.listarClientes();
		listacliente = lista;
		String cuerpoTabla = "";
		
		for(cliente cli: listacliente) {
			ArrayList<String> listaProYLoc = cDao.BuscarProYLocClientes(cli.getID_Localodad(),cli.getID_Provincia());
			
			usuarioDaoImplement uDao = new usuarioDaoImplement();
			ArrayList<usuario> listausuarios = (ArrayList<usuario>)uDao.obtenerUno(cli.getDNI());
			
			for(usuario usu: listausuarios){
				cuerpoTabla+="<tr>";
				cuerpoTabla+="<td>"+usu.getUsuario()+"</td>";
				cuerpoTabla+="<td>"+usu.getPass()+"</td>";
			}
			cuerpoTabla+="<td>"+cli.getDNI()+"</td>";
			cuerpoTabla+="<td>"+cli.getCUIL()+"</td>";
			cuerpoTabla+="<td>"+cli.getNombre()+"</td>";				
			cuerpoTabla+="<td>"+cli.getApellido()+"</td>";
			cuerpoTabla+="<td>"+cli.getNacimiento()+"</td>";
			cuerpoTabla+="<td>"+cli.getSexo()+"</td>";
			cuerpoTabla+="<td>"+cli.getDireccion()+"</td>";
			cuerpoTabla+="<td>"+listaProYLoc.get(0)+"</td>";
			cuerpoTabla+="<td>"+listaProYLoc.get(1)+"</td>";
			cuerpoTabla+="<td>"+cli.getTelefono()+"</td>";
			cuerpoTabla+="<td>"+cli.getEstado()+"</td>";
			cuerpoTabla+="<td><a href="+'"'+"ServletBMLxCli?action=cambiarEstado&dni="+cli.getDNI()+"&estado="+cli.getEstado()+'"'+">cambiar estado</td></tr>";
		}
		
		request.setAttribute("tabla",cuerpoTabla);
		RequestDispatcher rd = request.getRequestDispatcher("BMLxCliente(Admin).jsp");
		rd.forward(request, response);
		
	}


}
