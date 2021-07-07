package dao;

import java.util.ArrayList;

import entidad.provincia;

public interface provinciasDao {
	
	public ArrayList<provincia> listarProvincias();
	
	public String buscarNombreprovincia(int id);
}
