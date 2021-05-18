package ejercicios;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;

public class ListarPeliculas extends JPanel {

	/**
	 * Create the panel.
	 */
	public ListarPeliculas() {
		setLayout(null);
		
		JLabel lblPeliculas = new JLabel("Peliculas");
		lblPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPeliculas.setBounds(29, 89, 176, 14);
		add(lblPeliculas);
		
		JList list = new JList();
		list.setBounds(106, 11, 245, 176);
		add(list);

	}
}
