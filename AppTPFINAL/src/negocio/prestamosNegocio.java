package negocio;

import java.util.ArrayList;

import entidad.n_prestamo;

public interface prestamosNegocio {
	
	public ArrayList<n_prestamo> listarPrestamos();
	public ArrayList<n_prestamo> listarPrestamosxDni(int dni);
	public boolean autorizar(int prestamoAutorizado);
}
