package daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.cuentaDao;
import entidad.cuenta;
import entidad.usuario;

public class cuentaDaoImplement implements cuentaDao {
	
	private static final String insert = "INSERT INTO cuenta (N_Cuenta, ID_Tipo, Fecha_cracion, CBU, Saldo, DNI, estado) VALUES (?,?, ?,?,?,?,?);";
	private static final String listado = "SELECT * FROM cliente";
	
	public boolean insert(cuenta cuenta)
	{
		
		
		PreparedStatement statement;
		Connection Conexion = conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = Conexion.prepareStatement(insert);
			statement.setInt(1, cuenta.getN_Cuenta());
			statement.setInt(2, cuenta.getID_Tipo());
			//statement.setDate(3, cuenta.getFecha_cracion());
			statement.setInt(4, cuenta.getCBU());
			statement.setDouble(5, cuenta.getSaldo());
			statement.setInt(6, cuenta.getDNI());
			statement.setBoolean(7, cuenta.isEstado());
			
			
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
	
	
}
