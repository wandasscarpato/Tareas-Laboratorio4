package entidad;

public class cliente {
	
	private int DNI;
	private int CUIL;
	private String Nombre;
	private String Apellido;
	private String Sexo;
	private String Nacimiento;
	private String Direccion;
	private int ID_Localodad;
	private int ID_Provincia;
	private String Email;
	private int Telefono;
	private boolean estado;
	
	public cliente() {
		
	}
	
	public cliente(int DNI,int CUIL,String Nombre,String Apellido,String Sexo, String Nacimiento, String Direccion, int ID_Localodad,int ID_Provincia, String Email, int Telefono, boolean estado) {
        this.DNI = DNI;
        this.CUIL = CUIL;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Sexo = Sexo;
        this.Nacimiento = Nacimiento;
        this.Direccion = Direccion;
        this.ID_Localodad = ID_Localodad;
        this.ID_Provincia = ID_Provincia;
        this.Email = Email;
        this.Telefono = Telefono;
        this.estado = estado;
    }


	public int getDNI() {
		return DNI;
	}


	public void setDNI(int dNI) {
		DNI = dNI;
	}


	public int getCUIL() {
		return CUIL;
	}


	public void setCUIL(int cUIL) {
		CUIL = cUIL;
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


	public String getSexo() {
		return Sexo;
	}


	public void setSexo(String sexo) {
		Sexo = sexo;
	}


	public String getNacimiento() {
		return Nacimiento;
	}


	public void setNacimiento(String nacimiento) {
		Nacimiento = nacimiento;
	}


	public String getDireccion() {
		return Direccion;
	}


	public void setDireccion(String direccion) {
		Direccion = direccion;
	}


	public int getID_Localodad() {
		return ID_Localodad;
	}


	public void setID_Localodad(int iD_Localodad) {
		ID_Localodad = iD_Localodad;
	}


	public int getID_Provincia() {
		return ID_Provincia;
	}


	public void setID_Provincia(int iD_Provincia) {
		ID_Provincia = iD_Provincia;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public int getTelefono() {
		return Telefono;
	}


	public void setTelefono(int telefono) {
		Telefono = telefono;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
	

}
