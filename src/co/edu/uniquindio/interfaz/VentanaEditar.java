package co.edu.uniquindio.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class VentanaEditar extends JFrame implements ActionListener,
		ComponentListener {

	// Se declaran las variables necesarias para la ventana de editar.
	private JPanel panelBotones;
	private JComboBox boxEliminar;
	private JPanel panelAux;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JComboBox boxAgregar;
	PanelBotonesEditar botones = new PanelBotonesEditar();
	private JRadioButton partida;
	private JPanel panelPBotones;
	private JScrollPane scrollTotal;
	private JScrollPane panelTotal;
	private JScrollBar scollVer;
	private JScrollPane jScrollPane1;
	private JPanel panelOpciones;
	private JRadioButton eliminar;
	private ButtonGroup buttonGroup;
	private JRadioButton banderin;
	private JRadioButton muro;
	private JRadioButton llegada;
	private int tamano;
	private PanelImagenFondo panelImagen;
	String nombre;
	boolean noEntrar = false;

	/**
	 * Metodo constructor que lee un archivo que contiene una matriz de enteros,
	 * la cual representa un escenario visual, luego se llama a
	 * "GestionDeEscenarios", el cual tiene la función de leer, para que con
	 * este archivo se llame al panel de botones editar.
	 */
	public VentanaEditar() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("Escenarios/ "));
		chooser.setApproveButtonText("Abrir TxT");
		chooser.addChoosableFileFilter(new FiltroTxt());

		int status = chooser.showOpenDialog(chooser);

		if (status == chooser.CANCEL_OPTION) {

			VentanaGestionEscenario miVentana = new VentanaGestionEscenario();
			this.setVisible(false);
			miVentana.setVisible(true);
			miVentana.setResizable(false);

		} else {
			GestionDeEscenarios gestion = new GestionDeEscenarios();

			gestion.setVtnEditar(this);
			File archivo = chooser.getSelectedFile();
			if (!chooser.accept(archivo)) {

			}
			try {
				gestion.leerArchivoEdite(archivo);
				this.dispose();
			} catch (ExcepcionPersonalizada e) {
				// TODO Auto-generated catch block
				e.getMensajePersonalizado();
				VentanaJugar vtnJugarE = new VentanaJugar();
				this.setVisible(false);
				// vtnJugarD.setVisible(true);
				noEntrar = true;
				this.dispose();

			}
			if (!noEntrar) {
				nombre = archivo.getName();
				panelBotones = botones.addButtonsEdite(gestion
						.getEscenarioCarga());
				panelBotones.setBounds(0, 0,
						5 * gestion.getEscenarioCarga().length + 400,
						5 * gestion.getEscenarioCarga().length + 700);
				panelBotones.setEnabled(false);
				panelBotones.setOpaque(false);

				setLocation(300, 50);
				this.setSize(1031, 699);
				panelImagen = new PanelImagenFondo(
						"Imagenes Estc/3d-espacial-1024-x-768-tt1.jpg");
				this.add(panelImagen);
				this.setLocationRelativeTo(null);

				setVisible(true);

				botones.setVtnEditar(this);
				initGUI();
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			}
		}
	}

	/**
	 * Metodo propio de la clase JFrame, que se encarga de inicializar la
	 * ventana, aquí también se llaman a los metodos de la clase
	 * "PanelBotonesEditar", los cuales contienen los paneles necesarios para
	 * la correcta visualización de la ventana.
	 */
	private void initGUI() {
		try {
			{
				{
					panelImagen.add(panelBotones);

					{
						panelOpciones = botones.getPanelOpcionesEdite();
						panelOpciones.setOpaque(false);
						panelImagen.add(panelOpciones);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

}
