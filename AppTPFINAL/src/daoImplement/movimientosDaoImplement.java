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
  
  private static final String listado2 = "SELECT ID_Movimiento, Fecha, Detalle, Importe, ID_TIPO_M FROM movimientos where N_Cuenta =";
  
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
        movimientosRs.setImporte(rs.getDouble("Importe"));
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
        movimientosRs.setImporte(rs.getDouble("Importe"));
        movimientosRs.setID_Tipo(rs.getInt("ID_TIPO_M"));
        lista.add(movimientosRs);
      } 
      cn.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return lista;
  }
}
