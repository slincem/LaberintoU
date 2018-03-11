package co.edu.uniquindio.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class VentanaJugarAgain extends JFrame implements ActionListener,
		ComponentListener {

	// Se declaran las variables necesarias para Ventana Jugar Again.
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
	private ArrayList<Solucion> pasos;
	panelJugar botones;
	private PanelImagenFondo panelImagen;

	JScrollPane panelArbol;
	JPanel panelChoose;
	panelJugar botonesReLoad = new panelJugar();

	private int[][] escenarioGlobal;

	/**
	 * Metodo constructor, encargado de darle las propiedades a la ventana.
	 * Además de hacer un llamado a el PanelJugar, pero ahor enviandole una
	 * matriz de enteros que ya tenemos, es decir, que no es necesario que sea
	 * leida.
	 * 
	 * @param escenarioCarga
	 * @param pasos
	 * @param botones
	 * @param vtnActualJugar
	 */
	public VentanaJugarAgain(int[][] escenarioCarga, ArrayList<Solucion> pasos,
			panelJugar botones, VentanaJugar vtnActualJugar) {
		panelImagen = new PanelImagenFondo(
				"Imagenes Estc/3d-espacial-1024-x-768-tt1.jpg");
		this.add(panelImagen);
		this.botones = botones;

		this.botones.setPasos(pasos);
		this.escenarioGlobal = escenarioCarga;
		panelBotones = this.botones.addButtonsGame(escenarioCarga);
		panelBotones.setBounds(0, 0, 5 * escenarioCarga.length + 600,
				5 * escenarioCarga.length + 800);
		panelBotones.setEnabled(false);

		setLocation(300, 50);
		this.setSize(1031, 699);
		this.setLocationRelativeTo(null);

		setVisible(true);
		this.botones.setVtnJugarAgain(this);
		this.botones.setVtnJugar(vtnActualJugar);

		initGUI();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	/**
	 * Metodo propio de la clase JFrame, de la cual hereda VentanaJugarAgain,
	 * para mostrar la ventana, además de obtener los metodos que devuelven los
	 * paneles de la clase PanelJugar, para la correcta visualización de esta
	 * ventana.
	 */
	private void initGUI() {
		try {
			{
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

						panelArbol = botones.scrollArbol();
						panelArbol.setOpaque(false);
						panelImagen.add(panelArbol);

					}
					{
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

	private void initGUIReLoad() {
		try {
			{
				{
					panelImagen.add(panelBotonesReLoad);

					{
						panelOpcionesReLoad = botonesReLoad
								.getPanelOpcionesGame();
						panelImagen.add(panelOpcionesReLoad);

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