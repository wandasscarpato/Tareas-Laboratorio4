package negocio;

import java.util.List;

import entidad.usuario;

public interface usuarioNegocio {
	public List<usuario> listarUsuarios();
	public List<usuario> obtenerUno(int dni);
	public boolean modificar (usuario usu);
	public int ValidarUsuario(String Usuario,String Clave);
	public int ValidarAdmin(String usuario, String pass);
}
