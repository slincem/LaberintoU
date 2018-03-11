package co.edu.uniquindio.interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class PanelBotonesCreacion extends JPanel implements ComponentListener,
		ActionListener {

	// Declaración de variables necesarias para el panel.

	private JPanel panelOpciones;
	private JRadioButton camino;
	private ButtonGroup buttonGroup;
	private JRadioButton banderin;
	private JRadioButton muro;
	private JRadioButton llegada;
	private JRadioButton partida;
	private JButton[][] botones;
	private JButton guardar;
	private JButton btnAtras;

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

	private ImageIcon iconMov = new ImageIcon(getClass().getResource(
			"Imagenes Estc/mariesito.gif"));

	private ImageIcon iconScore = new ImageIcon(getClass().getResource(
			"Imagenes Estc/YOSHI-SCORE.png"));

	private OwnImage ownPartida = new OwnImage("partida", iconPartida);
	private OwnImage ownMuro = new OwnImage("muro", iconMuro);
	private OwnImage ownBanderin = new OwnImage("banderin", iconBanderin);
	private OwnImage ownLlegada = new OwnImage("llegada", iconLlegada);

	public VentanaCreacion getVtnCreacion() {
		return vtnCreacion;
	}

	public void setVtnCreacion(VentanaCreacion vtnCreacion) {
		this.vtnCreacion = vtnCreacion;
	}

	private OwnImage ownLibre = new OwnImage("libre", iconLibre);

	private ImageIcon[] imagenes = new ImageIcon[5];

	private VentanaCreacion vtnCreacion;

	int tamano;

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	/**
	 * Metodo en el que creamos el panel de creación de botones, y adherimos a
	 * este la matriz visual de botones, y le enviamos como primera imagen a
	 * dichos botones de la matriz de botones, el icono de muro.
	 * 
	 * @return
	 */

	public JPanel addButtons() {

		// por medio de la variable tamaño, que corresponde al tamaño que el
		// usuario escogió
		// creamos el panel.
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(null);
		panelBotones.setBounds(5, 30, 5 * tamano + 400, 5 * tamano + 400);

		// Guardamos las medidas del panel.
		int anchoPanel = panelBotones.getWidth();
		int altoPanel = panelBotones.getHeight();

		// Por medio de las medidas del panel, calculamos las medidas que deben
		// tener los
		// botones.
		int anchoBoton = anchoPanel / tamano;
		int altoBoton = altoPanel / tamano;
		botones = new JButton[tamano][tamano];
		/*
		 * De acuerdo al tamaño que el usuario escogió para el laberinto creamos
		 * la matriz de botones.
		 */
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
				botones[i][j] = new JButton();
				botones[i][j].setBounds(j * anchoBoton, i * altoBoton,
						anchoBoton, altoBoton);
				botones[i][j].setIcon(ownMuro.getImagen());
				botones[i][j].addActionListener(this);
				panelBotones.add(botones[i][j]);
			}
		}
		panelBotones.setOpaque(false);
		return panelBotones;

	}

	private ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
		}
		return buttonGroup;
	}

	/**
	 * Metodo que se encarga de construir el panel que contiene las opciones del
	 * panel de creación.
	 * 
	 * @return JPanel, Panel que contiene las opciones para el panel crear.
	 */

	public JPanel getPanelOpciones() {
		if (panelOpciones == null) {
			panelOpciones = new JPanel();
			panelOpciones.setBounds(821, 7, 149, 547);

			{
				banderin = new JRadioButton();
				panelOpciones.add(banderin);

				panelOpciones.setLayout(null);
				panelOpciones.setBorder(new SoftBevelBorder(
						BevelBorder.LOWERED, null, null, null, null));
				banderin.setText("Banderín");
				banderin.setBounds(32, 30, 83, 18);
				banderin.setOpaque(false);
				banderin.setForeground(Color.white);
				getButtonGroup().add(banderin);
			}
			{
				muro = new JRadioButton();
				panelOpciones.add(muro);
				muro.setText("Muro");
				muro.setBounds(33, 115, 85, 20);
				muro.setForeground(Color.white);
				muro.setOpaque(false);
				getButtonGroup().add(muro);
			}
			{
				llegada = new JRadioButton();
				panelOpciones.add(llegada);
				llegada.setText("Llegada");
				llegada.setBounds(32, 198, 86, 20);
				llegada.setForeground(Color.white);
				llegada.setOpaque(false);
				getButtonGroup().add(llegada);
			}
			{
				partida = new JRadioButton();
				panelOpciones.add(partida);
				partida.setText("Partida");
				partida.setBounds(32, 289, 88, 18);
				partida.setForeground(Color.white);
				partida.setOpaque(false);
				getButtonGroup().add(partida);
			}
			{
				camino = new JRadioButton();
				panelOpciones.add(camino);
				camino.setText("Camino");
				camino.setBounds(32, 382, 85, 22);
				camino.setForeground(Color.white);
				camino.setOpaque(false);
				getButtonGroup().add(camino);
			}
			{
				guardar = new JButton();
				panelOpciones.add(guardar);
				// guardar.setText("Guardar");
				guardar.setBounds(80, 472, 45, 45);

				ImageIcon imaGuardar = new ImageIcon(getClass().getResource(
						"Imagenes Estc/save-icon.jpg"));
				guardar.setIcon(imaGuardar);
				guardar.addActionListener(this);
			}
			{
				btnAtras = new JButton();
				panelOpciones.add(btnAtras);
				// btnAtras.setText("Atras");
				btnAtras.setBounds(20, 472, 45, 45);
				ImageIcon imaAtras = new ImageIcon(getClass().getResource(
						"Imagenes Estc/icoAtras.jpg"));
				btnAtras.setIcon(imaAtras);
				btnAtras.addActionListener(this);
			}
		}
		panelOpciones.setOpaque(false);
		return panelOpciones;

	}

	@Override
	/**
	 * Metodo que se encarga de oir los eventos generados por el usuario;
	 * aquí es donde se verifica que RadioButton fue seleccionado por el usuario, para
	 * hacer el respectivo cambio de icono en los botones, y que al momento de guardar
	 * se llame a la clase "GestionDeEscenarios", para que escriba la matriz visual creada
	 * en un txt, en forma de matriz de enteros.
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
			gestion.setNomArchivo(null);
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
			vtnCreacion.setVisible(false);
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
