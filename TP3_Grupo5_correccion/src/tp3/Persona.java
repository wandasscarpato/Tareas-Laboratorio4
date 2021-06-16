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
					}
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
