package daoImplement;

import java.sql.Connection;
import daoImplement.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.clienteDao;
import daoImplement.conexion;
import entidad.cliente;



public class clienteDaoImplement implements clienteDao {

	private static final String listar = "SELECT DNI, CUIL, Nombre, Apellido, Sexo, Nacimiento, Direccion, ID_Localodad, ID_Provincia, Email, Telefono FROM CLiente";
	//private static final String listar = "SELECT * FROM CLiente";
	private static final String insert = "INSERT INTO lab4.Cliente (DNI, CUIL, Nombre, Apellido,Sexo, Nacimiento, Direccion,ID_Localodad, ID_Provincia, Email, Telefono, Estado) values (?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String delete = "UPDATE cliente SET estado = ? where DNI = ?";
	//private static final String readall = "SELECT * FROM personas";
		
	public boolean insert(cliente cliente) {
        PreparedStatement statement;
        Connection Conexion = conexion.getConexion().getSQLConexion();
        boolean isInsertExitoso = false;
        try
        {
            statement = Conexion.prepareStatement(insert);
            statement.setInt(1, cliente.getDNI());
            statement.setInt(2, cliente.getCUIL());
            statement.setString(3, cliente.getNombre());
            statement.setString(4, cliente.getApellido());
            statement.setString(5, cliente.getSexo());
            statement.setString(6, cliente.getNacimiento());
            statement.setString(7, cliente.getDireccion());
            statement.setInt(8, cliente.getID_Localodad());
            statement.setInt(9, cliente.getID_Provincia());
            statement.setString(10, cliente.getEmail());
            statement.setInt(11, cliente.getTelefono());
            statement.setBoolean(12, true);

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
	
	 public ArrayList<cliente> listarClientes()
	    {
	        PreparedStatement statement;
	        ResultSet resultSet; //Guarda el resultado de la query
	        ArrayList<cliente> clientes = new ArrayList<cliente>();
	        Connection Conexion = conexion.getConexion().getSQLConexion();
	        try 
	        {
	            statement = Conexion.prepareStatement(listar);
	            resultSet = statement.executeQuery();
	            while(resultSet.next())
	            {
	            	
	            	cliente clienteRs = new cliente();
	            
		            clienteRs.setDNI(resultSet.getInt("DNI"));
		            clienteRs.setCUIL(resultSet.getInt("CUIL"));
		            clienteRs.setNombre(resultSet.getString("Nombre"));
		            clienteRs.setApellido(resultSet.getString("Apellido"));
		            clienteRs.setSexo(resultSet.getString("Sexo"));
		            clienteRs.setNacimiento(resultSet.getString("Nacimiento"));
		            clienteRs.setDireccion(resultSet.getString("Direccion"));
		            clienteRs.setID_Localodad(resultSet.getInt("ID_Localodad"));
		            clienteRs.setID_Provincia(resultSet.getInt("ID_Provincia"));
		            clienteRs.setEmail(resultSet.getString("Email"));
		            clienteRs.setTelefono(resultSet.getInt("Telefono"));
		            clienteRs.setEstado(true);
		            
		            clientes.add(clienteRs);

	            }
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	        return clientes;
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
