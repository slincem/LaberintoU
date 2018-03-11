package co.edu.uniquindio.interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.util.ArrayList;

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

import co.edu.uniquindio.controller.ArbolCaminos;
import co.edu.uniquindio.controller.Backtracking;
import co.edu.uniquindio.controller.Posicion;
import co.edu.uniquindio.controller.Solucion;

public class VentanaJugar extends JFrame implements ActionListener,
		ComponentListener {
	// Se declaran las variables necesarias para la Ventana Jugar.
	private JPanel panelBotones;
	private JComboBox boxEliminar;
	private JPanel panelAux;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JComboBox boxAgregar;

	private JRadioButton partida;
	private JPanel panelPBotones;
	private JPanel panelBotonesReLoad;
	private JScrollPane scrollTotal;
	private JScrollPane panelTotal;
	private JScrollBar scollVer;
	private JScrollPane jScrollPane1;
	private JPanel panelOpciones;
	private JPanel panelOpcionesReLoad;
	private JRadioButton eliminar;
	private ButtonGroup buttonGroup;
	private JRadioButton banderin;
	private JRadioButton muro;
	private JRadioButton llegada;
	private int tamano;
	private boolean noEntrar = false;
	private ArrayList<Solucion> pasos;
	panelJugar botones = new panelJugar();

	JScrollPane panelArbol;
	JPanel panelChoose;
	panelJugar botonesReLoad = new panelJugar();
	private int[][] escenarioGlobal;

	private VentanaJugarAgain vtnAntAg;
	private boolean vtnNormalYaCerrada = false;
	private PanelImagenFondo panelImagen;

	/**
	 * Metodo constructor que se encarga de darle las propiedades a la ventana,
	 * además de instanciar a "PanelJugar", el cual a través de un archivo que
	 * será leido se encarga de crear el panel que será mostrado al usuario para
	 * que juegue.
	 */
	public VentanaJugar() {
		panelImagen = new PanelImagenFondo(
				"Imagenes Estc/3d-espacial-1024-x-768-tt1.jpg");
		this.add(panelImagen);
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("Escenarios/ "));
		chooser.setApproveButtonText("Abrir TxT");
		chooser.addChoosableFileFilter(new FiltroTxt());

		int status = chooser.showOpenDialog(chooser);

		// En caso de que en el filechooser le den cancelar volvemos a mostrar
		// la Ventana.
		if (status == chooser.CANCEL_OPTION) {
			this.setVisible(false);
			VentanaMenu miVentana = new VentanaMenu();

			miVentana.setVisible(true);
			miVentana.setResizable(false);

		} else {
			GestionDeEscenarios gestion = new GestionDeEscenarios();
			gestion.setVtnJugar(this);
			File archivo = chooser.getSelectedFile();
			if (!chooser.accept(archivo)) {

			}
			try {
				gestion.leerArchivoPlay(archivo);
				this.dispose();
			} catch (ExcepcionPersonalizada e) {
				// TODO Auto-generated catch block
				e.getMensajePersonalizado();
				VentanaEditar vtnJugarD = new VentanaEditar();
				this.setVisible(false);
				noEntrar = true;
				this.dispose();

			}
			// Si no hubo error, procedemos a realizar los procesos normales de
			// la ventana.
			if (!noEntrar) {
				this.setVisible(true);

				this.escenarioGlobal = gestion.getEscenarioCarga();
				botones.setEscenarioCargaAgain(gestion.getEscenarioCarga());
				panelBotones = botones.addButtonsGame(gestion
						.getEscenarioCarga());
				panelBotones.setBounds(0, 0,
						5 * gestion.getEscenarioCarga().length + 600,
						5 * gestion.getEscenarioCarga().length + 800);
				panelBotones.setEnabled(false);

				setLocation(300, 50);
				this.setSize(1031, 699);
				this.setLocationRelativeTo(null);

				Backtracking back = new Backtracking();

				back.Application(gestion.getEscenarioCarga());

				pasos = back.getSolu();
				botones.setVtnJugar(this);
				botones.setPasos(pasos);
				initGUI();

				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			}
		}
	}

	/**
	 * Metodo propio de la clase JFrame, de la cual VentanaJugar hereda, para
	 * mostrar la Ventana, aquí también se encuentran llamadas a metodos de la
	 * instancia de PanelJugar para el correcto funcionamiento de la ventana.
	 */
	private void initGUI() {
		try {
			{
				panelImagen.add(panelBotones);
				panelBotones.setOpaque(false);
				botones.setOpaque(false);

				{
					panelOpciones = botones.getPanelOpcionesGame();
					panelImagen.add(panelOpciones);
					panelOpciones.setOpaque(false);

				}
				{

					if (botones.scrollArbol() != null) {
						panelArbol = botones.scrollArbol();
						panelArbol.setOpaque(false);
						panelImagen.add(panelArbol);
					}
				}
				{
					if (botones.panelChoose() != null) {
						panelChoose = botones.panelChoose();
						panelImagen.add(panelChoose);
						panelChoose.setOpaque(false);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que se encarga de mostrar una ventana igual a VentanaJugar, con la
	 * diferencia que no leerá archivos de texto, sino que usará, el que ya fue
	 * leido.
	 */
	public void vtnAgain() {

		if (!vtnNormalYaCerrada) {
			VentanaJugarAgain vtnJugarAgain = new VentanaJugarAgain(
					escenarioGlobal, pasos, botones, this);
			this.setVisible(false);
			vtnJugarAgain.setVisible(true);
			this.vtnAntAg = vtnJugarAgain;
			vtnNormalYaCerrada = true;
		} else {
			VentanaJugarAgain vtnJugarAgain = new VentanaJugarAgain(
					escenarioGlobal, pasos, botones, this);
			vtnJugarAgain.setVisible(true);
			this.vtnAntAg.setVisible(false);
			this.vtnAntAg = vtnJugarAgain;
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
