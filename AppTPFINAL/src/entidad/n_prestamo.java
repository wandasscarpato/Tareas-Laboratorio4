package entidad;

public class n_prestamo {
	private int N_Prestamo;
	private int DNI;
	private String Importe_intereses;
	private String Importe_pedido;
	private int Plazo;
	private String MontoxMes;
	private int Cuotas;
	private int N_cuentaADepositar;
	private boolean estado;
	
	public n_prestamo(){}

	public n_prestamo(int n_Prestamo, int dNI, String importe_intereses, String importe_pedido, int plazo,
			String montoxMes, int cuotas, int n_cuentaADepositar, boolean estado) {
		this.N_Prestamo = n_Prestamo;
		this.DNI = dNI;
		this.Importe_intereses = importe_intereses;
		this.Importe_pedido = importe_pedido;
		this.Plazo = plazo;
		this.MontoxMes = montoxMes;
		this.Cuotas = cuotas;
		this.N_cuentaADepositar = n_cuentaADepositar;
		this.estado = estado;
	}

	public int getN_Prestamo() {
		return N_Prestamo;
	}

	public void setN_Prestamo(int n_Prestamo) {
		N_Prestamo = n_Prestamo;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public String getImporte_intereses() {
		return Importe_intereses;
	}

	public void setImporte_intereses(String importe_intereses) {
		Importe_intereses = importe_intereses;
	}

	public String getImporte_pedido() {
		return Importe_pedido;
	}

	public void setImporte_pedido(String importe_pedido) {
		Importe_pedido = importe_pedido;
	}

	public int getPlazo() {
		return Plazo;
	}

	public void setPlazo(int plazo) {
		Plazo = plazo;
	}

	public String getMontoxMes() {
		return MontoxMes;
	}

	public void setMontoxMes(String montoxMes) {
		MontoxMes = montoxMes;
	}

	public int getCuotas() {
		return Cuotas;
	}

	public void setCuotas(int cuotas) {
		Cuotas = cuotas;
	}

	public int getN_cuentaADepositar() {
		return N_cuentaADepositar;
	}

	public void setN_cuentaADepositar(int n_cuentaADepositar) {
		N_cuentaADepositar = n_cuentaADepositar;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "n_prestamo [N_Prestamo=" + N_Prestamo + ", DNI=" + DNI + ", Importe_intereses=" + Importe_intereses
				+ ", Importe_pedido=" + Importe_pedido + ", Plazo=" + Plazo + ", MontoxMes=" + MontoxMes + ", Cuotas="
				+ Cuotas + ", N_cuentaADepositar=" + N_cuentaADepositar + ", estado=" + estado + "]";
	}
}
