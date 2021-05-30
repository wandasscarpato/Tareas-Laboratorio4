package presentacion.vista;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.event.ListSelectionListener;

import entidad.Persona;

import javax.swing.event.ListSelectionEvent;

public class PanelModificarPersonas extends JPanel {

	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnModificar;
	private String DniSeleccionado;
	private JList<Persona> list;
	
	private DefaultListModel<Persona> modelPersonas;
	private JScrollPane scrollPane;
	
	public PanelModificarPersonas() {
		super();
		initialize();
	}
	
	// GETS
	public JTextField getTxtDni() {
		return txtDni;
	}
	 public JTextField getTxtNombre() {
		 return txtNombre;	
	}
	 public JTextField getTxtApellido() {
		return txtApellido;
	}
	// boton
	public JButton getBtnModificar() {
		return btnModificar;
	}
	// list
	public String getDniSeleccionado() {
		return DniSeleccionado;
	}
	public DefaultListModel<Persona> getDefaultListModel(){
		return modelPersonas;
	}
	// SETS
	public void setTxtDni(String txtDni) {
		this.txtDni.setText(txtDni);
	}
	 public void setTxtNombre(String txtNombre) {
		 this.txtNombre.setText(txtNombre);	
	}
	 public void setTxtApellido(String txtApellido) {
		this.txtApellido.setText(txtApellido);
	}
	
	private void initialize() {
		
		setLayout(null);
		modelPersonas = new DefaultListModel<Persona>();
		
		list =new JList<Persona>(modelPersonas);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(list.getSelectedIndex() != -1) {
					Persona persona = (Persona) modelPersonas.getElementAt(list.getSelectedIndex());
					DniSeleccionado = persona.getDni();
					setTxtApellido(persona.getApellido());
					setTxtNombre(persona.getNombre());
					setTxtDni(persona.getDni());
				}
			}
		});
		
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 4;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 2;
		setLayout(null);
		
		scrollPane = new JScrollPane(list);
		scrollPane.setBounds(51, 0, 343, 177);
		add(scrollPane);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(51, 189, 114, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(170, 189, 63, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(238, 189, 73, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(317, 188, 75, 23);
		add(btnModificar);
	
	}
	public DefaultListModel<Persona> getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public void llenarTabla(List<Persona> personasEnTabla) {
		this.modelPersonas.clear();
		for (int i=0; i< personasEnTabla.size(); i++)
		{
			this.getModelPersonas().add(i, personasEnTabla.get(i));
		}
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
}
