package ejercicios;

public class Peliculas implements java.lang.Comparable<Peliculas>{
	public int id;
	private String nombre;
	private categoria genero;
	
	static int cont=0;

	// Contructor
	public Peliculas() {
		this.id = cont ++;
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

	public categoria getGenero() {
		return genero;
	}

	public void setGenero(categoria genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return  id + " Nombre: " + nombre + ", Genero: " + genero.getCategoria();
	}
	
	@Override
	public int compareTo (Peliculas peli) {
		if(peli.getNombre().compareTo(this.nombre) < 0){
			return -1;
		}
		else return 1;
	}
}
