package negocioImplement;

import java.util.ArrayList;

import dao.prestamosDao;
import daoImplement.prestamosDaoImplement;
import entidad.n_prestamo;

public class PrestamosNegocioImplement {
	
	prestamosDao cdao = new prestamosDao();
	
	public ArrayList<n_prestamo> listarPrestamos(){
		return (ArrayList<n_prestamo>) cdao.listarPrestamos();
	}
	
}
