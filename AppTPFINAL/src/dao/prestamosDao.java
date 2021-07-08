
package dao;

import java.util.ArrayList;

import entidad.n_prestamo;

public interface prestamosDao {
		public ArrayList<n_prestamo> listarPrestamos();
		public ArrayList<n_prestamo> listarPrestamosxDni(int dni);
		public boolean autorizar(int prestamoAutorizado);
		public boolean insert(n_prestamo prestamo);
		public boolean rechazar(int prestamoRechazar);

	}
	
