package negocioImplement;


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
		}
		return estado;
	}

	
}
