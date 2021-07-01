package dao;

import java.util.List;

import entidad.usuario;

public interface usuarioDao {
	//public boolean insert(usuario usuario);
	//public boolean delete(usuario usuario_a_eliminar);
	public boolean modificar(usuario usuario_a_modificar);
	public List<usuario> readAll();
	public usuario obtenerUno(int dni);
	public boolean insert(usuario usuario);

}
