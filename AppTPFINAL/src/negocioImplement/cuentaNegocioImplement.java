package negocioImplement;


import java.util.List;

import dao.cuentaDao;
import daoImplement.cuentaDaoImplement;
import entidad.cuenta;
import negocio.cuentaNegocio;

public class cuentaNegocioImplement implements cuentaNegocio {
	
	
	cuentaDao cdao = new cuentaDaoImplement();

	public boolean insert(cuenta cuenta) {
			
			boolean estado=false;
			if(cuenta.getN_Cuenta()>0 && cuenta.getCBU()>0)
			{
				cuenta.setEstado(true);
				estado=cdao.insert(cuenta);
				estado = true;
			}
			return estado;
		}
	
	public List<cuenta> listarCuentas(){
		return (List<cuenta>) cdao.readAll();
	}
	
	public List<cuenta> ObtenerxDni(String dni){
		return cdao.ObtenerxDni(dni);
	}
	
	public boolean eliminar (cuenta cue) {
		return cdao.eliminar(cue);
	}
	
	public boolean modificarEstado (cuenta cue) {
		return cdao.modificarEstado(cue);
	}
	public boolean modificarTipo (cuenta cue) {
		return cdao.modificarTipo(cue);
	}
	
}
