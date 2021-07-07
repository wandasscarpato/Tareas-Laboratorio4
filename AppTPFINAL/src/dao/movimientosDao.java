package dao;

import java.util.List;

import entidad.movimientos;

public interface movimientosDao {
	public List<movimientos> ObtenerxN_Cuenta(int n_cuenta);
	public List<movimientos> readAll();
}
