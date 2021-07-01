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

	private static final String listado = "SELECT * FROM usuario";
	private static final String insert = "INSERT INTO lab4.Usuario (DNI, Usuario, Pass) values (?,?,?)";
	private static final String update = "UPDATE usuario SET Pass= ? WHERE DNI= ?";
	private static final String Verificar = "Select count(DNI) from Usuario where Usuario= ? and Pass= ?";
	
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
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return lista;
	}
			
			
	public usuario obtenerUno(int dni) {
		/*cn = new conexion();
		cn.Open();*/
		usuario usu = new usuario();/*
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
		 }*/
		return usu;
	}
	
	public boolean modificar(usuario usu) {
		boolean estado=true;

		/*cn = new conexion();
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
		}*/
		return estado;
	}

	@Override
	public int VerificarUsuario(String Usuario, String Clave) {
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
			//Logger.getLogger(SqlUsuarios.Class.GetName()).log(Level.SEVERE, null, ex);
			return 1;
		}
	}

	
	
}
