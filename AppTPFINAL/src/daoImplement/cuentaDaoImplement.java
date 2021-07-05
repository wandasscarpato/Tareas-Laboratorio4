package daoImplement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.cuentaDao;
import entidad.cuenta;

public class cuentaDaoImplement implements cuentaDao {
	
	private static final String insert = "INSERT INTO cuenta ( `Tipo`, `CBU`, `Saldo`, `DNI`, `Estado`) VALUES ( ?, ?, ?, ?, ?);";
	private static final String verificar = "SELECT count(n_cuenta) from cuenta where dni= ?;";
	private static final String listado = "SELECT * FROM cuenta";
	private static final String listado_uno = "SELECT * FROM cuenta WHERE DNI = ";
	private static final String eliminar = "UPDATE cuenta SET Estado= ? WHERE N_Cuenta= ?";
	private static final String updateEstado = "UPDATE cuenta SET Estado= ? WHERE N_Cuenta= ? AND DNI= ?";
	private static final String updateTipo = "UPDATE cuenta SET Tipo= ? WHERE N_Cuenta= ? AND DNI= ?";
	
	public boolean insert(cuenta cuenta)
	{
		PreparedStatement statement;
		Connection cn = conexion.getConexion().getSQLConexion();
		
		boolean isInsertExitoso = false;
		try
		{
			
			System.out.print("FUNCION PARA SQLLLLLLLLLLLLLLLLLLLLLLLLLLL AHREEE");
			
			statement = cn.prepareStatement(insert);
			
			System.out.print("PREPARA LA CONSULTA");
			
			//statement.setInt(1, cuenta.getN_Cuenta());
			statement.setString(1, cuenta.getTipo());
			//statement.setDate(3, (Date) cuenta.getFecha_cracion());
			statement.setInt(2, cuenta.getCBU());
			statement.setDouble(3, cuenta.getSaldo());
			statement.setInt(4, cuenta.getDNI());
			statement.setBoolean(5, cuenta.getEstado());
			
			if(statement.executeUpdate() > 0)
			{
				cn.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	
	/////////////////////
	
	
	public int verificar(cuenta cuenta)
	{
		PreparedStatement statement;
		Connection cn = conexion.getConexion().getSQLConexion();
		
		//boolean isVerifyExitoso = false;
		int cant=0;
		
		try
		{
			
			statement = cn.prepareStatement(verificar);
			
		statement.setInt(1, cuenta.getDNI());
		System.out.print("EL DNI QUE SE MANDA ES: "+ cuenta.getDNI() );
	
			 ResultSet rs = statement.executeQuery();
			while(rs.next())
		        cant=rs.getInt(1);
			
			//if(cant = statement.executeUpdate() > 0)
			//{
			//	cn.commit();
		 	//isVerifyExitoso = true;
			
		 	System.out.print("VUELVE DE LA VERIFICACIONNN ");
		 	
			//}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return cant;
	}
	
	
	/////////////////////
	
	public List<cuenta> readAll(){
		PreparedStatement statement;
		Connection cn = conexion.getConexion().getSQLConexion();
		List<cuenta> lista = new ArrayList<cuenta>();
		try {
			statement = cn.prepareStatement(listado);
		    ResultSet rs = statement.executeQuery();
			while(rs.next()){
				
				cuenta cuentaRs = new cuenta();
				cuentaRs.setN_Cuenta(rs.getInt("N_Cuenta"));
				cuentaRs.setDNI(rs.getInt("DNI"));
				cuentaRs.setFecha_cracion(rs.getDate("Fecha_cracion"));
				cuentaRs.setTipo(rs.getString("Tipo"));
				cuentaRs.setCBU(rs.getInt("CBU"));
				cuentaRs.setSaldo(rs.getDouble("Saldo"));
				cuentaRs.setEstado(rs.getBoolean("Estado"));
				
				lista.add(cuentaRs);
			}
			cn.commit();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<cuenta> ObtenerxDni(String dni) {
		PreparedStatement statement;
		Connection cn = conexion.getConexion().getSQLConexion();
		List<cuenta> lista = new ArrayList<cuenta>();
		try {
			statement = cn.prepareStatement(listado_uno + dni);
		    ResultSet rs = statement.executeQuery();
			while(rs.next()){
				
				cuenta cuentaRs = new cuenta();
				cuentaRs.setN_Cuenta(rs.getInt("N_Cuenta"));
				cuentaRs.setDNI(rs.getInt("DNI"));
				cuentaRs.setFecha_cracion(rs.getDate("Fecha_cracion"));
				cuentaRs.setTipo(rs.getString("Tipo"));
				cuentaRs.setCBU(rs.getInt("CBU"));
				cuentaRs.setSaldo(rs.getDouble("Saldo"));
				cuentaRs.setEstado(rs.getBoolean("Estado"));
				
				lista.add(cuentaRs);
			}
			cn.commit();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public boolean eliminar(cuenta cuenta_m) {
		PreparedStatement statement;
		Connection Conexion = conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = Conexion.prepareStatement(eliminar);
			statement.setBoolean(1, cuenta_m.getEstado());
			statement.setInt(2, cuenta_m.getN_Cuenta());

			if(statement.executeUpdate() > 0)
			{
				Conexion.commit();
				isInsertExitoso = true;
			}
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					Conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} 
		return isInsertExitoso;
	}
	
	public boolean modificarEstado(cuenta cuenta_m) {
		PreparedStatement statement;
		Connection Conexion = conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = Conexion.prepareStatement(updateEstado);
			statement.setBoolean(1, true);			
			statement.setInt(2, cuenta_m.getN_Cuenta());
			statement.setInt(3, cuenta_m.getDNI());

			
			if(statement.executeUpdate() > 0)
			{
				Conexion.commit();
				isInsertExitoso = true;
			}
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					Conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} 
		return isInsertExitoso;
	}
	public boolean modificarTipo(cuenta cuenta_m) {
		PreparedStatement statement;
		Connection Conexion = conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = Conexion.prepareStatement(updateTipo);
			statement.setString(1, cuenta_m.getTipo());			
			statement.setInt(2, cuenta_m.getN_Cuenta());
			statement.setInt(3, cuenta_m.getDNI());

			
			if(statement.executeUpdate() > 0)
			{
				Conexion.commit();
				isInsertExitoso = true;
			}
			} catch (SQLException e) {
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