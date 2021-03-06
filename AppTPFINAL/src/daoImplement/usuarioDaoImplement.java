package daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.usuarioDao;

import daoImplement.conexion;
import entidad.usuario;

public class usuarioDaoImplement implements usuarioDao  {

	private static final String listado = "SELECT * FROM usuario";
	private static final String insert = "INSERT INTO lab4.Usuario (DNI, Usuario, Pass) values (?,?,?)";
	private static final String update = "UPDATE usuario SET Pass= ? WHERE DNI= ?";
	private static final String Verificar = "Select count(DNI) from Usuario where Usuario= ? and Pass= ?";
	private static final String VerificarAdmin = "Select count(Usuario) from administrador where Usuario= ? and Pass= ?";
	private static final String ObtenerDNI = "Select DNI from Usuario where Usuario= ?";
	
	private conexion cn;
	
	public usuarioDaoImplement() {
		
	}
	
	@Override
	public boolean insert(usuario usuario) {
        PreparedStatement statement;
        Connection Conexion = conexion.getConexion().getSQLConexion();
        boolean isInsertExitoso = false;
        try
        {
            statement = Conexion.prepareStatement(insert);
            statement.setInt(1,usuario.getDNI());
            statement.setString(2, usuario.getUsuario());
            statement.setString(3,usuario.getPass());

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
			cn.commit();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return lista;
	}
			
			
	public ArrayList<usuario> obtenerUno(int dni) {
		PreparedStatement statement;
		Connection cn = conexion.getConexion().getSQLConexion();
		ArrayList<usuario> lista = new ArrayList<usuario>();
		usuario usu = new usuario();
		System.out.println("sadsadasd");
		try
		 {
			 statement = cn.prepareStatement("SELECT * FROM usuario WHERE DNI= " + dni);
			 ResultSet rs= statement.executeQuery();
			 rs.next();
		 
			 usu.setUsuario(rs.getString("Usuario"));
			 usu.setDNI(rs.getInt("DNI"));
			 usu.setPass(rs.getString("Pass"));	
			 
			 lista.add(usu);
			 
			 cn.commit();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return lista;
	}
	
	public boolean modificar(usuario usu) {
		PreparedStatement statement;
		Connection cn = conexion.getConexion().getSQLConexion();
		boolean isModExitosa = true;
		try
		{
			statement = cn.prepareStatement(update);
			statement.setString(1, usu.getPass());
			statement.setInt(2, usu.getDNI());
			statement.executeUpdate();		
			cn.commit();
		}
		catch(Exception e)
		{
			isModExitosa = false;
			e.printStackTrace();
		}
		
		return isModExitosa;
	}

	@Override
	public int ValidarUsuario(String Usuario, String Clave) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection Conexion = conexion.getConexion().getSQLConexion();
		try {
			ps = Conexion.prepareStatement(Verificar);
			ps.setString(1, Usuario);
			ps.setString(2, Clave);
			rs = ps.executeQuery();
			if(rs.next()) 
			{
				return rs.getInt(1);
			}
			
			return 1;
			
		} catch (SQLException ex) {
			return 1;
		}
	}
	
	@Override
	public int ValidarAdmin(String Usuario, String Clave) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection Conexion = conexion.getConexion().getSQLConexion();
		try {
			ps = Conexion.prepareStatement(VerificarAdmin);
			ps.setString(1, Usuario);
			ps.setString(2, Clave);
			rs = ps.executeQuery();
			if(rs.next()) 
			{
				return rs.getInt(1);
			}
			
			return 0;
			
		} catch (SQLException ex) {
			return 0;
		}
	}
	
	@Override
	public int buscarDNIUsuario(String Usuario) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection Conexion = conexion.getConexion().getSQLConexion();
		try {
			ps = Conexion.prepareStatement(ObtenerDNI);
			ps.setString(1, Usuario);
			rs = ps.executeQuery();
			if(rs.next()) 
			{
				return rs.getInt(1);
			}
			
			return 0;
			
		} catch (SQLException ex) {
			return 0;
		}
	}

	
	
}
