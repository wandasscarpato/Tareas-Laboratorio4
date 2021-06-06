package tp3;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String dni = JOptionPane.showInputDialog("Ingrese el dni: ");
		try {
			Dni.validarDni(dni);
		} catch (SoloNumerosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
