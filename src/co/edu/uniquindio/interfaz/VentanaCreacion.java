package co.edu.uniquindio.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DebugGraphics;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

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
public class VentanaCreacion extends JFrame implements ActionListener,
		ComponentListener {

	// Se declaran las variables que serán necesarias para la ventana de
	// creación.
	private JPanel panelBotones;
	private JComboBox boxEliminar;
	private JPanel panelAux;
	private JButton btnEliminar;
	private JButton btnAgregar;

	private JComboBox boxAgregar;
	PanelBotonesCreacion botones = new PanelBotonesCreacion();
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

	/**
	 * Metodo constructor de ventana creación, recibimos un botón el cual será
	 * necesario en la instancia al panel ya que definirá el tamaño de la matriz
	 * visual.
	 * 
	 * @param tamano
	 *            , tamaño de la matriz de botones.
	 */
	public VentanaCreacion(int tamano) {
		try {
			this.tamano = tamano;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"El tamano ingresado para el laberinto no es válido");
		}
		setLocation(300, 50);
		this.setSize(1031, 699);
		this.setLocationRelativeTo(null);

		panelImagen = new PanelImagenFondo("Imagenes Estc/Laberinto_800.jpg");
		this.add(panelImagen);

		setVisible(true);
		// getContentPane().setLayout(null);
		botones.setVtnCreacion(this);
		initGUI();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	/**
	 * Metodo encargado de incializar la ventana para que esta sea mostrada. Dentro
	 * del metodo instanciamos al panel creación y opciones que estaran contenidos en
	 * el panel para la correcta visualización de la ventana.
	 */
	private void initGUI() {
		try {
			{
				// getContentPane().setLayout(null);

				{

					botones.setTamano(tamano);
					panelBotones = botones.addButtons();

					panelBotones.setBounds(0, 0, 5 * tamano + 400,
							5 * tamano + 700);
					panelBotones.setEnabled(false);
					panelImagen.add(panelBotones);
					{

						panelOpciones = botones.getPanelOpciones();
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
