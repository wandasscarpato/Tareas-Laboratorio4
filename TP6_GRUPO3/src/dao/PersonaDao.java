package dao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JList;
import javax.swing.JTable;

import entidad.Persona;

public interface PersonaDao {

	public boolean insert(Persona persona_agregar);
	public boolean chequearDni(String dni);
	public boolean delete(Persona persona_eliminar);
	public void listado(JList listado) throws SQLException;
	public int modify(Persona persona_modificar_A,Persona persona_modificar_S);
	public List<Persona> listarPersonas();
	public void listarPersonas (JTable table) throws SQLException;
	public List<Persona> readAll();
	
}
