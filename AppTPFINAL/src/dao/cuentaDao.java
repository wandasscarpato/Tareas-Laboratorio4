package dao;

import java.util.ArrayList;
import java.util.List;

import entidad.AceptarCuenta;
import entidad.cuenta;

public interface cuentaDao {
	
	public boolean insert(cuenta cuenta);
	public int verificar(cuenta cuenta);
	public boolean eliminar(cuenta cuenta_a_modificar);
	public boolean modificarEstado(cuenta cuenta_a_modificar);
	public boolean modificarTipo(cuenta cuenta_modificar);
	public boolean modificarSaldo(cuenta cuenta_m);
	public List<cuenta> ObtenerxDni(String dni);
	public List<cuenta> readAll();
	public double ObtenerSaldo(cuenta cuenta_m);
	public ArrayList<AceptarCuenta> ListarAceptarCuenta();
	public int ObtenerN_Cuenta (cuenta cuenta_m);
}
