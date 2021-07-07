package negocioImplement;


import java.util.ArrayList;
import java.util.List;

import dao.cuentaDao;
import daoImplement.cuentaDaoImplement;
import entidad.AceptarCuenta;
import entidad.cuenta;
import negocio.cuentaNegocio;

public class cuentaNegocioImplement implements cuentaNegocio {
	
	
	cuentaDao cdao = new cuentaDaoImplement();

	public boolean insert(cuenta cuenta) {
			
			boolean estado=false;
			if(cuenta.getCBU()>0)
			{
				cuenta.setEstado(true);
				estado=cdao.insert(cuenta);
				estado = true;
				
				System.out.print(" PASA LA VALIDACION");
			}
			return estado;
		}
	
	public boolean verificar(cuenta cuenta) {
		boolean crear;
		
		System.out.print(" ENRTRA A VERIFICAR DEL NEGOCIO");
		
		int cant = cdao.verificar(cuenta);
		
		if(cant < 3) {
			//se puede crear la cuenta
			crear = true;
		}
		else 
		{
			//no se puede crear la cuenta
			crear = false;
		}
		
		return crear;
		
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

	public double ObtenerSaldo(cuenta cuenta_m) {
		return cdao.ObtenerSaldo(cuenta_m);
	}
	
	public boolean modificarSaldo(cuenta cuenta_m) {
		return cdao.modificarSaldo(cuenta_m);
	}

	@Override
	public ArrayList<AceptarCuenta> listarAceptarCuentas() {
		return (ArrayList<AceptarCuenta>) cdao.ListarAceptarCuenta();
	}
}

	
	

