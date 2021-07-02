package daoImplement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion 
{
	public static conexion instancia;
	private Connection connection;
	
	private conexion()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); // quitar si no es necesario
			//this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab4","root","root");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab4","root","ROOT");
			this.connection.setAutoCommit(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		instancia = null;
	}
}
