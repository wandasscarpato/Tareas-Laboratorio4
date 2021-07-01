package negocio;

import java.util.ArrayList;
import java.util.List;

import entidad.usuario;

public interface usuarioNegocio {
	public List<usuario> listarUsuarios();
	public usuario obtenerUno(int dni);
	public boolean modificar (usuario usu);
	public int ValidarUsuario(String Usuario,String Clave);
}
