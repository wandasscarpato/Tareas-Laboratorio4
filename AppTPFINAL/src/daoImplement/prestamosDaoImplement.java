package daoImplement;

import java.sql.Connection;
import daoImplement.conexion;

import entidad.n_prestamo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class prestamosDaoImplement {

	private static final String listar = "SELECT `n_prestamo`.`N_Prestamo`,`n_prestamo`.`DNI`,`n_prestamo`.`Fecha`,`n_prestamo`.`importe_intereses`,`n_prestamo`.`importe_pedido`,`n_prestamo`.`plazo`,`n_prestamo`.`montoXMes`,`n_prestamo`.`Cuotas`,`n_prestamo`.`N_CuentaADepositar`,`n_prestamo`.`Estado`FROM `lab4`.`n_prestamo`";
	private static final String estado = "UPDATE `lab4`.`n_prestamo` SET `Estado` = 1 WHERE `N_Prestamo` = ?";
	private static final String insert = "INSERT INTO `lab4`.`n_prestamo`(`DNI`,`importe_intereses`,`importe_pedido`,`montoXMes`,`Cuotas`,`N_CuentaADepositar`,`Estado`)VALUES(?,?,?,?,?,?,0)" ;
	private static final String listarXdni = "SELECT * FROM n_prestamo WHERE DNI = ?";
	
	public boolean insert(n_prestamo prestamo) {
        PreparedStatement statement;
        Connection Conexion = conexion.getConexion().getSQLConexion();
        boolean isInsertExitoso = false;
        try
        {
            statement = Conexion.prepareStatement(insert);
            statement.setInt(1, prestamo.getDNI());
            statement.setFloat(2, prestamo.getImporte_intereses());
            statement.setFloat(3, prestamo.getImporte_pedido());
            statement.setFloat(4, prestamo.getMontoxMes());
            statement.setInt(4, prestamo.getCuotas());
            statement.setInt(6, prestamo.getN_cuentaADepositar());
       
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
	
	
	public ArrayList<n_prestamo> listarPrestamos()
    {
        PreparedStatement statement;
        ResultSet resultSet; //Guarda el resultado de la query
        ArrayList<n_prestamo> n_prestamo = new ArrayList<n_prestamo>();
        Connection Conexion = conexion.getConexion().getSQLConexion();
        try 
        {
            statement = Conexion.prepareStatement(listar);
            resultSet = statement.executeQuery();
            while(resultSet.next())
            {
        
            	n_prestamo prestamoRs = new n_prestamo();
            
            	prestamoRs.setDNI(resultSet.getInt("DNI"));
            	prestamoRs.setN_Prestamo(resultSet.getInt("N_Prestamo"));
            	prestamoRs.setImporte_intereses(resultSet.getFloat("importe_intereses"));
            	prestamoRs.setImporte_pedido(resultSet.getFloat("Importe_pedido"));
            	prestamoRs.setPlazo(resultSet.getInt("plazo"));
            	prestamoRs.setMontoxMes(resultSet.getFloat("montoXMes"));
            	prestamoRs.setCuotas(resultSet.getInt("Cuotas"));
            	prestamoRs.setN_cuentaADepositar(resultSet.getInt("N_cuentaADepositar"));
            	prestamoRs.setEstado(resultSet.getBoolean("Estado"));
	            
            	n_prestamo.add(prestamoRs);

            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return n_prestamo;
    }
	
	
	///LISTAR x DNI
	
	public ArrayList<n_prestamo> listarPrestamosxDni(int dni)
    {
        PreparedStatement statement;
        ResultSet resultSet; //Guarda el resultado de la query
        ArrayList<n_prestamo> n_prestamo = new ArrayList<n_prestamo>();
        Connection Conexion = conexion.getConexion().getSQLConexion();
        try 
        {
            statement = Conexion.prepareStatement(listarXdni);
            statement.setInt(1, dni);
            resultSet = statement.executeQuery();
            while(resultSet.next())
            {
        
            	n_prestamo prestamoRs = new n_prestamo();
            
            	prestamoRs.setDNI(resultSet.getInt("DNI"));
            	prestamoRs.setN_Prestamo(resultSet.getInt("N_Prestamo"));
            	prestamoRs.setImporte_intereses(resultSet.getFloat("importe_intereses"));
            	prestamoRs.setImporte_pedido(resultSet.getFloat("Importe_pedido"));
            	prestamoRs.setPlazo(resultSet.getInt("plazo"));
            	prestamoRs.setMontoxMes(resultSet.getFloat("montoXMes"));
            	prestamoRs.setCuotas(resultSet.getInt("Cuotas"));
            	prestamoRs.setN_cuentaADepositar(resultSet.getInt("N_cuentaADepositar"));
            	prestamoRs.setEstado(resultSet.getBoolean("Estado"));
            	
            	
            	n_prestamo.add(prestamoRs);

            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return n_prestamo;
    }
	 
	 

	public boolean autorizar(int prestamoAutorizado)
	{
		PreparedStatement statement;
		Connection Conexion = conexion.getConexion().getSQLConexion();
		boolean cambioExitoso = false;
		try 
		{
			statement = Conexion.prepareStatement(estado);
			statement.setInt(1, prestamoAutorizado);
			if(statement.executeUpdate() > 0)
			{
				Conexion.commit();
				cambioExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cambioExitoso;
	}
	
	
}
