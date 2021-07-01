package negocioImplement;

import java.util.ArrayList;
import java.util.List;

import dao.usuarioDao;
import daoImplement.usuarioDaoImplement;
import entidad.usuario;
import negocio.usuarioNegocio;

public class usuarioNegocioImplement implements usuarioNegocio {
	
	private usuarioDao usuDao = new usuarioDaoImplement();
	
	//Se puede recibir por constructor
	public usuarioNegocioImplement(usuarioDao usuDao)
	{
		this.usuDao = usuDao;
	}
	
	public usuarioNegocioImplement()
	{
	}
	
	public List<usuario> listarUsuarios() {
		return (List<usuario>) usuDao.readAll();
	}
	
	public usuario obtenerUno(int dni) {
		return usuDao.obtenerUno(dni);
	}
	
	public boolean modificar (usuario usu) {
		return usuDao.modificar(usu);
	}

	@Override
	public int ValidarUsuario(String Usuario, String Clave) {
		return usuDao.VerificarUsuario(Usuario, Clave);
	}

}
