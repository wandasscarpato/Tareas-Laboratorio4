package daoImplement;

import java.sql.Connection;
import daoImplement.conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.clienteDao;
import daoImplement.conexion;
import entidad.cliente;



public class clienteDaoImplement implements clienteDao {

	private static final String insert = "INSERT INTO cliente(idPersona, nombre, telefono) VALUES(?, ?, ?)";
	private static final String delete = "UPDATE cliente SET estado = ? where DNI = ?";
	//private static final String readall = "SELECT * FROM personas";
		
	public boolean insert(cliente cliente)
	{
		
		
		PreparedStatement statement;
		Connection Conexion = conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = Conexion.prepareStatement(insert);
			//statement.setInt(1, cliente.getIdPersona());
			//statement.setString(2, cliente.getNombre());
			//statement.setString(3, cliente.getTelefono());
			if(statement.executeUpdate() > 0)
			{
				Conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				Conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	
	//DELETE
	
	public boolean delete(int cliente_a_eliminar)
	{
		PreparedStatement statement;
		Connection Conexion = conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = Conexion.prepareStatement(delete);
			statement.setBoolean(1, false);
			statement.setInt(2, cliente_a_eliminar);
			if(statement.executeUpdate() > 0)
			{
				Conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
}
