package ejercicios;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;

public class ListarPeliculas extends JPanel {
	
	private DefaultListModel<Peliculas> dlModel;
	private JList<Peliculas> list;

	/**
	 * Create the panel.
	 */
	public ListarPeliculas() {
		setLayout(null);
		
		JLabel lblPeliculas = new JLabel("Peliculas");
		lblPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPeliculas.setBounds(29, 89, 176, 14);
		add(lblPeliculas);
		
		list = new JList();
		list.setBounds(106, 11, 245, 176);
		add(list);

	}
	
	public void setDefaultListModel(DefaultListModel<Peliculas> listModel2)
	{
		this.dlModel = listModel2;
		list.setModel(this.dlModel);
	}
}
