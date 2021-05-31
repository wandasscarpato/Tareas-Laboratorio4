package daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImplement implements PersonaDao {
	
	private static final String insert = "INSERT INTO personas(dni, nombre, apellido) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE dni = ?";
	private static final String update = "UPDATE personas SET Dni = ?, Nombre = ? , Apellido = ? WHERE Dni = ? ";
	private static final String listado = "Select Nombre, Apellido, DNI FROM Personas";

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
	public int modify(Persona persona_modificar_A,Persona persona_modificar_S) 
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int resultado = -2;
		try 
		{
			//statement = conexion.prepareStatement("UPDATE personas SET Dni="+ personaNueva.getDni() +", Nombre = " + personaNueva.getNombre() + ", Apellido = " + personaNueva.getApellido() + "WHERE Dni = " + personaAnterior.getDni());
			statement = conexion.prepareStatement(update);
			statement.setString(1, persona_modificar_S.getDni());
			statement.setString(2, persona_modificar_S.getNombre());
			statement.setString(3, persona_modificar_S.getApellido());
			statement.setString(4, persona_modificar_A.getDni());
			if(statement.executeUpdate() > 0)
			{
				//conexion.commit();
				resultado = 1;
			}
		}
		catch (SQLException e) 
		{
			if(e instanceof SQLIntegrityConstraintViolationException) {
				resultado = -1;
			}
			e.printStackTrace();
		}
		return resultado;
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
	        String itemCode = resultSet.getString("Nombre") + " " + resultSet.getString("Apellido") + " " + resultSet.getString("DNI");
	        model.addElement(itemCode);
	    }
	    list.setModel(model);

	    resultSet.close();
	    statement.close();
	}

	@Override
	public List<Persona> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Persona> listarPersonas()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try 
		{
			statement = conexion.prepareStatement(listado);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Persona per = new Persona();
				per.setDni(resultSet.getString("Dni"));
				per.setNombre(resultSet.getString("Nombre"));
				per.setApellido(resultSet.getString("Apellido"));
				personas.add(per);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
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
			  
	}

	@Override
	public void listarPersonas(JTable table) throws SQLException
	{
		
		DefaultTableModel modelo = new DefaultTableModel();
		PreparedStatement statement;
		
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    statement = conexion.prepareStatement(listado);
	    ResultSet resultSet = statement.executeQuery(listado);
	    modelo.addColumn("Nombre");
	    modelo.addColumn("Apellido");
	    modelo.addColumn("DNI");
    	while(resultSet.next()) {
    		modelo.addRow(new Object[]{resultSet.getString("Nombre"),resultSet.getString("Apellido"),resultSet.getString("DNI")});
    	}
    	table.setModel(modelo);
    	resultSet.close();
 	    statement.close();
	}

}
