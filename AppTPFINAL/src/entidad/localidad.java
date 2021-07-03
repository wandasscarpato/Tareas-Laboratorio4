package entidad;

public class localidad {
	
	private int ID;
	private String Localidad;
	
	public localidad() {
		
	}
	
	
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getLocalidad() {
		return Localidad;
	}


	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}


	@Override
	public String toString() {
		return "localidad [ID=" + ID + ", Localidad=" + Localidad + "]";
	}
	
	
	
	
}
