package entidad;
import java.util.Date;

public class cuenta {
	
	private int N_Cuenta;
	private int ID_Tipo;
	private Date Fecha_cracion = new Date(); 
	private int CBU;
	private double Saldo;
	private int DNI;
	private boolean estado;
	
	
	
	public cuenta(int n_Cuenta, int iD_Tipo, Date fecha_cracion, int cBU, double saldo, int dNI, boolean estado) {
		super();
		N_Cuenta = n_Cuenta;
		ID_Tipo = iD_Tipo;
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



	public int getID_Tipo() {
		return ID_Tipo;
	}



	public void setID_Tipo(int iD_Tipo) {
		ID_Tipo = iD_Tipo;
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



	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
	

}
