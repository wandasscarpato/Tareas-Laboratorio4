package tp3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class Archivo {

	private String ruta;
	
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
				
				linea=miBuffer.readLine();
				if (linea != null) {
					Listado.add(linea);
					
					//acomodo los datos para tener Apellido primero

                    String[] parts = linea.split("-");

                    String nombre = parts[0];

                    String apellido = parts[1];

                    String dni = parts[2];
                    
                     //GRAUS
              try {
                    if(Dni.validarDni(dni)) {
                    	ListaRegistrosPorApellido.add(apellido+"-"+ nombre +"-"+ dni);
						System.out.println("Se agrego al usuario: " + apellido + " " + nombre+ " ");
					}
              }
              catch(Exception e){
					
				}
                    
					
				}
			}
			// este for lista las personas por apellido
			for(String elementos : ListaRegistrosPorApellido){
				System.out.println(elementos);
			}
			
			
			miBuffer.close();
			entrada.close();
			
			//lee la lista creada en el punto 2 y pasa la información a un archivo llamado Resultado.txt
			resultado(ListaRegistrosPorApellido);
			
		} catch (IOException e){
			System.out.println("archivo no encontrado");
		}
	}
	
	public boolean CrearArchivo(String ruta){
		FileWriter Esc;
		try {
			Esc = new FileWriter(ruta,true);
			Esc.write("");
			Esc.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public void EscribirArchivoLista(String ruta, TreeSet<String> lista){
		try {
			FileWriter Entra = new FileWriter(ruta, false);
			BufferedWriter mibuffer = new BufferedWriter(Entra);		
			
			for (String elemento : lista) {
				mibuffer.write(elemento + "\n");
			}
			
			mibuffer.close();
			Entra.close();
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void resultado(TreeSet<String> l ) {
		
		Archivo ar = new Archivo();
		ar.CrearArchivo("Resultado.txt");
		
		
		ar.EscribirArchivoLista("Resultado.txt", l);
		
		
	}
	
	/*public void mostrar(TreeSet<String> Listado){
	
	java.util.Iterator<String> iterator = Listado.iterator();
	while (iterator.hasNext())
	    System.out.println(iterator.next());
}*/
}
