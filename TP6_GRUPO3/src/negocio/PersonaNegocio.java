package negocio;

import java.util.List;

import javax.swing.JList;

import entidad.Persona;

public interface PersonaNegocio {
	
	public boolean insert(Persona persona_agregar);
	public boolean chequearDni(String dni);
	public boolean delete(Persona persona_eliminar);
	public void listado(JList listado);
	public boolean modify(Persona persona_modificar);
	public List<Persona> readAll();

}
