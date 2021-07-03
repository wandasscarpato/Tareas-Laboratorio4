package entidad;

public class provincia {

	private int ID;
	private String Provincia;
	
	public provincia() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	@Override
	public String toString() {
		return "provincia [ID=" + ID + ", Provincia=" + Provincia + "]";
	}
	
	
	
}
