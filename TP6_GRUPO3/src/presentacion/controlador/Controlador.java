package presentacion.controlador;

import java.awt.event.ActionEvent;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersonas;
import presentacion.vista.VentanaPrincipal;

public class Controlador {

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersonas pnlAgregarPersonas;
	private PersonaNegocio pNeg;
	
	//constructor
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg)
	{
			
				this.ventanaPrincipal = vista;
				this.pNeg = pNeg;
				
				this.pnlAgregarPersonas = new PanelAgregarPersonas();
				
				this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
				
				this.pnlAgregarPersonas.getBtnAceptar().addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
	}

	private void EventoClickBoton_AgregarPesona_PanelAgregarPersonas(ActionEvent a) {
		
		String dni = this.pnlAgregarPersonas.getTxtDni().getText();
		String nombre = this.pnlAgregarPersonas.getTxtNombre().getText();
		String apellido = this.pnlAgregarPersonas.getTxtApellido().getText();
		Persona nuevaPersona = new Persona(dni, nombre, apellido);
		
		//pregunto si existe el dni
		if(pNeg.chequearDni(dni) == false) {
			boolean estado = pNeg.insert(nuevaPersona);
			String mensaje;
			
			//pregunto si se agregó correctamente
			if(estado==true)
			{
				mensaje="Persona agregada con exito";
				this.pnlAgregarPersonas.getTxtNombre().setText("");
				this.pnlAgregarPersonas.getTxtApellido().setText("");
				this.pnlAgregarPersonas.getTxtDni().setText("");
			}
			else
				mensaje="Persona no agregada, complete todos los campos";
			
			this.pnlAgregarPersonas.mostrarMensaje(mensaje);
			}
		else {
			String mensaje="Dni ya existente en base de datos";
			
			this.pnlAgregarPersonas.mostrarMensaje(mensaje);
		}
	}

	private void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlAgregarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);;
	}
}
