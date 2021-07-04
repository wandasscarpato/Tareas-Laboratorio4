package negocioImplement;

import dao.clienteDao;
import daoImplement.clienteDaoImplement;
import entidad.cliente;
import negocio.clienteNegocio;

public class clienteNegocioImplement implements clienteNegocio{

	
	clienteDao cdao = new clienteDaoImplement();
		
	
		public boolean delete(int cliente_a_eliminar, boolean estadoC) {
			//boolean estado=false;
			boolean EstadoFunc;
		
				if(estadoC==true)
				{
					estadoC= false;
				}
				else 
				{
					estadoC=true;
				}
				
				
				EstadoFunc=cdao.delete(cliente_a_eliminar, estadoC);
			
			//return estado;
			return EstadoFunc;
	}
			
		
		
		
		//public boolean insert(cliente cliente) {
			// TODO Auto-generated method stub
			//return false;
		//}
		
		
		//public boolean delete(int cliente_a_eliminar) {
			// TODO Auto-generated method stub
		//	return false;
		//}
	
	
	
}
