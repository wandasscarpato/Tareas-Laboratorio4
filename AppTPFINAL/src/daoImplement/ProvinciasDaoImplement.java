package daoImplement;

import java.sql.Connection;
import daoImplement.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.provinciasDao;
import entidad.provincia;

public class ProvinciasDaoImplement implements provinciasDao {
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
	 
	 public String buscarNombreprovincia(int id) {
		    String provincia = "";
		    Connection Conexion = conexion.getConexion().getSQLConexion();
		    try {
		      PreparedStatement statement = Conexion.prepareStatement("SELECT provincia FROM lab4.privincia WHERE ID_provincia=" + id);
		      ResultSet resultSet = statement.executeQuery();
		      if (resultSet.next())
		        provincia = resultSet.getString("provincia"); 
		      return provincia;
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return provincia;
		    } 
		  }
}
