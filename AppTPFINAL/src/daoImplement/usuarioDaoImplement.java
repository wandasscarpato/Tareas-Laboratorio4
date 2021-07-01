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
import datosImpl.Conexion;
import datosImpl.Exception;
import datosImpl.String;
import entidad.Articulo;
import entidad.Categoria;
import entidad.usuario;

public class usuarioDaoImplement implements usuarioDao  {

	private static final String listado = "SELECT * FROM usuario";
	private static final String insert = "INSERT INTO lab4.Usuario (DNI, Usuario, Pass) values (?,?,?)";
	
	private conexion cn;
	
	public usuarioDaoImplement() {
		
	}
	
	@Override
    public boolean insert(usuario usu) {
		
		boolean estado=true;

		cn = new conexion();
		cn.Open();	

		System.out.println(insert);
		try
		 {
			estado=cn.execute(insert);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}

	public List<usuario> readAll(){
		
		cn = new conexion();
		cn.Open();
		 List<usuario> list = new ArrayList<usuario>();
		 try
		 {
			 ResultSet rs= cn.query(listado);
			 while(rs.next())
			 {
				usuario usuRs = new usuario();
				usuRs.setUsuario(rs.getString("Usuario"));
				usuRs.setDNI(rs.getInt("DNI"));
				usuRs.setPass(rs.getString("Pass"));
					
				list.add(usuRs);	
			 } 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		 return list;
	}
	

	public usuario obtenerUno(int dni) {
		cn = new conexion();
		cn.Open();
		usuario usu = new usuario();
		try
		 {
			 ResultSet rs= cn.query("SELECT * FROM usuario WHERE DNI= " + dni);
			 rs.next();
			 
			 usu.setUsuario(rs.getString("Usuario"));
			 usu.setDNI(rs.getInt("DNI"));
			 usu.setPass(rs.getString("Pass"));		 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		return usu;
	}
	
	public boolean modificar(usuario usu) {
		boolean estado=true;

		cn = new conexion();
		cn.Open();	
		
		String query = "UPDATE usuario SET Pass= '"+usu.getPass()+"' WHERE DNI='"+usu.getDNI()+"'";

		try
		 {
			estado=cn.execute(query);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return estado;
	}

	
	
}
