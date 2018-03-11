package co.edu.uniquindio.interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class PanelBotonesEditar extends JPanel implements ComponentListener,
		ActionListener {

	// Se declaran las variables que seran usadas en el panel.
	private JPanel panelOpcionesEdite;
	private JRadioButton camino;
	private ButtonGroup buttonGroup;
	private JRadioButton banderin;
	private JRadioButton muro;
	private JRadioButton llegada;
	private JRadioButton partida;
	private JButton[][] botones;
	private JButton guardar;
	private JButton cargar;
	private JButton btnAtras;
	private VentanaEditar vtnEditar;

	public VentanaEditar getVtnEditar() {
		return vtnEditar;
	}

	public void setVtnEditar(VentanaEditar vtnEditar) {
		this.vtnEditar = vtnEditar;
	}

	private ImageIcon iconPartida = new ImageIcon(getClass().getResource(
			"Imagenes Estc/icoMarioFondo.png"));

	private ImageIcon iconMuro = new ImageIcon(getClass().getResource(
			"Imagenes Estc/cositoVerde.png"));

	private ImageIcon iconBanderin = new ImageIcon(getClass().getResource(
			"Imagenes Estc/bolitaCala.png"));

	private ImageIcon iconLlegada = new ImageIcon(getClass().getResource(
			"Imagenes Estc/icoLlega.png"));

	private ImageIcon iconLibre = new ImageIcon(getClass().getResource(
			"Imagenes Estc/suelo.jpg"));

	private OwnImage ownPartida = new OwnImage("partida", iconPartida);
	private OwnImage ownMuro = new OwnImage("muro", iconMuro);
	private OwnImage ownBanderin = new OwnImage("banderin", iconBanderin);
	private OwnImage ownLlegada = new OwnImage("llegada", iconLlegada);
	private OwnImage ownLibre = new OwnImage("libre", iconLibre);

	private ImageIcon[] imagenes = new ImageIcon[5];

	int tamano;

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	/**
	 * Metodo que se encarga de generar el panel para Editar, aquí recibimos la
	 * matriz de enteros, para generar una matriz visual igual a la que el
	 * usuario hizo en crear. Esto se logrará por medio de los valores númericos
	 * de dicha matriz de enteros.
	 * 
	 * @param escenarioCargaInt
	 *            , Escenario de enteros que fue leído de un archivo.
	 * @return
	 */
	public JPanel addButtonsEdite(int[][] escenarioCargaInt) {
		// Guardamos el tamaño de la matriz de enteros.
		int tamanoEditar = escenarioCargaInt.length;
		// Creamos el panel que retornaremos
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(null);
		panelBotones.setBounds(5, 30, 5 * tamanoEditar + 400,
				5 * tamanoEditar + 400);

		// Guardamos el tamaño del panel.
		int anchoPanel = panelBotones.getWidth();
		int altoPanel = panelBotones.getHeight();

		// Definimos el tamaño de los botones de acuerdo
		// a las medidas tanto del panel como de la matriz.
		int anchoBoton = anchoPanel / tamanoEditar;
		int altoBoton = altoPanel / tamanoEditar;
		botones = new JButton[escenarioCargaInt.length][escenarioCargaInt.length];
		/*
		 * Creamos los botones con la imagen correspondiente de acuerdo al valor
		 * que tienen en la matriz de enteros.
		 */
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
				botones[i][j] = new JButton();
				botones[i][j].setBounds(j * anchoBoton, i * altoBoton,
						anchoBoton, altoBoton);
				if (escenarioCargaInt[i][j] == 0) {
					botones[i][j].setIcon(ownLibre.getImagen());
				}
				if (escenarioCargaInt[i][j] == 1) {
					botones[i][j].setIcon(ownPartida.getImagen());
				}
				if (escenarioCargaInt[i][j] == 2) {
					botones[i][j].setIcon(ownLlegada.getImagen());
				}
				if (escenarioCargaInt[i][j] == 3) {
					botones[i][j].setIcon(ownMuro.getImagen());
				}
				if (escenarioCargaInt[i][j] == 4) {

					botones[i][j].setIcon(ownBanderin.getImagen());
				}
				botones[i][j].addActionListener(this);
				panelBotones.add(botones[i][j]);
			}
		}
		return panelBotones;

	}

	/**
	 * Metodo que se encarga de meter todos los RadioButton en unn mismo grupo
	 * para que solo uno pueda ser seleccionado
	 * 
	 * @return ButtonGroup, grupo de radiobuttons.
	 */

	private ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
		}
		return buttonGroup;
	}

	/**
	 * Metodo encargado de crear el panel para las opciones de el panel editar.
	 * 
	 * @return
	 */
	public JPanel getPanelOpcionesEdite() {
		if (panelOpcionesEdite == null) {
			panelOpcionesEdite = new JPanel();
			panelOpcionesEdite.setBounds(821, 7, 149, 547);
			{
				banderin = new JRadioButton();
				panelOpcionesEdite.add(banderin);

				panelOpcionesEdite.setLayout(null);
				panelOpcionesEdite.setBorder(new SoftBevelBorder(
						BevelBorder.LOWERED, null, null, null, null));
				banderin.setText("Banderín");
				banderin.setBounds(32, 30, 83, 18);
				banderin.setOpaque(false);
				banderin.setForeground(Color.white);
				getButtonGroup().add(banderin);
			}
			{
				muro = new JRadioButton();
				panelOpcionesEdite.add(muro);
				muro.setText("Muro");
				muro.setBounds(33, 115, 85, 20);
				muro.setForeground(Color.white);
				muro.setOpaque(false);
				getButtonGroup().add(muro);
			}
			{
				llegada = new JRadioButton();
				panelOpcionesEdite.add(llegada);
				llegada.setText("Llegada");
				llegada.setBounds(32, 198, 86, 20);
				llegada.setForeground(Color.white);
				llegada.setOpaque(false);
				getButtonGroup().add(llegada);
			}
			{
				partida = new JRadioButton();
				panelOpcionesEdite.add(partida);
				partida.setText("Partida");
				partida.setBounds(32, 289, 88, 18);
				partida.setForeground(Color.white);
				partida.setOpaque(false);
				getButtonGroup().add(partida);
			}
			{
				camino = new JRadioButton();
				panelOpcionesEdite.add(camino);
				camino.setText("Camino");
				camino.setBounds(32, 382, 85, 22);
				camino.setForeground(Color.white);
				camino.setOpaque(false);
				getButtonGroup().add(camino);
			}
			{
				guardar = new JButton();
				panelOpcionesEdite.add(guardar);
				// guardar.setText("Guardar");
				guardar.setBounds(80, 472, 45, 45);

				ImageIcon imaGuardar = new ImageIcon(getClass().getResource(
						"Imagenes Estc/save-icon.jpg"));
				guardar.setIcon(imaGuardar);
				guardar.addActionListener(this);
			}
			{
				btnAtras = new JButton();
				panelOpcionesEdite.add(btnAtras);
				// btnAtras.setText("Atras");
				btnAtras.setBounds(20, 472, 45, 45);
				ImageIcon imaAtras = new ImageIcon(getClass().getResource(
						"Imagenes Estc/icoAtras.jpg"));
				btnAtras.setIcon(imaAtras);
				btnAtras.addActionListener(this);
			}
		}
		panelOpcionesEdite.setOpaque(false);
		return panelOpcionesEdite;

	}

	@Override
	/**
	 * Metodo de la interface ActionListener, que se encarga de
	 * oir los eventos ocasionados por el usuario, en este caso los de modificación
	 * del escenario, el de guardar el nuevo escenairo, o el de volver.
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		imagenes[0] = iconLibre;
		imagenes[1] = iconPartida;
		imagenes[2] = iconLlegada;
		imagenes[3] = iconMuro;
		imagenes[4] = iconBanderin;

		if (e.getSource() == guardar) {

			GestionDeEscenarios gestion = new GestionDeEscenarios();
			gestion.setNomArchivo(vtnEditar.nombre);
			gestion.llenarMatriz(botones, imagenes);

		}

		if (e.getSource() instanceof JButton) {
			for (int i = 0; i < botones.length; i++) {
				for (int j = 0; j < botones[0].length; j++) {

					if (e.getSource() == botones[i][j]) {

						if (partida.isSelected()) {
							botones[i][j].setIcon(imagenes[1]);

						} else if (llegada.isSelected()) {
							botones[i][j].setIcon(imagenes[2]);
						} else if (muro.isSelected()) {
							botones[i][j].setIcon(imagenes[3]);

						} else if (banderin.isSelected()) {
							botones[i][j].setIcon(imagenes[4]);
						} else if (camino.isSelected()) {
							botones[i][j].setIcon(imagenes[0]);
						}
					}
				}
			}
		}
		if (e.getSource() == btnAtras) {
			VentanaGestionEscenario gestion = new VentanaGestionEscenario();
			vtnEditar.dispose();
			gestion.setVisible(true);

		}

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
