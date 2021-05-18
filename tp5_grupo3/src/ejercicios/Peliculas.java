package ejercicios;

public class Peliculas {
	public int id=1;
	public String nombre;
	public String genero;
	
	public Peliculas(String nombre, String genero) {
		this.id = id+1;
		this.nombre = nombre;
		this.genero = genero;
	}

	public Peliculas() {
		this.id = id+1;
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
	//toString()
	@Override
	public String toString() {
		return  id + "nombre=" + nombre + ", genero=" + genero;
	}	
}
