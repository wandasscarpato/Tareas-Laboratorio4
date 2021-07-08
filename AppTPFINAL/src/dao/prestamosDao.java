
package dao;

import java.util.ArrayList;
import java.util.List;
import entidad.n_prestamo;

public interface prestamosDao {
		public ArrayList<n_prestamo> listarPrestamos();
		public ArrayList<n_prestamo> listarPrestamosxDni(int dni);
		public boolean autorizar(int prestamoAutorizado);
		public boolean insert(n_prestamo prestamo);
		public boolean rechazar(int prestamoRechazar);
		public List<n_prestamo> listarReporte_1();
		public List<n_prestamo> Filter_reporte_1(String date_1, String date_2);
		
	}
	
