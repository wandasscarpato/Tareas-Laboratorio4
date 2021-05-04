package ejercicios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.Box;
import java.awt.ScrollPane;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import java.awt.Panel;
import java.awt.Canvas;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class VentanaEj2 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtNota_1;
	private JTextField txtNota_2;
	private JTextField txtNota_3;
	private JTextField txtPromedio;
	private JTextField txtCondicion;
	JComboBox cbTPS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEj2 frame = new VentanaEj2();
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
	public VentanaEj2() {
		setTitle("Promedio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 393, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Notas del estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 252, 153);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNota_1 = new JLabel("Nota 1:");
		lblNota_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNota_1.setBounds(10, 34, 63, 14);
		panel.add(lblNota_1);
		
		JLabel lblNota_2 = new JLabel("Nota 2:");
		lblNota_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNota_2.setBounds(10, 59, 63, 14);
		panel.add(lblNota_2);
		
		JLabel lblNota_3 = new JLabel("Nota 3:");
		lblNota_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNota_3.setBounds(10, 84, 63, 14);
		panel.add(lblNota_3);
		
		JLabel lblTps = new JLabel("TPS");
		lblTps.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTps.setBounds(10, 109, 63, 14);
		panel.add(lblTps);
		
		txtNota_1 = new JTextField();
		txtNota_1.setBounds(87, 31, 127, 20);
		panel.add(txtNota_1);
		txtNota_1.setColumns(10);
		
		txtNota_2 = new JTextField();
		txtNota_2.setBounds(87, 56, 127, 20);
		panel.add(txtNota_2);
		txtNota_2.setColumns(10);
		
		txtNota_3 = new JTextField();
		txtNota_3.setBounds(87, 84, 127, 20);
		panel.add(txtNota_3);
		txtNota_3.setColumns(10);
		
		String[] msn = {"Aprobado","Desaprobado"};
		cbTPS = new JComboBox(msn);
		cbTPS.setBounds(83, 109, 131, 20);
		panel.add(cbTPS);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Notas del estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 175, 252, 93);
		contentPane.add(panel_1);
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPromedio.setBounds(10, 34, 63, 14);
		panel_1.add(lblPromedio);
		
		JLabel lblCondicion = new JLabel("Condicion:");
		lblCondicion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCondicion.setBounds(10, 59, 63, 14);
		panel_1.add(lblCondicion);
		
		txtPromedio = new JTextField();
		txtPromedio.setColumns(10);
		txtPromedio.setBounds(87, 31, 127, 20);
		panel_1.add(txtPromedio);
		
		txtCondicion = new JTextField();
		txtCondicion.setColumns(10);
		txtCondicion.setBounds(87, 56, 127, 20);
		
		panel_1.add(txtCondicion);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				txtCondicion.setText("");
				txtPromedio.setText("");
				
				
				String tp= (String) cbTPS.getSelectedItem();
				
				if (txtNota_1.getText().equals("") || txtNota_2.getText().equals("") || txtNota_3.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Ingrese todas las notas por favor");
				}
				else {		
					float nota1= Float.parseFloat(txtNota_1.getText());
					float nota2= Float.parseFloat(txtNota_2.getText());
					float nota3= Float.parseFloat(txtNota_3.getText());
					
					float promedio=  (nota1 + nota2 + nota3)/3;
					
					if(tp == "Desaprobado") {
						txtCondicion.setText("Libre");	
					}
					else {
						if( nota1 < 6 || nota2 < 6 || nota3 < 6) {					
							txtCondicion.setText("Libre");			
						}
						else if(promedio >= 8) {
							txtCondicion.setText("Promocionado");
						}
						else if (promedio >= 6 && promedio < 8) {
							txtCondicion.setText("Regular");
						}
							
					}
					txtPromedio.setText(String.format("%.2f", promedio));
					}
			}
		});
		btnCalcular.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCalcular.setBounds(272, 46, 99, 38);
		contentPane.add(btnCalcular);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNuevo.setBounds(272, 95, 99, 38);
		contentPane.add(btnNuevo);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(272, 144, 99, 38);
		contentPane.add(btnSalir);
	}

	
}