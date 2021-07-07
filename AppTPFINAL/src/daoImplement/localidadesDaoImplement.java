package daoImplement;

import java.sql.Connection;
import daoImplement.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.localidadesDao;
import entidad.localidad;

public class localidadesDaoImplement implements localidadesDao{

	private static final String listar = "SELECT ID_Localidad,Localidad FROM lab4.localidad";
	

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
	 public String buscarNombreLocalidad(int id) {
		    String localidad = "";
		    Connection Conexion = conexion.getConexion().getSQLConexion();
		    try {
		      PreparedStatement statement = Conexion.prepareStatement("SELECT Localidad FROM lab4.localidad WHERE ID_Localidad=" + id);
		      ResultSet resultSet = statement.executeQuery();
		      if (resultSet.next())
		        localidad = resultSet.getString("Localidad"); 
		      return localidad;
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return localidad;
		    } 
		  }
}
