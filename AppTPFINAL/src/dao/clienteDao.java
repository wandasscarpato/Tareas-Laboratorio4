package dao;

import java.util.List;

import entidad.cliente;

public interface clienteDao {

		public boolean insert(cliente cliente);
		public boolean delete(int cliente_a_eliminar, boolean estadoC);
		//public boolean modificar(usuario usuario_a_modificar);
		//public List<usuario> readAll();

	}
	
