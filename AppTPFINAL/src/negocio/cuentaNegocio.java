package negocio;

import java.util.ArrayList;
import java.util.List;

import entidad.AceptarCuenta;
import entidad.cuenta;

public interface cuentaNegocio {

	public boolean insert(cuenta cuenta);
	public boolean verificar(cuenta cuenta);
	public List<cuenta> listarCuentas();
	public List<cuenta> ObtenerxDni(String dni);
	public boolean eliminar (cuenta usu);
	public boolean modificarEstado (cuenta usu);
	public boolean modificarTipo (cuenta usu);
	public boolean modificarSaldo(cuenta cuenta_m);
	public double ObtenerSaldo(cuenta cuenta_m);
	public ArrayList<AceptarCuenta> listarAceptarCuentas();
}
