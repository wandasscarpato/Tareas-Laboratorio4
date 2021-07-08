package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.cuenta;
import negocio.cuentaNegocio;
import negocioImplement.cuentaNegocioImplement;

/**
 * Servlet implementation class AltaCuentaServlet
 */
@WebServlet("/AltaCuentaServlet")
public class AltaCuentaServlet extends HttpServlet {
	HttpSession session;
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
		
		session = request.getSession(true);
		int numRandom = (int) (Math.random()*1000);
		String prueba= "";
		int filas=0;
		if(request.getParameter("btnCrear")!=null)
		{
			
			//Date fecha = new Date();
			//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			//request.setAttribute("fechanueva", formatter.format(fecha));
			
			cuenta c = new cuenta();
			
			//c.setN_Cuenta(1);
			//System.out.print("N CUENTA");
			
			
			//c.setDNI(Integer.parseInt(session.getAttribute("DNI").toString()));
			c.setDNI(3);
			System.out.print("DNI");
			c.setCBU(numRandom);
			System.out.print("CBU ");
			//c.setCBU(request.getParameter("txtCBU"));
			c.setSaldo(10000);
			System.out.print("SALDO ");
			
			//c.setSaldo(request.getParameter("txtSaldo"));
			//c.setSaldo(request.getParameter("txtSaldo"));
			//c.setTipo(request.getParameter("tipo"));
			prueba = request.getParameter("tipo");
			System.out.println("Valor prueba = "+prueba);
			c.setTipo(request.getParameter("tipo").toString());
			//System.out.print("tipo" + c.getTipo());
			
			//c.setFecha_cracion(request.getParameter("txtFecha"));
			//c.setFecha_cracion(fecha_cracion);
			c.setEstado(0);
			
			//System.out.print("DUDOSO  PERO NO TAN DUDOSO ENTRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			cuentaNegocio cneg = new cuentaNegocioImplement();
			
			if(cneg.verificar(c)==true) 
			{
				
				
				if(cneg.insert(c)==true)
				{
					filas=1;
					//System.out.print("SI ENTRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
					//request.setAttribute("cantFilas", filas);
					//RequestDispatcher rd = request.getRequestDispatcher("AltaCuentaServlet?Status=true");
					//rd.forward(request, response);
				}
				else{ 
				{
					//request.setAttribute("cantFilas", filas);
					//RequestDispatcher rd = request.getRequestDispatcher("AltaCuentaServlet?Status=false");
					//rd.forward(request, response);
					System.out.print("NO ENTRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
				}
				}
				
			}
			else 
			{
				
				//request.setAttribute("cantFilas", filas);
				//RequestDispatcher rd = request.getRequestDispatcher("AltaCuentaServlet?Status=max");
				//rd.forward(request, response);
				//System.out.print("NO SE PUEDE CREAR CUENTA + 3");
			}
			
			
			
		}
		
		request.setAttribute("cantFilas", filas);
		RequestDispatcher rd = request.getRequestDispatcher("NuevaCuenta(ADMIN).jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		session = request.getSession(true);
		int numRandom = (int) (Math.random()*1000);
		String prueba= "";
		int filas=0;
		if(request.getParameter("btnCrear")!=null)
		{
			
			//Date fecha = new Date();
			//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			//request.setAttribute("fechanueva", formatter.format(fecha));
			
			cuenta c = new cuenta();
			
			//c.setN_Cuenta(1);
			//System.out.print("N CUENTA");
			
			
			//c.setDNI(Integer.parseInt(session.getAttribute("DNI").toString()));
			c.setDNI(Integer.parseInt(session.getAttribute("DNI").toString()));
			System.out.print("DNI");
			c.setCBU(numRandom);
			System.out.print("CBU ");
			//c.setCBU(request.getParameter("txtCBU"));
			c.setSaldo(10000);
			System.out.print("SALDO ");
			
			//c.setSaldo(request.getParameter("txtSaldo"));
			//c.setSaldo(request.getParameter("txtSaldo"));
			//c.setTipo(request.getParameter("tipo"));
			prueba = request.getParameter("tipo");
			System.out.println("Valor prueba = "+prueba);
			c.setTipo(request.getParameter("tipo").toString());
			//System.out.print("tipo" + c.getTipo());
			
			//c.setFecha_cracion(request.getParameter("txtFecha"));
			//c.setFecha_cracion(fecha_cracion);
			c.setEstado(0);
			
			//System.out.print("DUDOSO  PERO NO TAN DUDOSO ENTRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			cuentaNegocio cneg = new cuentaNegocioImplement();
			
			if(cneg.verificar(c)==true) 
			{
				
				
				if(cneg.insert(c)==true)
				{
					filas=1;
					//System.out.print("SI ENTRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
					//request.setAttribute("cantFilas", filas);
					//RequestDispatcher rd = request.getRequestDispatcher("AltaCuentaServlet?Status=true");
					//rd.forward(request, response);
				}
				else{ 
				{
					//request.setAttribute("cantFilas", filas);
					//RequestDispatcher rd = request.getRequestDispatcher("AltaCuentaServlet?Status=false");
					//rd.forward(request, response);
					System.out.print("NO ENTRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
				}
				}
				
			}
			else 
			{
				
				//request.setAttribute("cantFilas", filas);
				//RequestDispatcher rd = request.getRequestDispatcher("AltaCuentaServlet?Status=max");
				//rd.forward(request, response);
				//System.out.print("NO SE PUEDE CREAR CUENTA + 3");
			}
			
			
			
		}
		
		request.setAttribute("cantFilas", filas);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
		
	}

}
