package co.edu.uniquindio.interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import co.edu.uniquindio.controller.ArbolCaminos;
import co.edu.uniquindio.controller.HiloMov;
import co.edu.uniquindio.controller.Solucion;

public class panelJugar extends JPanel implements ActionListener {

	// Se declaran las variables necesarias,
	private JPanel panelOpcionesEdite;
	private JRadioButton eliminar;
	private ButtonGroup buttonGroup;
	private JRadioButton banderin;
	private JRadioButton muro;
	private JRadioButton llegada;
	private JRadioButton partida;
	private JButton[][] botones;
	private JButton jugar;
	private JButton another;
	private int scoreP = 100;
	ArbolCaminos arbolCaminos = new ArbolCaminos();

	private Solucion arbolChoose;

	public Solucion getArbolChoose() {
		return arbolChoose;
	}

	public void setArbolChoose(Solucion arbolChoose) {
		this.arbolChoose = arbolChoose;
	}

	public VentanaJugar getVtnJugar() {
		return vtnJugar;
	}

	public void setVtnJugar(VentanaJugar vtnJugar) {
		this.vtnJugar = vtnJugar;
	}

	private JButton again;
	private VentanaJugar vtnJugar;
	private VentanaJugarAgain vtnJugarAgain;

	public VentanaJugarAgain getVtnJugarAgain() {
		return vtnJugarAgain;
	}

	public void setVtnJugarAgain(VentanaJugarAgain vtnJugarAgain) {
		this.vtnJugarAgain = vtnJugarAgain;
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

	private ImageIcon iconMov = new ImageIcon(getClass().getResource(
			"Imagenes Estc/mariesito.gif"));

	private ImageIcon iconScore = new ImageIcon(getClass().getResource(
			"Imagenes Estc/YOSHI-SCORE.png"));

	private OwnImage ownPartida = new OwnImage("partida", iconPartida);
	private OwnImage ownMuro = new OwnImage("muro", iconMuro);
	private OwnImage ownBanderin = new OwnImage("banderin", iconBanderin);
	private OwnImage ownLlegada = new OwnImage("llegada", iconLlegada);
	private OwnImage ownLibre = new OwnImage("libre", iconLibre);
	private OwnImage ownMov = new OwnImage("movimiento", iconMov);

	private ArrayList<Solucion> pasos;

	private int[][] escenarioCargaAgain;

	public JLabel puntuacion;

	public int[][] getEscenarioCargaAgain() {
		return escenarioCargaAgain;
	}

	public void setEscenarioCargaAgain(int[][] escenarioCargaAgain) {
		this.escenarioCargaAgain = escenarioCargaAgain;
	}

	public panelJugar() {
		// TODO Auto-generated constructor stub

	}

	public ArrayList<Solucion> getPasos() {
		return pasos;
	}

	public void setPasos(ArrayList<Solucion> pasos) {
		this.pasos = pasos;
	}

	/**
	 * Panel encargado de mostrar el escenario para que el usuario juegue, este
	 * recibe la matriz de enteros que fue cargada de un archivo de texto, y de
	 * acuerdo a los valores numericos de éste, se define que irá en cada celda.
	 * 
	 * @param escenarioCargaInt
	 *            , escenario de enteros leido de un archivo de texto.
	 * @return
	 */
	public JPanel addButtonsGame(int[][] escenarioCargaInt) {
		// Se guarda el tamaño de el escenario cargado.
		int tamanoEditar = escenarioCargaInt.length;
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(null);
		panelBotones.setBounds(5, 30, 5 * tamanoEditar + 600,
				5 * tamanoEditar + 450);

		// Se guardan las medidas del panel.
		int anchoPanel = panelBotones.getWidth();
		int altoPanel = panelBotones.getHeight();

		// De acuerdo al tamaño del escenario y medidas del panel, se dan las
		// medidas
		// de los botones.
		int anchoBoton = anchoPanel / tamanoEditar;
		int altoBoton = altoPanel / tamanoEditar;
		botones = new JButton[escenarioCargaInt.length][escenarioCargaInt.length];
		/*
		 * Aquí de acuerdo al valor de la posición de la matriz de enteros, se
		 * le da un icono y nombre a la matriz visual de botones.
		 */
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
				botones[i][j] = new JButton();
				botones[i][j].setBounds(j * anchoBoton, i * altoBoton,
						anchoBoton, altoBoton);
				if (escenarioCargaInt[i][j] == 0) {
					botones[i][j].setName("libre");
					botones[i][j].setIcon(ownLibre.getImagen());
				}
				if (escenarioCargaInt[i][j] == 1) {
					botones[i][j].setName("partida");
					botones[i][j].setIcon(ownPartida.getImagen());
				}
				if (escenarioCargaInt[i][j] == 2) {
					botones[i][j].setName("llegada");
					botones[i][j].setIcon(ownLlegada.getImagen());
				}
				if (escenarioCargaInt[i][j] == 3) {
					botones[i][j].setIcon(ownMuro.getImagen());
				}
				if (escenarioCargaInt[i][j] == 4) {
					botones[i][j].setName("banderin");
					botones[i][j].setIcon(ownBanderin.getImagen());
				}
				botones[i][j].setBorder(BorderFactory
						.createEtchedBorder(BevelBorder.LOWERED));
				botones[i][j].setBackground(Color.darkGray);
				botones[i][j].addActionListener(this);
				panelBotones.add(botones[i][j]);
			}
		}
		return panelBotones;

	}

	/**
	 * Metodo donde se encuentran las opciones de juego contenidas en un panel.
	 * 
	 * @return JPanel, panel con los botones de opción contenidos.
	 */

	public JPanel getPanelOpcionesGame() {
		if (panelOpcionesEdite == null) {
			panelOpcionesEdite = new JPanel();
			panelOpcionesEdite.setLayout(null);
			panelOpcionesEdite.setBounds(809, 7, 200, 135);
			panelOpcionesEdite.setBorder(BorderFactory
					.createEtchedBorder(BevelBorder.LOWERED));
			{
				JLabel score = new JLabel();
				score.setBounds(35, 5, 75, 35);
				score.setIcon(iconScore);
				panelOpcionesEdite.add(score);

				puntuacion = new JLabel();
				puntuacion.setBounds(120, 13, 55, 20);
				puntuacion
						.setFont(new java.awt.Font("Monotype Corsiva", 0, 20));
				puntuacion.setForeground(Color.white);
				puntuacion.setText(Integer.toString(scoreP));

				panelOpcionesEdite.add(puntuacion);

			}

			// Boton de la opción jugar.
			jugar = new JButton();
			panelOpcionesEdite.add(jugar);
			// jugar.setText("Jugar");
			jugar.setBounds(40, 60, 30, 30);
			jugar.addActionListener(this);
			ImageIcon imaJugar = new ImageIcon(getClass().getResource(
					"Imagenes Estc/IconPlayNegro.png"));
			jugar.setIcon(imaJugar);

			{

				// Boton de la opcion recargar.
				again = new JButton();
				panelOpcionesEdite.add(again);
				// again.setText("Recargar");
				again.setBounds(110, 60, 30, 30);
				again.addActionListener(this);
				ImageIcon imaRecargar = new ImageIcon(getClass().getResource(
						"Imagenes Estc/Reload.png"));
				again.setIcon(imaRecargar);

			}
			{

				// Boton de la opcion cambiar de laberinto.
				another = new JButton();
				panelOpcionesEdite.add(another);
				// another.setText("Cambiar Lab");
				another.setBounds(76, 90, 30, 30);
				another.addActionListener(this);
				ImageIcon imaAnother = new ImageIcon(getClass().getResource(
						"Imagenes Estc/Intercambio.jpg"));
				another.setIcon(imaAnother);
			}

		}
		return panelOpcionesEdite;

	}

	public int getScoreP() {
		return scoreP;
	}

	public void setScoreP(int scoreP) {
		this.scoreP = scoreP;
	}

	/**
	 * Metodo que se encarga de obtener el JScrollPane, que devuelve el árbol,
	 * enviandole los pasos para que contruya los nodos de los caminos.
	 * 
	 * @return JScrollPane, Scroll que contiene el árbol.
	 */
	public JScrollPane scrollArbol() {
		arbolCaminos.setVtnJugar(this.getVtnJugar());
		arbolCaminos.setPasos(pasos);
		arbolCaminos.setPnlJugar(this);

		return arbolCaminos.crearArbol();
	}

	public JButton[][] getBotones() {
		return botones;
	}

	public void setBotones(JButton[][] botones) {
		this.botones = botones;
	}

	/**
	 * Metodo que se encarga de instanciar el panel de opciones de el árbol.
	 * 
	 * @return JPanel, panel con las opciones.
	 */
	public JPanel panelChoose() {
		arbolCaminos.setVtnJugar(vtnJugar);
		arbolCaminos.setPasos(pasos);
		arbolCaminos.setPnlJugar(this);
		return arbolCaminos.panelChoose();
	}

	@Override
	/**
	 * Método que se encarga de oir eventos ocasionados por el usuario, 
	 * ya se para jugar, jugar de nuevo o cambiar de laberinto.
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// desbloqueamos el boton jugar, y llamamos a una nueva ventana.
		if (e.getSource() == again) {

			jugar.setEnabled(true);
			arbolChoose = null;
			this.vtnJugar.vtnAgain();
			// vtnJugar.setVisible(false);
			// vtnJugarAgain.setVisible(true);

		}

		// Llamamos a la ventana de jugar nuevamente, lo que ocasiona cambiar de
		// laberinto.
		else if (e.getSource() == another) {

			VentanaJugar vtnJugar = new VentanaJugar();
			// vtnJugar.setVisible(true);
			this.vtnJugar.setVisible(false);
			if (this.vtnJugarAgain != null) {
				this.vtnJugarAgain.setVisible(false);
			}
		}

		/*
		 * Si ya fue escogido un camino válido, llamamos al hilo que simula el
		 * movimiento, y muestra las preguntas.
		 */

		else if (getArbolChoose() != null) {
			if (e.getSource() == jugar) {
				try {
					HiloMov hilo = new HiloMov(ownMov.getImagen(), botones,
							arbolChoose.getPosicion(), this);

					hilo.start();

				} catch (Exception m) {

				}

				jugar.setEnabled(false);

			}
		} else {
			JOptionPane.showMessageDialog(null, "Escoja un camino válido");
		}

	}
}
