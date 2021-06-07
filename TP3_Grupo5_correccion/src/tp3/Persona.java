package tp3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Persona {
	private String ruta;

	//constructor
		public Persona () {
		}
		
		public String getRuta() {
			return ruta;
		}

		public void setRuta(String ruta) {
			this.ruta = ruta;
		}

		public void leer(TreeSet<String> Listado){
			
			//List<Integer> listaHashes = new ArrayList<>();
			//List<String> listaRegistrosSinRepetir = new ArrayList<>();
			// Crea un lista para acomodar todo 
			TreeSet<String> ListaRegistrosPorApellido = new TreeSet<String>();
			
			FileReader entrada;
			
			try{
				entrada= new FileReader(ruta);
				BufferedReader miBuffer = new BufferedReader(entrada);
				String linea="";
				while(linea != null){
					
					int hashDeLaLineaActual = linea.hashCode();
					
					linea=miBuffer.readLine();
					if (linea != null) {
						Listado.add(linea);
						
						//acomodo los datos para tener Apellido primero

	                    String[] parts = linea.split("-");

	                    String nombre = parts[0];

	                    String apellido = parts[1];

	                    String dni = parts[2];
	                    
	                    //ListaRegistrosPorApellido.add(apellido+"-"+ nombre +"-"+ dni);
	                    
	                    
	                     //GRAUS
	                    if(Dni.validarDni(dni)) {
	                    	ListaRegistrosPorApellido.add(apellido+"-"+ nombre +"-"+ dni);
							System.out.println("Se agrego al usuario: " + apellido + " " + nombre+ " ");
						}
	                    else {
	                    	System.out.println("NO se agrego al usuario: " + apellido + " " + nombre+ " ");
	                    }
	                    
						
					}
				}
				// este for lista las personas por apellido
				for(String elementos : ListaRegistrosPorApellido){
					System.out.println(elementos);
				}
				
				
				miBuffer.close();
				entrada.close();
			} catch (IOException e){
				System.out.println("archivo no encontrado");
			}
		}
		
		/*public void mostrar(TreeSet<String> Listado){
			
			java.util.Iterator<String> iterator = Listado.iterator();
			while (iterator.hasNext())
			    System.out.println(iterator.next());
		}*/
		
}
