package entidad;

import java.util.Date;

public class movimientos {
  private int ID_Movimiento;
  
  private Date Fecha = new Date();
  
  private String Detalle;
  
  private float Importe;
  
  private int ID_Tipo;
  
  private int N_Cuenta;
  
  public movimientos() {}
  
  public movimientos(int id_movimiento, Date fecha, String detalle, float importe, int tipo, int n_cuenta) {
    this.ID_Movimiento = id_movimiento;
    this.Fecha = fecha;
    this.Detalle = detalle;
    this.Importe = importe;
    this.ID_Tipo = tipo;
    this.N_Cuenta = n_cuenta;
  }
  
  public int getID_Movimiento() {
    return this.ID_Movimiento;
  }
  
  public void setID_Movimiento(int iD_Movimiento) {
    this.ID_Movimiento = iD_Movimiento;
  }
  
  public Date getFecha() {
    return this.Fecha;
  }
  
  public void setFecha(Date fecha) {
    this.Fecha = fecha;
  }
  
  public String getDetalle() {
    return this.Detalle;
  }
  
  public void setDetalle(String detalle) {
    this.Detalle = detalle;
  }
  
  public float getImporte() {
    return this.Importe;
  }
  
  public void setImporte(float importe) {
    this.Importe = importe;
  }
  
  public int getID_Tipo() {
    return this.ID_Tipo;
  }
  
  public void setID_Tipo(int iD_Tipo) {
    this.ID_Tipo = iD_Tipo;
  }
  
  public int getN_Cuenta() {
    return this.N_Cuenta;
  }
  
  public void setN_Cuenta(int n_Cuenta) {
    this.N_Cuenta = n_Cuenta;
  }
}
