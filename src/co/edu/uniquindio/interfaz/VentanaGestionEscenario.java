package co.edu.uniquindio.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.*;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class VentanaGestionEscenario extends JFrame implements ActionListener {
	// Se declaran las variables necesarias para la Ventana de Gestion de
	// escenarios.
	private JButton btnCrear;
	private JButton btnEditar;
	private JButton btnAtras;
	static int tamano = 0;
	private PanelImagenFondo panelImagen;

	/**
	 * Metodo constructor en el cual se dan las propiedades de la ventana.
	 * 
	 */
	public VentanaGestionEscenario() {
		setLocation(525, 100);
		this.setSize(389, 346);

		setVisible(true);
		this.setLocationRelativeTo(null);

		panelImagen = new PanelImagenFondo("Imagenes Estc/d02.jpg");
		this.add(panelImagen);

		initGUI();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

	/**
	 * Metodo propio de la clase JFrame, de la cual extienda esta ventana. Aquí
	 * se inicializan todos los atributos necesarios para el correcto
	 * funcionamiento de la ventana.
	 */
	public void initGUI() {
		btnCrear = new JButton();
		panelImagen.add(btnCrear);
		// btnCrear.setText("CREAR ESCENARIO");
		btnCrear.setBounds(150, 30, 80, 80);
		btnCrear.addActionListener(this);
		ImageIcon imaCrear = new ImageIcon(getClass().getResource(
				"Imagenes Estc/icoCrear.png"));
		btnCrear.setIcon(imaCrear);

		btnEditar = new JButton();
		panelImagen.add(btnEditar);
		// btnEditar.setText("EDITAR");
		btnEditar.setBounds(150, 122, 80, 80);
		ImageIcon imaEditar = new ImageIcon(getClass().getResource(
				"Imagenes Estc/icoEditar.png"));
		btnEditar.setIcon(imaEditar);
		btnEditar.addActionListener(this);

		btnAtras = new JButton();
		panelImagen.add(btnAtras);
		// btnAtras.setText("REGRESAR AL MENU");
		btnAtras.setBounds(150, 216, 80, 80);
		ImageIcon imaAtras = new ImageIcon(getClass().getResource(
				"Imagenes Estc/home-negra.jpg"));
		btnAtras.setIcon(imaAtras);
		btnAtras.addActionListener(this);
	}

	@Override
	/**
	 * Metodo propio de la interface ActionListener, el cual se encarga
	 * de detectar eventos ocasionados por el usuario. Aquí los eventos podrian
	 * ser: Ir a crear, ir a editar o volver al menu.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCrear) {

			pedirTamano();
			VentanaCreacion vtnCreacion = new VentanaCreacion(tamano);
			vtnCreacion.setVisible(true);
			this.setVisible(false);
		} else if (e.getSource() == btnEditar) {
			// preguntar como sacar la ventanita que pide archivos
			// GestionDeEscenarios gestion = new GestionDeEscenarios();
			// PanelBotonesEditar botonesEditar = new PanelBotonesEditar();
			// gestion.leerArchivo();
			VentanaEditar vtnEditar = new VentanaEditar();
			// vtnEditar.setVisible(true);
			this.setVisible(false);

		} else if (e.getSource() == btnAtras) {
			VentanaMenu miVentana = new VentanaMenu();
			miVentana.setVisible(true);
			miVentana.setResizable(false);
			this.setVisible(false);
		}

	}

	/**
	 * Metodo encargado de pedir el tamaño en caso de que el evento haya sido
	 * crear, ya que este es necesario para la dimensión de la matriz visual.
	 */

	public void pedirTamano() {

		try {
			tamano = Integer.parseInt(JOptionPane
					.showInputDialog("Ingrese tamano de el laberinto"));
			if (tamano < 20) {
				JOptionPane.showMessageDialog(null, "Tamaño No Valido");
				pedirTamano();

			}
		}

		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Tamaño No Valido");
			pedirTamano();
		}

	}
}
