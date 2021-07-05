
package dao;

import java.util.ArrayList;

import entidad.n_prestamo;

public interface prestamosDao {
		public ArrayList<n_prestamo> listarPrestamos();
		public boolean autorizar(int prestamoAutorizado);
		
	}
	
