package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Font;

public class PanelEliminarPersonas extends JPanel {
	
	private JButton btnEliminar;
	private JList list;
	
	public JList getJlist() {
		return list;
	}
	
	public void setJlist(JList list) {
		this.list = list;
	}
	
	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	/**
	 * Create the panel.
	 */
	public PanelEliminarPersonas() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		list = new JList();
		list.setBounds(143, 36, 151, 135);
		panel.add(list);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(174, 182, 89, 23);
		panel.add(btnEliminar);
		
		JLabel lblElminarUsuarios = new JLabel("Eliminar usuarios");
		lblElminarUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblElminarUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblElminarUsuarios.setBounds(143, 11, 151, 14);
		panel.add(lblElminarUsuarios);

	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
}
