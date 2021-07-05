package dao;

import java.util.List;

import entidad.cuenta;

public interface cuentaDao {
	
	public boolean insert(cuenta cuenta);
	public int verificar(cuenta cuenta);
	public boolean eliminar(cuenta cuenta_a_modificar);
	public boolean modificarEstado(cuenta cuenta_a_modificar);
	public boolean modificarTipo(cuenta cuenta_modificar);
	public List<cuenta> ObtenerxDni(String dni);
	public List<cuenta> readAll();

}
