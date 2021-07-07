package negocio;

import entidad.localidad;
import java.util.ArrayList;

public interface localidadesNegocio {
  ArrayList<localidad> listarLocalidades();
  
  String buscarNombreLocalidad(int paramInt);
}
