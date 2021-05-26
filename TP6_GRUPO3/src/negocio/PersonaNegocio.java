package negocio;

import java.util.List;

import entidad.Persona;

public interface PersonaNegocio {
	
	public boolean insert(Persona persona_agregar);
	public boolean delete(Persona persona_eliminar);
	public boolean modify(Persona persona_modificar);
	public List<Persona> readAll();

}
