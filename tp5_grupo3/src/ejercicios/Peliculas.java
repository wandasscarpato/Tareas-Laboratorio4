package ejercicios;

public class Peliculas {
	public int id;
	public String nombre;
	public String genero;
	
	static int cont=0;
	
	public Peliculas(String nombre, String genero) {
		cont++;

		this.id = cont;
		this.nombre = nombre;
		this.genero = genero;
	}

	public Peliculas() {
		this.id = cont;
		this.nombre = "no definido";
		this.genero = "no especificado";
	}

	//Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	//métodos
	public String devuelveProximoId(){
		return Integer.toString(cont+1);
	}

	//toString()
	@Override
	public String toString() {
		return  id + "nombre=" + nombre + ", genero=" + genero;
	}	
}
