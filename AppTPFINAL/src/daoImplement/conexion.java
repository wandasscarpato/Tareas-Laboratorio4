package daoImplement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion 
{
	private String host = "jdbc:mysql://localhost:3306/lab4";
	private String user = "root";
	private String pass = "root";
	//private String dbName = "bdpersonas??profileSQL=true&useSSL=false";

	protected Connection connection;
	
	
	public Connection Open()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(host, user, pass);
			System.out.println("CONEXION OK");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("ERROR CONTROLADOR");
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			System.out.println("ERROR CONEXION");
			e.printStackTrace();
		}
		return this.connection;
	}
	
	
	public ResultSet query(String query)
	{
		Statement st;
		ResultSet rs=null;
		try
		{
			st= connection.createStatement();
			rs= st.executeQuery(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	public boolean execute(String query)
	{
		Statement st;
		boolean save = true;
		try {
			st = connection.createStatement();
		    st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			save = false;
			e.printStackTrace();
		}
		return save;
	}
	
	public boolean close()
	{
		boolean ok=true;
		try {
			connection.close();
		}
		catch(Exception e)
		{
			ok= false;
			e.printStackTrace();
		}
		return ok;
	}
}