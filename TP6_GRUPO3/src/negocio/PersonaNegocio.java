package negocio;

import java.util.List;

import javax.swing.JList;

import entidad.Persona;

public interface PersonaNegocio {
	
	public boolean insert(Persona persona_agregar);
	public boolean chequearDni(String dni);
	public boolean delete(Persona persona_eliminar);
	public void listado(JList listado);
	public int modify(Persona persona_modificar_A,Persona persona_modificar_S);
	public List<Persona> listarPersonas();
	public List<Persona> readAll();

}
