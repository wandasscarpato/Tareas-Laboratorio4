package daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImplement implements PersonaDao {
	
	private static final String insert = "INSERT INTO personas(dni, nombre, apellido) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE dni = ?";
	private static final String listado = "Select Nombre FROM Personas";

	@Override
	public boolean insert(Persona persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, persona.getDni());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}

	@Override
	public boolean delete(Persona persona_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isDeleteExitoso = false;
		try
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, persona_eliminar.getDni());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isDeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isDeleteExitoso;
	}

	@Override
	public boolean modify(Persona persona_modificar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Persona> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void listado(JList list) throws SQLException
	{
	    DefaultListModel model = new DefaultListModel();
	    
	    PreparedStatement statement;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    statement = conexion.prepareStatement(listado);
	    ResultSet resultSet = statement.executeQuery(listado);

	    while (resultSet.next())
	    {
	        String itemCode = resultSet.getString("Nombre");
	        model.addElement(itemCode);
	    }
	    list.setModel(model);

	    resultSet.close();
	    statement.close();

	}
	
	public boolean chequearDni(String dni) {
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try
		{
			 Statement st = conexion.createStatement();
			 String query = "Select dni from personas where dni="+dni;
			 ResultSet rs= st.executeQuery(query);
			 return rs.next();
			 
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
			  
	};

}
