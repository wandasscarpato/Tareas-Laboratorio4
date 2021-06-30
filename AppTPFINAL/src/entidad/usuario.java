package entidad;

public class usuario {
	private String Usuario;
	private int DNI;
	private String Pass;
	
	public usuario()
	{
		
	}

	public usuario(String Usuario, int DNI, String Pass) {
		super();
		this.Usuario = Usuario;
		this.DNI = DNI;
		this.Pass = Pass;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	@Override
	public String toString() {
		return "Usuario [Usuario=" + Usuario + ", DNI=" + DNI + ", Pass=" + Pass + "]";
	}
}
