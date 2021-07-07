package negocio;

import entidad.provincia;
import java.util.ArrayList;

public interface provinciasNegocio {
  ArrayList<provincia> listarProvincias();
  
  String buscarNombreprovincia(int paramInt);
}
