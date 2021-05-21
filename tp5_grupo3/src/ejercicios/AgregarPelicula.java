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
import java.util.Locale.Category;
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
		
		//VALOR LABEL ID
		JLabel lbl_ID_valor = new JLabel();
		lbl_ID_valor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_ID_valor.setBounds(209, 23, 99, 14);
		add(lbl_ID_valor);
		
		comboBox = new JComboBox();
		//cambie el valor de largo a 150----------------------
		comboBox.setBounds(209, 83, 150, 20);
		add(comboBox);
		//agregue item Seleccione un genero--------------------
		comboBox.addItem("Seleccione un genero");
		comboBox.addItem("Terror");
		comboBox.addItem("Accion");
		comboBox.addItem("Suspenso");
		comboBox.addItem("Romantica");

		//Solo label
		JLabel lbl_ID = new JLabel("ID");
		lbl_ID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_ID.setBounds(76, 23, 88, 14);
		add(lbl_ID);
		
		//Solo label
		JLabel lbl_Nombre = new JLabel("Nombre");
		lbl_Nombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_Nombre.setBounds(76, 52, 89, 14);
		add(lbl_Nombre);
		
		//Solo label
		JLabel lbl_genero = new JLabel("Genero");
		lbl_genero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_genero.setBounds(76, 85, 88, 14);
		add(lbl_genero);
		
		int tempID = 1;
		String temp = Integer.toString(tempID);
		lbl_ID_valor.setText(temp);
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

 				if(txtNombre.getText().isEmpty() || comboBox.getSelectedItem() == "Seleccione un genero") {
					JOptionPane.showMessageDialog(null, "Porfavor seleccione un genero");
				}
				else {
					Peliculas p = new Peliculas();
					categoria cate = new categoria();
					p.setNombre(txtNombre.getText());
					cate.setCategoria((String) comboBox.getSelectedItem());
					p.setGenero(cate);
					String IDP = Integer.toString(p.getId()+1);
					lbl_ID_valor.setText(IDP);
					txtNombre.setText("");
					comboBox.setSelectedIndex(0);
					dlModel.addElement(p);
					JOptionPane.showMessageDialog(null, "Se agrego la pelicula");
				}

			}
		});
		btnAceptar.setBounds(76, 130, 129, 29);
		add(btnAceptar);

	}
	
	public void setDefaultListModel(DefaultListModel<Peliculas> listModelRecibido)
	{
		this.dlModel = listModelRecibido;
	}
	
}
