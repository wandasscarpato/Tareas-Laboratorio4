package negocioImplement;

import dao.clienteDao;
import daoImplement.clienteDaoImplement;
import entidad.cliente;
import negocio.clienteNegocio;

public class clienteNegocioImplement implements clienteNegocio{

	
	clienteDao cdao = new clienteDaoImplement();
		
	
		public boolean delete(int cliente_a_eliminar) {
			boolean estado=false;
			if(cliente_a_eliminar>0 )//También se puede preguntar si existe ese ID 
			{
				estado=cdao.delete(cliente_a_eliminar);
			}
			return estado;
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
