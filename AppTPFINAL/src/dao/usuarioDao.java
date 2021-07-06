package dao;

import java.util.ArrayList;
import java.util.List;

import entidad.usuario;

public interface usuarioDao {
	//public boolean insert(usuario usuario);
	//public boolean delete(usuario usuario_a_eliminar);
	public boolean modificar(usuario usuario_a_modificar);
	public List<usuario> readAll();
	public ArrayList<usuario> obtenerUno(int dni);
	public boolean insert(usuario usuario);
	public int ValidarUsuario(String Usuario,String Clave);
	public int ValidarAdmin(String Usuario, String Clave);
	public int buscarDNIUsuario(String usuario);
}
