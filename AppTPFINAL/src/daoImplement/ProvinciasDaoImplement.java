package daoImplement;

import java.sql.Connection;
import daoImplement.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.provincia;

public class ProvinciasDaoImplement {
	private static final String listar = "SELECT `privincia`.`ID_Provincia`,`privincia`.`Provincia` FROM `lab4`.`privincia`";
	

	 public ArrayList<provincia> listarProvincias()
	    {
	        PreparedStatement statement;
	        ResultSet resultSet; //Guarda el resultado de la query
	        ArrayList<provincia> provincias = new ArrayList<provincia>();
	        Connection Conexion = conexion.getConexion().getSQLConexion();
	        try 
	        {
	            statement = Conexion.prepareStatement(listar);
	            resultSet = statement.executeQuery();
	            while(resultSet.next())
	            {
	            	
	            	provincia provinciaRs = new provincia();
	            
	            	provinciaRs.setID(resultSet.getInt("ID_Provincia"));
	            	provinciaRs.setProvincia(resultSet.getString("Provincia"));
		           
	            	provincias.add(provinciaRs);

	            }
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	        return provincias;
	    }
}
