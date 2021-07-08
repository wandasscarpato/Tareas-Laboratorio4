package daoImplement;

import java.sql.Connection;
import daoImplement.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.clienteDao;
import entidad.cliente;



public class clienteDaoImplement implements clienteDao {

	private static final String listar = "SELECT DNI, CUIL, Nombre, Apellido, Sexo, Nacimiento, Direccion, ID_Localodad, ID_Provincia, Email, Telefono, Estado FROM CLiente";
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
            statement.setInt(12, 3);

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
            
            return false;
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
		            clienteRs.setEstado(resultSet.getInt("Estado"));
		            
		            clientes.add(clienteRs);

	            }
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	        return clientes;
	    }
	 
	 public ArrayList<String> BuscarProYLocClientes(int idPro, int idLoc)
	    {
	        PreparedStatement statement;
	        ArrayList<String> LocYPro = new ArrayList<String>();
	        String buscarLoc = "Select localidad from localidad where id_localidad = " + idLoc;
	        String buscarPro = "Select provincia from privincia where id_provincia = " + idPro;
	        ResultSet resultSetLoc;
	        ResultSet resultSetPro;
	        Connection Conexion = conexion.getConexion().getSQLConexion();
	        try 
	        {
	            statement = Conexion.prepareStatement(buscarLoc);
	            resultSetLoc = statement.executeQuery();
	            statement = Conexion.prepareStatement(buscarPro);
	            resultSetPro = statement.executeQuery();
	            while(resultSetLoc.next())
	            {
	            	LocYPro.add(resultSetLoc.getString("localidad"));
	            }
	            while(resultSetPro.next())
	            {
	            	LocYPro.add(resultSetPro.getString("provincia"));
	            }
	            
	        } 
	        catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	        return LocYPro;
	    }
	
	
	//DELETE
	
	public boolean delete(int cliente_a_eliminar , boolean estadoC)
	{
		PreparedStatement statement;
		Connection Conexion = conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = Conexion.prepareStatement(delete);
			statement.setBoolean(1, estadoC);
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
	
	public ArrayList<cliente> listarClienteLogueado(int dni) {
	    ArrayList<cliente> clientes = new ArrayList<>();
	    Connection Conexion = conexion.getConexion().getSQLConexion();
	    try {
	      PreparedStatement statement = Conexion.prepareStatement("SELECT DNI, CUIL, Nombre, Apellido, Sexo, Nacimiento, Direccion, ID_Localodad, ID_Provincia, Email, Telefono, Estado FROM CLiente WHERE DNI=" + dni);
	      ResultSet resultSet = statement.executeQuery();
	      while (resultSet.next()) {
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
	        clienteRs.setEstado(resultSet.getInt("Estado"));
	        clientes.add(clienteRs);
	      } 
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } 
	    return clientes;
	  }
	
}
