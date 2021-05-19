package ejercicios;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarPelicula extends JPanel {
	private JTextField txtNombre;
	private DefaultListModel<Peliculas> dlModel;
	private JComboBox<String> comboBox;
	private JButton btnAceptar;
	Peliculas peliculas = new Peliculas();
	
	/**
	 * Create the panel.
	 */
	
	public AgregarPelicula() {
		setLayout(null);
		
		txtNombre = new JTextField();
		//cambie el valor de largo a 150
		txtNombre.setBounds(209, 48, 150, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblID = new JLabel(peliculas.devuelveProximoId());
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblID.setBounds(209, 23, 99, 14);
		add(lblID);
		
		comboBox = new JComboBox<String>();
		//cambie el valor de largo a 150----------------------
		comboBox.setBounds(209, 83, 150, 20);
		add(comboBox);
		//agregue item Seleccione un genero--------------------
		comboBox.addItem("Seleccione un genero");
		comboBox.addItem("Terror");
		comboBox.addItem("Accion");
		comboBox.addItem("Suspenso");
		comboBox.addItem("Romantica");

		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(76, 23, 88, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(76, 52, 89, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Genero");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(76, 85, 88, 14);
		add(lblNewLabel_2);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//filtro por txtNombre
				if(txtNombre.getText().length() != 0){
					//filtro por si selecciono otro dato que no sea selecione un texto
					if(comboBox.getSelectedItem().toString() != "Seleccione un genero") {
					Peliculas peliculas = new Peliculas(txtNombre.toString(), comboBox.getSelectedItem().toString());
					lblID.setText(peliculas.devuelveProximoId());
					}
						else{
							JOptionPane.showMessageDialog(null, "Porfavor seleccione un genero");
						}
				}
				else{
					JOptionPane.showMessageDialog(null, "Porfavor escriba un nombre");
				}
				
			}
		});
		btnAceptar.setBounds(76, 130, 129, 29);
		add(btnAceptar);

	}
}
