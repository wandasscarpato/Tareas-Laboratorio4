package dao;

import java.util.ArrayList;

import entidad.localidad;

public interface localidadesDao {

	public ArrayList<localidad> listarLocalidades();
	public String buscarNombreLocalidad(int id);
}
