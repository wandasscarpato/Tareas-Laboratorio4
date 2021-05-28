package dao;

import java.util.List;

import entidad.Persona;

public interface PersonaDao {

	public boolean insert(Persona persona_agregar);
	public boolean chequearDni(String dni);
	public boolean delete(Persona persona_eliminar);
	public boolean modify(Persona persona_modificar);
	public List<Persona> readAll();
	
}
