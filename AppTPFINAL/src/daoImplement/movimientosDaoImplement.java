package daoImplement;

import dao.movimientosDao;
import entidad.movimientos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class movimientosDaoImplement implements movimientosDao {
  private static final String listado = "SELECT ID_Movimiento, Fecha, Detalle, Importe, ID_TIPO_M FROM movimientos";
  private static final String altaPrestamo="INSERT INTO `lab4`.`movimientos`(`Importe`,`Detalle`,`ID_TIPO_M`,`N_Cuenta`)VALUES(?,?,2,?)";
  private static final String InsertMovimientos="INSERT INTO movimientos (`Importe`,`Detalle`,`ID_TIPO_M`,`N_Cuenta`)VALUES(?,?,?,?)";
  private static final String listado2 = "SELECT ID_Movimiento, Fecha, Detalle, Importe, ID_TIPO_M FROM movimientos where N_Cuenta =";
  private static final String obtenerNombreTipo = "SELECT Tipo_Movimiento FROM lab4.tipo_movimiento WHERE ID_Tipo =";
  
  public boolean insertAltaPrestamo(movimientos movimiento) {
      PreparedStatement statement;
      Connection Conexion = conexion.getConexion().getSQLConexion();
      boolean isInsertExitoso = false;
      try
      {
          statement = Conexion.prepareStatement(altaPrestamo);
          
          statement.setFloat(1, movimiento.getImporte());
          statement.setString(2, movimiento.getDetalle());
          statement.setInt(3, movimiento.getN_Cuenta());
    
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

  public boolean InsertMovimientos(movimientos movimiento) {
	  PreparedStatement statement;
      Connection Conexion = conexion.getConexion().getSQLConexion();
      boolean isInsertExitoso = false;
      try
      {
          statement = Conexion.prepareStatement(InsertMovimientos);
          
          statement.setFloat(1, movimiento.getImporte());
          statement.setString(2, movimiento.getDetalle());
          statement.setInt(3, movimiento.getID_Movimiento());
          statement.setInt(4, movimiento.getN_Cuenta());
          
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
  
  public List<movimientos> readAll() {
    Connection cn = conexion.getConexion().getSQLConexion();
    List<movimientos> lista = new ArrayList<>();
    try {
      PreparedStatement statement = cn.prepareStatement("SELECT ID_Movimiento, Fecha, Detalle, Importe, ID_TIPO_M FROM movimientos");
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        movimientos movimientosRs = new movimientos();
        movimientosRs.setID_Movimiento(rs.getInt("ID_Movimiento"));
        movimientosRs.setFecha(rs.getDate("Fecha"));
        movimientosRs.setDetalle(rs.getString("Detalle"));
        movimientosRs.setImporte(rs.getFloat("Importe"));
        movimientosRs.setID_Tipo(rs.getInt("ID_TIPO_M"));
        lista.add(movimientosRs);
      } 
      cn.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return lista;
  }
  
  public List<movimientos> ObtenerxN_Cuenta(int n_cuenta) {
    Connection cn = conexion.getConexion().getSQLConexion();
    List<movimientos> lista = new ArrayList<>();
    try {
      PreparedStatement statement = cn.prepareStatement("SELECT ID_Movimiento, Fecha, Detalle, Importe, ID_TIPO_M FROM movimientos where N_Cuenta =" + n_cuenta);
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        movimientos movimientosRs = new movimientos();
        movimientosRs.setID_Movimiento(rs.getInt("ID_Movimiento"));
        movimientosRs.setFecha(rs.getDate("Fecha"));
        movimientosRs.setDetalle(rs.getString("Detalle"));
        movimientosRs.setImporte(rs.getFloat("Importe"));
        movimientosRs.setID_Tipo(rs.getInt("ID_TIPO_M"));
        lista.add(movimientosRs);
      } 
      cn.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return lista;
  }
  
  public String buscarNombreTipo(int id) {
	    String nombreTipo = "";
	    Connection Conexion = conexion.getConexion().getSQLConexion();
	    try {
	      PreparedStatement statement = Conexion.prepareStatement(obtenerNombreTipo + id);
	      ResultSet resultSet = statement.executeQuery();
	      if (resultSet.next())
	        nombreTipo = resultSet.getString("Tipo_Movimiento"); 
	      return nombreTipo;
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return nombreTipo;
	    } 
	  }
}
