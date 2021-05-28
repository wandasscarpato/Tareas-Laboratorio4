package negocioImplement;

import java.util.List;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(Persona persona_modificar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Persona> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
