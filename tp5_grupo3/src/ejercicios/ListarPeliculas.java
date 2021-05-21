package ejercicios;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.awt.Font;


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
		
		list = new JList<Peliculas>();
		list.setBounds(106, 11, 245, 176);
		add(list);

	}
	
	public void setDefaultListModel(DefaultListModel<Peliculas> listModel2)
	{
		this.dlModel = listModel2;
		list.setModel(this.dlModel);
		ordenarList();
	}
	
	private void ordenarList() {
		Collection<Peliculas> collList = Collections.list(dlModel.elements());
		Collections.sort((List<Peliculas>)collList,Collections.reverseOrder());
		dlModel.clear();
			for(Object o:collList) {
				dlModel.addElement((Peliculas) o);
			}
	}
	
}
