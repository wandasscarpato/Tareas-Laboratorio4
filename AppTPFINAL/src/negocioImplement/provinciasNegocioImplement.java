package negocioImplement;

import dao.provinciasDao;
import daoImplement.ProvinciasDaoImplement;
import entidad.provincia;
import java.util.ArrayList;
import negocio.provinciasNegocio;

public class provinciasNegocioImplement implements provinciasNegocio {
  provinciasDao pdao = (provinciasDao)new ProvinciasDaoImplement();
  
  public ArrayList<provincia> listarProvincias() {
    return this.pdao.listarProvincias();
  }
  
  public String buscarNombreprovincia(int id) {
    return this.pdao.buscarNombreprovincia(id);
  }
}
