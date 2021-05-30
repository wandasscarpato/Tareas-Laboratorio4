package negocioImplement;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JList;

import dao.PersonaDao;
import daoImplement.PersonaDaoImplement;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImplement implements PersonaNegocio{

	PersonaDao pdao = new PersonaDaoImplement();
	
	@Override
	public boolean insert(Persona persona) {
		Boolean estado=false;
		if(persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0 
				&& persona.getDni().trim().length()>0)
		{		
				estado=pdao.insert(persona);
		}
		return estado;
	}
	
	@Override
	public boolean chequearDni(String dni) {
		return pdao.chequearDni(dni);
	}

	@Override
	public boolean delete(Persona persona_eliminar) {
		Boolean estado=false;
		estado=pdao.delete(persona_eliminar);
		return estado;
	}
	
	@Override
	public void listado(JList listado) {
		try {
			pdao.listado(listado);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int modify(Persona persona_modificar_A,Persona persona_modificar_S) {
		int estado = -2;
		if(persona_modificar_S.getDni().trim().length()>0 && persona_modificar_S.getNombre().trim().length()>0 && persona_modificar_S.getApellido().trim().length()>0) {
			estado = pdao.modify(persona_modificar_A,persona_modificar_S);
		}
		return estado;
	}
	
	@Override
	public List<Persona> listarPersonas() {
		return pdao.listarPersonas();
	}

	@Override
	public List<Persona> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
