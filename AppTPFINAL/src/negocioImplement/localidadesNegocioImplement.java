package negocioImplement;

import dao.localidadesDao;
import daoImplement.localidadesDaoImplement;
import entidad.localidad;
import java.util.ArrayList;
import negocio.localidadesNegocio;

public class localidadesNegocioImplement implements localidadesNegocio {
  localidadesDao ldao = (localidadesDao)new localidadesDaoImplement();
  
  public ArrayList<localidad> listarLocalidades() {
    return this.ldao.listarLocalidades();
  }
  
  public String buscarNombreLocalidad(int id) {
    return this.ldao.buscarNombreLocalidad(id);
  }
}
