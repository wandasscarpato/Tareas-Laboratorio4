package negocioImplement;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import dao.prestamosDao;
import daoImplement.prestamosDaoImplement;
import entidad.n_prestamo;
import negocio.prestamosNegocio;

public class PrestamosNegocioImplement implements prestamosNegocio{
	
	prestamosDaoImplement cdao = new prestamosDaoImplement();
	
		public boolean insert(n_prestamo prestamo) {
		
		boolean estado=false;
		if(prestamo.getDNI()>0)
		{
			prestamo.setEstado(1);
			estado=cdao.insert(prestamo);
			estado = true;
			
		}
		return estado;
	}

	
	public boolean autorizar(int prestamoAutorizar) {
		//boolean estado=false;
			
			boolean estado=cdao.autorizar(prestamoAutorizar);
		
		//return estado;
		return estado;
}
	public boolean rechazar(int prestamoRechazar) {
		//boolean estado=false;
			
			boolean estado=cdao.rechazar(prestamoRechazar);
		
		//return estado;
		return estado;
}
	public ArrayList<n_prestamo> listarPrestamos(){
		return (ArrayList<n_prestamo>) cdao.listarPrestamos();
	}

	@Override
	public ArrayList<n_prestamo> listarPrestamosxDni(int dni) {
		return (ArrayList<n_prestamo>) cdao.listarPrestamosxDni(dni);
	}
	
	public List<n_prestamo> listarReporte_1(){
		return cdao.listarReporte_1();
	}
	
	public List<n_prestamo> Filter_reporte_1(String date_1,String date_2){
		return cdao.Filter_reporte_1(date_1, date_2);
	}
	
}
