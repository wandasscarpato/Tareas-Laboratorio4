package ejercicios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEj1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtFechaNac;
	private JLabel lblLosDatosIngresados;
	private JLabel lblNewLabel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEj1 frame = new VentanaEj1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public VentanaEj1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 740, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(190, 35, 103, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(190, 74, 117, 14);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(190, 105, 110, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nac.");
		lblFechaNacimiento.setBounds(190, 141, 110, 14);
		contentPane.add(lblFechaNacimiento);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(338, 32, 192, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(338, 71, 192, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(338, 102, 192, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setBackground(Color.WHITE);
		txtFechaNac.setBounds(338, 138, 192, 20);
		contentPane.add(txtFechaNac);
		txtFechaNac.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(219, 224, 495, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnMandar = new JButton("Mandar");
		btnMandar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				boolean a=true;
				if(txtFechaNac.getText().equals("")) {
					txtFechaNac.setBackground(Color.RED);
					a=false;
				}else{
					txtFechaNac.setBackground(Color.WHITE);
				};
				if(txtNombre.getText().equals("")) {
					txtNombre.setBackground(Color.RED);
					a=false;
				}else {
					txtNombre.setBackground(Color.WHITE);
				}
				if(txtApellido.getText().equals("")) {
					txtApellido.setBackground(Color.RED);
					a=false;
				}else {
					txtApellido.setBackground(Color.WHITE);
				}
				if(txtTelefono.getText().equals("")) {
					txtTelefono.setBackground(Color.RED);
					a=false;
				}else {
					txtTelefono.setBackground(Color.WHITE);
				}
				
				if(a) {
				lblNewLabel.setText("Nombre: "+txtNombre.getText()+". Apellido: "+txtApellido.getText()+". Telefono: "+txtTelefono.getText()+" . Fecha nac.: "+txtFechaNac.getText());

				txtNombre.setText("");
				txtApellido.setText("");
				txtTelefono.setText("");
				txtFechaNac.setText("");

				}
			}
			
		});
		btnMandar.setBackground(SystemColor.activeCaption);
		btnMandar.setForeground(SystemColor.desktop);
		btnMandar.setBounds(383, 180, 117, 23);
		contentPane.add(btnMandar);
		
		lblLosDatosIngresados = new JLabel("Los datos ingresados fueron:");
		lblLosDatosIngresados.setBounds(17, 223, 192, 28);
		contentPane.add(lblLosDatosIngresados);
		
	}

	
}
