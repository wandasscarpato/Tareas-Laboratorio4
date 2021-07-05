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
            	prestamoRs.setImporte_intereses(resultSet.getString("importe_intereses"));
            	prestamoRs.setImporte_pedido(resultSet.getString("Importe_pedido"));
            	prestamoRs.setPlazo(resultSet.getInt("plazo"));
            	prestamoRs.setMontoxMes(resultSet.getString("montoXMes"));
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
	 

}
