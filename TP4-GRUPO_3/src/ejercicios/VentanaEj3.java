package ejercicios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class VentanaEj3 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEj3 frame = new VentanaEj3();
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
	public VentanaEj3() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 441, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 407, 65);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblElijeUnSistema = new JLabel("Elije un sistema operativo");
		lblElijeUnSistema.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblElijeUnSistema.setBounds(10, 21, 155, 20);
		panel.add(lblElijeUnSistema);
		
		JRadioButton rdbtnWindows = new JRadioButton("Windows");
		rdbtnWindows.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnWindows.setBounds(181, 20, 75, 23);
		panel.add(rdbtnWindows);
		
		JRadioButton rdbtnMac = new JRadioButton("Mac");
		rdbtnMac.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnMac.setBounds(269, 20, 49, 23);
		panel.add(rdbtnMac);
		
		JRadioButton rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnLinux.setBounds(333, 20, 61, 23);
		panel.add(rdbtnLinux);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 87, 407, 153);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblElijeUnaEspecialidad = new JLabel("Elije una especialidad");
		lblElijeUnaEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblElijeUnaEspecialidad.setBounds(10, 67, 142, 14);
		panel_1.add(lblElijeUnaEspecialidad);
		
		JCheckBox chckbxProgramacin = new JCheckBox("Programaci\u00F3n");
		chckbxProgramacin.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxProgramacin.setBounds(203, 25, 130, 23);
		panel_1.add(chckbxProgramacin);
		
		JCheckBox chckbxAdministracin = new JCheckBox("Administraci\u00F3n");
		chckbxAdministracin.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxAdministracin.setBounds(203, 63, 130, 23);
		panel_1.add(chckbxAdministracin);
		
		JCheckBox chckbxDiseoGrfico = new JCheckBox("Dise\u00F1o Gr\u00E1fico");
		chckbxDiseoGrfico.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxDiseoGrfico.setBounds(203, 105, 130, 23);
		panel_1.add(chckbxDiseoGrfico);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 251, 407, 70);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCantidadDeHoras = new JLabel("Cantidad de horas en el computador:");
		lblCantidadDeHoras.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidadDeHoras.setBounds(10, 11, 219, 14);
		panel_2.add(lblCantidadDeHoras);
		
		textField = new JTextField();
		textField.setBounds(253, 8, 86, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAceptar.setBounds(308, 39, 89, 23);
		panel_2.add(btnAceptar);
	}
}
