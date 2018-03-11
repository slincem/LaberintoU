package co.edu.uniquindio.interfaz;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import co.edu.uniquindio.controller.Backtracking;

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
public class VentanaMenu extends JFrame implements ActionListener {
	// Variables o atributos necesarios para la VentanaMenu.
	private JButton btnJugar;
	private JButton btnGestionEscenarios;
	private JButton btnSalir;
	private PanelImagenFondo panelImagen;

	/**
	 * Metodo constructor, encargado de darle las propiedades a VentanaMenu.
	 */
	public VentanaMenu() {
		setLocation(525, 100);
		this.setSize(398, 454);

		panelImagen = new PanelImagenFondo("Imagenes Estc/maze.png");
		this.add(panelImagen);
		setVisible(true);
		this.setLocationRelativeTo(null);
		// getContentPane().setLayout(null);
		initGUI();
	}

	/**
	 * Metodo propio de la clase JFrame, encargado de mostrar la ventana. Por
	 * medio de este, inicializamos los atributos necesarios para la correcta
	 * visualización de la ventana.
	 */
	private void initGUI() {

		btnJugar = new JButton();
		panelImagen.add(btnJugar, "North");
		// btnJugar.setText("JUGAR");
		btnJugar.setBounds(140, 26, 100, 98);
		btnJugar.addActionListener(this);
		ImageIcon imaJugar = new ImageIcon(getClass().getResource(
				"Imagenes Estc/Boton jugar.jpg"));
		btnJugar.setIcon(imaJugar);

		btnGestionEscenarios = new JButton();
		panelImagen.add(btnGestionEscenarios);
		// btnGestionEscenarios.setText("GESTIONAR ESCENARIOS");
		btnGestionEscenarios.setBounds(140, 149, 100, 90);
		btnGestionEscenarios.addActionListener(this);
		ImageIcon imaGestion = new ImageIcon(getClass().getResource(
				"Imagenes Estc/Gestionar-peque!!.jpg"));
		btnGestionEscenarios.setIcon(imaGestion);

		btnSalir = new JButton();
		panelImagen.add(btnSalir);
		// btnSalir.setText("SALIR");
		btnSalir.setBounds(140, 280, 100, 98);
		btnSalir.addActionListener(this);
		ImageIcon imaSalir = new ImageIcon(getClass().getResource(
				"Imagenes Estc/puerta.jpg"));
		btnSalir.setIcon(imaSalir);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	/**
	 * Metodo propio de la interface ActionListener, este se encarga de oir
	 * los eventos ocasionados por el usuario, en este caso llamar a:
	 * VentanaJugar, VentanaGestion o Salir.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnJugar) {

			try {
				VentanaJugar vtnJugar = new VentanaJugar();
			} catch (Exception ex) {
			} finally {
				// vtnJugar.setVisible(true);
				this.setVisible(false);
			}
			// cargamos entornos
		} else if (e.getSource() == btnGestionEscenarios) {

			VentanaGestionEscenario miVentana = new VentanaGestionEscenario();
			miVentana.setVisible(true);
			miVentana.setResizable(false);
			this.setVisible(false);
		} else if (e.getSource() == btnSalir) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		VentanaMenu miVentana = new VentanaMenu();
		miVentana.setVisible(true);
		miVentana.setResizable(false);
	}

}
