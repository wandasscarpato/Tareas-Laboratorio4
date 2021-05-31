package presentacion.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	
	private JMenuBar menuBar;
	private JMenu mnPersona;
	private JMenuItem menuAgregar;
	private JMenuItem menuEliminar;
	private JMenuItem menuModificar;
	private JMenuItem menuListar;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		//ESTO PARA QUE NO SE PUEDA AGRANDAR SINO SE PIERDE LA FORMA
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);
		
		menuAgregar = new JMenuItem("Agregar");
		mnPersona.add(menuAgregar);
		
		menuModificar = new JMenuItem("Modificar");
		mnPersona.add(menuModificar);
		
		menuEliminar = new JMenuItem("Eliminar");
		mnPersona.add(menuEliminar);
		
		menuListar = new JMenuItem("Listar");
		mnPersona.add(menuListar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}

	public JMenuItem getMenuAgregar() {
		return menuAgregar;
	}

	public void setMenuAgregar(JMenuItem menuAgregar) {
		this.menuAgregar = menuAgregar;
	}

	public JMenuItem getMenuEliminar() {
		return menuEliminar;
	}

	public void setMenuEliminar(JMenuItem menuEliminar) {
		this.menuEliminar = menuEliminar;
	}

	public JMenuItem getMenuModificar() {
		return menuModificar;
	}

	public void setMenuModificar(JMenuItem menuModificar) {
		this.menuModificar = menuModificar;
	}

	public JMenuItem getMenuListar() {
		return menuListar;
	}

	public void setMenuListar(JMenuItem menuListar) {
		this.menuListar = menuListar;
	}

	

}
