package daoImplement;

import java.sql.Connection;
import java.sql.Date;

import daoImplement.conexion;

import entidad.n_prestamo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class prestamosDaoImplement {

	private static final String listar = "SELECT `n_prestamo`.`N_Prestamo`,`n_prestamo`.`DNI`,`n_prestamo`.`Fecha`,`n_prestamo`.`importe_intereses`,`n_prestamo`.`importe_pedido`,`n_prestamo`.`plazo`,`n_prestamo`.`montoXMes`,`n_prestamo`.`Cuotas`,`n_prestamo`.`N_CuentaADepositar`,`n_prestamo`.`Estado`FROM `lab4`.`n_prestamo`";
	private static final String aceptar = "UPDATE `lab4`.`n_prestamo` SET `Estado` = 1 WHERE `N_Prestamo` = ?";
	private static final String rechazar = "UPDATE `lab4`.`n_prestamo` SET `Estado` = 2 WHERE `N_Prestamo` = ?";
	private static final String actualizarMonto = "UPDATE cuenta INNER JOIN n_prestamo on n_prestamo.n_prestamo = ? SET cuenta.Saldo = (cuenta.Saldo+n_prestamo.importe_pedido) WHERE (cuenta.DNI = n_prestamo.DNI) AND (cuenta.N_Cuenta = n_prestamo.N_CuentaADepositar) AND (n_prestamo.n_prestamo = ?)";
	private static final String insert = "INSERT INTO `lab4`.`n_prestamo`(`DNI`,`importe_intereses`,`importe_pedido`,`montoXMes`,`Cuotas`,`N_CuentaADepositar`,`Estado`)VALUES(?,?,?,?,?,?,0)" ;
	private static final String listarXdni = "SELECT * FROM n_prestamo WHERE DNI = ?";
	private static final String Reporte_1 = "SELECT sum(importe_intereses) - SUM(importe_pedido)  as 'Total_ganado', count(date_format(fecha,'%y-%m-%d')) as 'Cantidad_Prestamo' ,date_format(fecha,'%y-%m-%d') as 'Fecha' FROM n_prestamo GROUP BY date_format(fecha,'%y-%m-%d') ";
	private static final String Filter_Reporte_1 = "SELECT sum(importe_intereses) - SUM(importe_pedido)  as 'Total_ganado', count(date_format(fecha,'%y-%m-%d')) as 'Cantidad_Prestamo' ,date_format(fecha,'%y-%m-%d') as 'Fecha' FROM n_prestamo WHERE fecha between ? and ? GROUP BY fecha";
	
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
            statement.setInt(5, prestamo.getCuotas());
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
            	prestamoRs.setEstado(resultSet.getInt("Estado"));
	            
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
            	prestamoRs.setEstado(resultSet.getInt("Estado"));
            	
            	
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
			statement = Conexion.prepareStatement(aceptar);
			statement.setInt(1, prestamoAutorizado);
			if(statement.executeUpdate() > 0)
			{
				Conexion.commit();
				cambioExitoso = true;
			}
			
			if(cambioExitoso == true) {
				statement = Conexion.prepareStatement(actualizarMonto);
				statement.setInt(1, prestamoAutorizado);
				statement.setInt(2, prestamoAutorizado);
				
				if(statement.executeUpdate() > 0)
				{
					Conexion.commit();
				}
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cambioExitoso;
	}
	
	public boolean rechazar(int prestamoRechazado)
	{
		PreparedStatement statement;
		Connection Conexion = conexion.getConexion().getSQLConexion();
		boolean cambioExitoso = false;
		try 
		{
			statement = Conexion.prepareStatement(rechazar);
			statement.setInt(1, prestamoRechazado);
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
	
	public List<n_prestamo> listarReporte_1(){
		PreparedStatement statement;
        ResultSet resultSet;
        List<n_prestamo> n_prestamo = new ArrayList<n_prestamo>();
        Connection Conexion = conexion.getConexion().getSQLConexion();
        try 
        {
            statement = Conexion.prepareStatement(Reporte_1);
            resultSet = statement.executeQuery();
            while(resultSet.next())
            {
        
            	n_prestamo prestamoRs = new n_prestamo();
            
            	// Me trae el total ganado (IMP.INTE - IMP.SOL)
            	prestamoRs.setImporte_intereses(resultSet.getFloat("Total_ganado"));
            	// ME TRAE cantidad de prestamos por mes
	            prestamoRs.setDNI(resultSet.getInt("Cantidad_Prestamo"));
            	// ME TRAE Fecha
	            prestamoRs.setFecha(resultSet.getString("Fecha"));
	            
            	n_prestamo.add(prestamoRs);

            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return n_prestamo;
	}
	
	public List<n_prestamo> Filter_reporte_1(String d1, String d2){
		PreparedStatement statement;
        ResultSet resultSet;
        List<n_prestamo> n_prestamo = new ArrayList<n_prestamo>();
        Connection Conexion = conexion.getConexion().getSQLConexion();
        
        String aux;
        
        if(d1.compareTo(d2) < 0) {
        	aux = d1;
        	d1 = d2;
        	d2=aux;
        }
        
        try 
        {
            statement = Conexion.prepareStatement(Filter_Reporte_1);
            
            	statement.setString(1, d1);
            	statement.setString(2, d2);
            
            resultSet = statement.executeQuery();
            while(resultSet.next())
            {
        
            	n_prestamo prestamoRs = new n_prestamo();
            	// Me trae el total ganado (IMP.INTE - IMP.SOL)
            	prestamoRs.setImporte_intereses(resultSet.getFloat("Total_ganado"));
            	System.out.println(resultSet.getFloat("Total_ganado"));
            	// ME TRAE cantidad de prestamos por mes
	            prestamoRs.setDNI(resultSet.getInt("Cantidad_Prestamo"));
	            System.out.println(resultSet.getInt("Cantidad_Prestamo"));
            	// ME TRAE Fecha
	            prestamoRs.setFecha(resultSet.getString("Fecha"));
	            System.out.println(resultSet.getString("Fecha"));
	            
            	n_prestamo.add(prestamoRs);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return n_prestamo;
	}
	
}
