package negocio;

import java.util.List;

import entidad.cuenta;

public interface cuentaNegocio {

	public boolean insert(cuenta cuenta);
	public List<cuenta> listarCuentas();
	public List<cuenta> ObtenerxDni(String dni);
	public boolean modificar (cuenta usu);
}
