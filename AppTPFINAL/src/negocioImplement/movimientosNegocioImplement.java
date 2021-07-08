package negocioImplement;

import dao.movimientosDao;
import daoImplement.movimientosDaoImplement;
import entidad.movimientos;
import java.util.List;
import negocio.movimientosNegocio;

public class movimientosNegocioImplement implements movimientosNegocio {
  movimientosDao mdao = new movimientosDaoImplement();
  
  public List<movimientos> listarMovimientos() {
    return this.mdao.readAll();
  }
  public boolean insertAltaPrestamo(movimientos movimiento) {
		
		boolean estado=false;
		estado=mdao.insertAltaPrestamo(movimiento);
		return estado;
	} 
  
  public List<movimientos> ObtenerxN_Cuenta(int n_cuenta) {
    return this.mdao.ObtenerxN_Cuenta(n_cuenta);
  }
  
  public boolean InsertMovimientos(movimientos movimiento) {
	return mdao.InsertMovimientos(movimiento);  
  }
  
}
