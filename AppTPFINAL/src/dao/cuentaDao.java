package dao;

import java.util.List;

import entidad.cuenta;

public interface cuentaDao {
	
	public boolean insert(cuenta cuenta);
	//public boolean delete(int cuenta_a_eliminar);
	public boolean modificar(cuenta cuenta_a_modificar);
	public List<cuenta> ObtenerxDni(String dni);
	public List<cuenta> readAll();

}
