package dao;

import java.util.ArrayList;
import java.util.List;

import entidad.cliente;

public interface clienteDao {
		public ArrayList<cliente> listarClientes();
		public boolean insert(cliente cliente);
		public boolean delete(int cliente_a_eliminar, boolean estadoC);
		//public boolean modificar(usuario usuario_a_modificar);
		//public List<usuario> readAll();
		ArrayList<cliente> listarClienteLogueado(int paramInt);
	}
	
