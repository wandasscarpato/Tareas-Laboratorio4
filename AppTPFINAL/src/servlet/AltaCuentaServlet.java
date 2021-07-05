package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.cuenta;
import negocio.cuentaNegocio;
import negocioImplement.cuentaNegocioImplement;

/**
 * Servlet implementation class AltaCuentaServlet
 */
@WebServlet("/AltaCuentaServlet")
public class AltaCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AltaCuentaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prueba= "";
		int filas=0;
		if(request.getParameter("btnCrear")!=null)
		{
			System.out.print("DUDOSO ENTRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			
			Date fecha = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			request.setAttribute("fechanueva", formatter.format(fecha));
			
			cuenta c = new cuenta();
			
			//c.setN_Cuenta(1);
			//System.out.print("N CUENTA");
			
			c.setDNI(Integer.parseInt(request.getParameter("txtDNI")));
			System.out.print("DNI");
			c.setCBU(Integer.parseInt(request.getParameter("txtCBU")));
			System.out.print("CBU ");
			//c.setCBU(request.getParameter("txtCBU"));
			c.setSaldo(Double.parseDouble (request.getParameter("txtSaldo")));
			System.out.print("SALDO ");
			
			//c.setSaldo(request.getParameter("txtSaldo"));
			//c.setSaldo(request.getParameter("txtSaldo"));
			//c.setTipo(request.getParameter("tipo"));
			prueba = request.getParameter("tipo");
			System.out.println("Valor prueba = "+prueba);
			c.setTipo(request.getParameter("tipo").toString());
			System.out.print("tipo" + c.getTipo());
			
			//c.setFecha_cracion(request.getParameter("txtFecha"));
			//c.setFecha_cracion(fecha_cracion);
			c.setEstado(true);
			
			System.out.print("DUDOSO  PERO NO TAN DUDOSO ENTRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			cuentaNegocio cneg = new cuentaNegocioImplement();
			
			if(cneg.verificar(c)==true) 
			{
				
				
				if(cneg.insert(c)==true)
				{
					filas=1;
					System.out.print("SI ENTRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
				}
				else{ 
				{
					System.out.print("NO ENTRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
				}
				}
				
			}
			else 
			{
				System.out.print("NO SE PUEDE CREAR CUENTA + 3");
			}
			
			
			
		}
		
		request.setAttribute("cantFilas", filas);
		RequestDispatcher rd = request.getRequestDispatcher("/nuevaCuenta(ADMIN).jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
