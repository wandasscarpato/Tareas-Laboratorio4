package entidad;

public class AceptarCuenta {
    private int DNI;
    private String Tipo;
    //Cambiar en un futuro a Int
    private boolean Estado;
    private int N_Cuenta;

    public AceptarCuenta(){}

    public AceptarCuenta(int DNI,String Tipo,boolean Estado,int N_Cuenta) {
        this.DNI = DNI;
        this.Tipo = Tipo;
        this.Estado= Estado;
        this.N_Cuenta= N_Cuenta;
    }

    public int getN_Cuenta() {
		return N_Cuenta;
	}

	public void setN_Cuenta(int n_Cuenta) {
		this.N_Cuenta = n_Cuenta;
	}

	public int getDNI() {
        return DNI;
    }

    public void setDNI(int dNI) {
        this.DNI = dNI;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        this.Tipo = tipo;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        this.Estado = estado;
    }

	@Override
	public String toString() {
		return "AceptarCuenta [DNI=" + DNI + ", Tipo=" + Tipo + ", Estado=" + Estado + ", N_Cuenta=" + N_Cuenta + "]";
	}

}