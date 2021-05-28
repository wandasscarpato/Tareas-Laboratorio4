package presentacion.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelAgregarPersonas extends JPanel {
	
	//atributos
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnAceptar;
	
	//constructor
	public PanelAgregarPersonas() {
		super();
		initialize();
	}
	
	//getters and setters
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	
	private void initialize() 
	{
			
			setLayout(new BorderLayout(0, 0));
			
			JPanel panel = new JPanel();
			add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblApellido = new JLabel("Apellido");
			lblApellido.setBounds(100, 70, 46, 14);
			panel.add(lblApellido);
			
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(100, 30, 46, 14);
			panel.add(lblNombre);
			
			JLabel lblDni = new JLabel("Dni");
			lblDni.setBounds(100, 110, 46, 14);
			panel.add(lblDni);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(222, 27, 110, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			txtNombre.addKeyListener(klSoloLetras);
			
			txtApellido = new JTextField();
			txtApellido.setBounds(222, 67, 110, 20);
			panel.add(txtApellido);
			txtApellido.setColumns(10);
			txtApellido.addKeyListener(klSoloLetras);
			
			txtDni = new JTextField();
			txtDni.setText("");
			txtDni.setBounds(222, 107, 110, 20);
			panel.add(txtDni);
			txtDni.setColumns(10);
			txtDni.addKeyListener(klSoloNumeros);
			
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(100, 150, 110, 28);
			panel.add(btnAceptar);
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	//Eventos KeyListener
	KeyListener klSoloLetras = new KeyListener() {
		@Override
		public void keyTyped(KeyEvent e) {
			if (!Character.isLetter(e.getKeyChar())
	                && (e.getKeyChar() != '\b')) {
				e.consume();
				mostrarMensaje("Ingrese solo letras");
			} 		
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	KeyListener klSoloNumeros = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			char caracter = e.getKeyChar();
			if (!((caracter >= '0') && (caracter <= '9'))
	                && (caracter != '\b')) {
				e.consume();
				mostrarMensaje("Ingrese solo números");
			} 		
		}


		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};
}
