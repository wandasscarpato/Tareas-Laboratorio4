package daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import dao.usuarioDao;

import daoImplement.conexion;
import entidad.usuario;

public class usuarioDaoImplement implements usuarioDao  {

	private static final String update = "UPDATE usuario SET Pass= ? WHERE DNI= ?";
	private static final String listado = "SELECT * FROM usuario";
	
	public usuarioDaoImplement() {
		
	}

	public List<usuario> readAll() {
		PreparedStatement statement;
		Connection cn = conexion.getConexion().getSQLConexion();
		List<usuario> lista = new ArrayList<usuario>();
		try {
			statement = cn.prepareStatement(listado);
		    ResultSet rs = statement.executeQuery();
			while(rs.next()){
				
				usuario usuarioRs = new usuario();
				usuarioRs.setUsuario(rs.getString("Usuario"));
				usuarioRs.setDNI(rs.getInt("DNI"));
				usuarioRs.setPass(rs.getString("Pass"));
				
				lista.add(usuarioRs);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public usuario obtenerUno(int dni) {
		PreparedStatement statement;
		Connection cn = conexion.getConexion().getSQLConexion();
		usuario usu = new usuario();
		try
		 {
			 statement = cn.prepareStatement("SELECT * FROM usuario WHERE DNI= ?");
			 statement.setInt(1, dni);
			 ResultSet rs = statement.executeQuery();
			 rs.next();
			 
			 usu.setUsuario(rs.getString("Usuario"));
			 usu.setDNI(rs.getInt("DNI"));
			 usu.setPass(rs.getString("Pass"));	 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return usu;
	}

	public int modificar(usuario usuario) {

		PreparedStatement statement;
		Connection cn = conexion.getConexion().getSQLConexion();
		int resultado = -2;
		
		try 
		{
			statement = cn.prepareStatement(update);
			statement.setString(1, usuario.getPass());
			statement.setInt(2, usuario.getDNI());
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

	
	
}
