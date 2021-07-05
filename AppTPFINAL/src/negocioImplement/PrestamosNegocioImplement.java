package negocioImplement;

import java.util.ArrayList;
import java.util.List;

import dao.prestamosDao;
import daoImplement.prestamosDaoImplement;
import entidad.n_prestamo;
import negocio.prestamosNegocio;

public class PrestamosNegocioImplement implements prestamosNegocio{
	
	prestamosDaoImplement cdao = new prestamosDaoImplement();
	
	public boolean autorizar(int prestamoAutorizar) {
		//boolean estado=false;
			
			boolean estado=cdao.autorizar(prestamoAutorizar);
		
		//return estado;
		return estado;
}
		
	public ArrayList<n_prestamo> listarPrestamos(){
		return (ArrayList<n_prestamo>) cdao.listarPrestamos();
	}
}
