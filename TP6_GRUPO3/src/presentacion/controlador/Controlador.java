package presentacion.controlador;

import java.awt.event.ActionEvent;

import javax.swing.JList;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersonas;
import presentacion.vista.PanelEliminarPersonas;
import presentacion.vista.VentanaPrincipal;

public class Controlador {

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersonas pnlAgregarPersonas;
	private PanelEliminarPersonas pnlEliminarPersonas;
	private PersonaNegocio pNeg;
	
	//constructor
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg)
	{
			
				this.ventanaPrincipal = vista;
				this.pNeg = pNeg;
				
				this.pnlAgregarPersonas = new PanelAgregarPersonas();
				this.pnlEliminarPersonas = new PanelEliminarPersonas();
				
				this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
				this.ventanaPrincipal.getMenuEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
				
				this.pnlAgregarPersonas.getBtnAceptar().addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
				this.pnlEliminarPersonas.getBtnEliminar().addActionListener(a->EventoClickBoton_EliminarPersona_PanelEliminarPersonas(a));
				
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
	
	private void EventoClickBoton_EliminarPersona_PanelEliminarPersonas(ActionEvent a) {
		
		String mensaje;
		
		if(!(this.pnlEliminarPersonas.getJlist().isSelectionEmpty())){
			
			/// OBTENER EL VALOR QUE ESTA SELECCIONADO EN LA TABLA
			String seleccion = this.pnlEliminarPersonas.getJlist().getSelectedValue().toString();
			String DNI = seleccion.substring(seleccion.lastIndexOf(' ') + 1).trim();
			Persona eliminarPersona = new Persona(DNI);
		
			boolean estado = pNeg.delete(eliminarPersona);
				
			//pregunto si se elimino correctamente
			if(estado==true){
				mensaje="Persona eliminada con exito";
				this.pnlEliminarPersonas.mostrarMensaje(mensaje);
				// VOLVER A CARGAR EL PANEL
				CargarListadoParaEliminar(this.pnlEliminarPersonas.getJlist());
			} else {
				
				mensaje="Persona no eliminada.";
				this.pnlEliminarPersonas.mostrarMensaje(mensaje);
				
			}
		} else {
			mensaje="Por favor seleccione una persona primero.";
			this.pnlEliminarPersonas.mostrarMensaje(mensaje);
		}
		
	}

	private void CargarListadoParaEliminar(JList list) {
		
		pNeg.listado(list);
		
	}

	private void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlAgregarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	private void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersonas);
		//Cargar listado cuando lo muestro
		CargarListadoParaEliminar(this.pnlEliminarPersonas.getJlist());
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);;
	}
}
