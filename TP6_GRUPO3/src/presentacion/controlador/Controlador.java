package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JList;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersonas;
import presentacion.vista.PanelEliminarPersonas;
import presentacion.vista.PanelModificarPersonas;
import presentacion.vista.VentanaPrincipal;

public class Controlador {

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersonas pnlAgregarPersonas;
	private PanelModificarPersonas pnlModificarPersonas;
	private PanelEliminarPersonas pnlEliminarPersonas;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personasEnTabla;
	
	//constructor
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg)
	{
			
				this.ventanaPrincipal = vista;
				this.pNeg = pNeg;
				
				this.pnlAgregarPersonas = new PanelAgregarPersonas();
				this.pnlModificarPersonas = new PanelModificarPersonas();
				this.pnlEliminarPersonas = new PanelEliminarPersonas();
				
				this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
				this.ventanaPrincipal.getMenuModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));
				this.ventanaPrincipal.getMenuEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
				
				this.pnlAgregarPersonas.getBtnAceptar().addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
				this.pnlModificarPersonas.getBtnModificar().addActionListener(a->EventoClickBoton_ModificarPesona_PanelModificarPersonas(a));
				this.pnlEliminarPersonas.getBtnEliminar().addActionListener(a->EventoClickBoton_EliminarPersona_PanelEliminarPersonas(a));

	}
	
	private void EventoClickBoton_ModificarPesona_PanelModificarPersonas(ActionEvent a) {
		String dniNuevo = this.pnlModificarPersonas.getTxtDni().getText();
		String nombreNuevo = this.pnlModificarPersonas.getTxtNombre().getText();
		String apellidoNuevo = this.pnlModificarPersonas.getTxtApellido().getText();
		String dniViejo = this.pnlModificarPersonas.getDniSeleccionado();
		Persona personaNueva = new Persona(dniNuevo,nombreNuevo,apellidoNuevo);
		Persona personaVieja = new Persona(dniViejo,"","");
	
		int estado = pNeg.modify(personaVieja, personaNueva);
		String mensaje;
		switch (estado) {
			case -1:
				mensaje="Persona no modificada. El nuevo DNI ya existe.";
			break;
			case -2:
				mensaje="Persona no modificada.";
			break;
			default:
				mensaje="Persona modificada con exito";
				this.pnlModificarPersonas.getTxtDni().setText("");
				this.pnlModificarPersonas.getTxtNombre().setText("");
				this.pnlModificarPersonas.getTxtApellido().setText("");
			break;
		}
		this.pnlModificarPersonas.mostrarMensaje(mensaje);
		this.personasEnTabla= (ArrayList<Persona>) pNeg.listarPersonas();
		this.pnlModificarPersonas.llenarTabla(this.personasEnTabla);
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
	
	public void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		this.personasEnTabla= (ArrayList<Persona>) pNeg.listarPersonas();
		this.pnlModificarPersonas.llenarTabla(this.personasEnTabla);
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
