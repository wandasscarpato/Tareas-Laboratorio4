package entidad;
import java.util.Date;

public class cuenta {
	
	private int N_Cuenta;
	private String Tipo;
	private Date Fecha_cracion = new Date(); 
	private int CBU;
	private double Saldo;
	private int DNI;
	private int estado;
	
	public cuenta() {
		// TODO Auto-generated constructor stub
	}
	
	public cuenta(int n_Cuenta, String tipo, Date fecha_cracion, int cBU, double saldo, int dNI, int estado) {
		super();
		N_Cuenta = n_Cuenta;
		Tipo = tipo;
		Fecha_cracion = fecha_cracion;
		CBU = cBU;
		Saldo = saldo;
		DNI = dNI;
		this.estado = estado;
	}



	public int getN_Cuenta() {
		return N_Cuenta;
	}



	public void setN_Cuenta(int n_Cuenta) {
		N_Cuenta = n_Cuenta;
	}


	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}


	public Date getFecha_cracion() {
		return Fecha_cracion;
	}


	public void setFecha_cracion(Date fecha_cracion) {
		Fecha_cracion = fecha_cracion;
	}



	public int getCBU() {
		return CBU;
	}



	public void setCBU(int cBU) {
		CBU = cBU;
	}



	public double getSaldo() {
		return Saldo;
	}



	public void setSaldo(double saldo) {
		Saldo = saldo;
	}



	public int getDNI() {
		return DNI;
	}



	public void setDNI(int dNI) {
		DNI = dNI;
	}



	public int getEstado() {
		return estado;
	}



	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	

}
