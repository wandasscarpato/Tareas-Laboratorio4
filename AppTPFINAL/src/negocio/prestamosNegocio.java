package negocio;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import entidad.n_prestamo;

public interface prestamosNegocio {
	
	public ArrayList<n_prestamo> listarPrestamos();
	public ArrayList<n_prestamo> listarPrestamosxDni(int dni);
	public boolean autorizar(int prestamoAutorizado);
	public boolean rechazar(int prestamoRechazar);
	public boolean insert(n_prestamo prestamo);
	public List<n_prestamo> listarReporte_1();
	public List<n_prestamo> Filter_reporte_1(String date_1, String date_2);
	
}
