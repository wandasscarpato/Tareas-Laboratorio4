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
	
	private String Nombre;
	private String Apellido;
	private int Dni;
	
	public Persona() {
		Nombre = "Sin Nombre";
		Apellido= "Sin Apellido";
		Dni=11111111; 
	}
	
	public Persona(String Nombre, String Apellido, int Dni) {
		this.Nombre=Nombre;
		this.Apellido=Apellido;
		this.Dni=Dni;
	}
	
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public int getDni() {
		return Dni;
	}

	public void setDni(int dni) {
		Dni = dni;
	}

	@Override
	public String toString() {
		return "Nombre:" + Nombre + ", Apellido:" + Apellido + ", Dni:" + Dni;
	}

}
