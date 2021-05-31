package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class PanelListarPersonas extends JPanel {
	
	private JTable table = new JTable();

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	/*creacion del panel*/
	public PanelListarPersonas() {
		setLayout(null);	

		//PREVENGO QUE SE PUEDA EDITAR Y QUE SE PUEDA SELECCIONAR MAS DE UNO
		table.setDefaultEditor(Object.class, null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.setBounds(40, 50, 325, 160);
		
		//ESTO LO NECESITO PARA LOS HEADERS DE LAS COLUMNAS
		JScrollPane scrollPane = new JScrollPane(table);
		
		scrollPane.setBounds(38, 11, 331, 202);
		add(scrollPane);

	}
}
