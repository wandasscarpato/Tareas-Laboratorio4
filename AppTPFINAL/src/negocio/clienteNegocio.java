package negocio;

import java.util.ArrayList;

import entidad.cliente;;

public interface clienteNegocio {

	public ArrayList<cliente> listarClientes();
	public boolean delete(int cliente_a_eliminar, boolean estadoC);
}
