package daoImplement;

import java.sql.Connection;
import daoImplement.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.localidad;

public class localidadesDaoImplement {

	private static final String listar = "SELECT * FROM lab4.localidad";
	

	 public ArrayList<localidad> listarLocalidades()
	    {
	        PreparedStatement statement;
	        ResultSet resultSet; //Guarda el resultado de la query
	        ArrayList<localidad> localidades = new ArrayList<localidad>();
	        Connection Conexion = conexion.getConexion().getSQLConexion();
	        try 
	        {
	            statement = Conexion.prepareStatement(listar);
	            resultSet = statement.executeQuery();
	            while(resultSet.next())
	            {
	            	
	            	localidad localidadRs = new localidad();
	            
	            	localidadRs.setID(resultSet.getInt("ID_Localidad"));
	            	localidadRs.setLocalidad(resultSet.getString("Localidad"));
		           
	            	localidades.add(localidadRs);

	            }
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	        return localidades;
	    }
}
