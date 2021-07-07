package negocioImplement;

import dao.movimientosDao;
import daoImplement.movimientosDaoImplement;
import entidad.movimientos;
import java.util.List;
import negocio.movimientosNegocio;

public class movimientosNegocioImplement implements movimientosNegocio {
  movimientosDao mdao = (movimientosDao)new movimientosDaoImplement();
  
  public List<movimientos> listarMovimientos() {
    return this.mdao.readAll();
  }
  
  public List<movimientos> ObtenerxN_Cuenta(int n_cuenta) {
    return this.mdao.ObtenerxN_Cuenta(n_cuenta);
  }
}
