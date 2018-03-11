//package co.edu.uniquindio.controller;
//
//import java.awt.Color;
//import java.util.ArrayList;
//import java.util.LinkedList;
//
//import javax.swing.ButtonGroup;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JOptionPane;
//import javax.swing.JRadioButton;
//
//import co.edu.uniquindio.interfaz.OwnImage;
//
//public class HiloMov extends Thread {
//
//	JButton[][] botones;
//	ImageIcon imagen;
//	ArrayList<Posicion> pasos;
//	private ImageIcon iconLibre = new ImageIcon(
//			"C:/Users/USER/Desktop/U/Programacion/Estructura de Datos/Proyecto Final/ProyectoFinal0/Imagenes Estc/"
//					+ "wall red.png");
//	private ImageIcon iconBanderin = new ImageIcon(
//			"C:/Users/USER/Desktop/U/Programacion/Estructura de Datos/Proyecto Final/ProyectoFinal0/Imagenes Estc/boo_32.png");
//
//	public HiloMov(ImageIcon imagen, JButton[][] botones,
//			ArrayList<Posicion> pasos) {
//		// TODO Auto-generated constructor stub
//		this.imagen = imagen;
//		this.botones = botones;
//		this.pasos = pasos;
//
//	}
//
//	public void run() {
//
//		try {
//
//			for (int i = 0; i < pasos.size(); i++) {
//				int x = pasos.get(i).getX();
//				int y = pasos.get(i).getY();
//				if (i == 1) {
//
//					botones[x][y].setIcon(imagen);
//				}
//				if (i >= 2 && i < pasos.size() - 1) {
//
//					if (botones[x][y].getName().equals("banderin")) {
//						ImageIcon ima = new ImageIcon(
//								"D:/ProyectoFinal0/question_coin_101421.JPG");
//						JRadioButton[] rad = new JRadioButton[4];
//						rad[0] = new JRadioButton(
//								"jniurencujneriufiuncfiurnuiniruencjkeirnieu",
//								ima);
//						rad[1] = new JRadioButton("a)");
//						rad[2] = new JRadioButton("b)");
//						rad[3] = new JRadioButton("c)");
//
//						rad[0].setBackground(Color.black);
//						rad[1].setBackground(Color.red);
//						rad[2].setBackground(Color.green);
//						rad[3].setBackground(Color.white);
//
//						ButtonGroup btn = new ButtonGroup();
//						btn.add(rad[0]);
//						btn.add(rad[1]);
//						btn.add(rad[2]);
//						btn.add(rad[3]);
//
//						JOptionPane.showOptionDialog(null, rad, "pregunta",
//								JOptionPane.PLAIN_MESSAGE,
//								JOptionPane.PLAIN_MESSAGE, null, null, null);
//
//					}
//					botones[x][y].setIcon(imagen);
//
//					botones[pasos.get(i - 1).getX()][pasos.get(i - 1).getY()]
//							.setIcon(iconLibre);
//				}
//				if (i == (pasos.size() - 1)) {
//					botones[x][y].setIcon(imagen);
//					botones[pasos.get(i - 1).getX()][pasos.get(i - 1).getY()]
//							.setIcon(iconLibre);
//				}
//				sleep(100);
//			}
//
//		} catch (InterruptedException ex) {
//
//			System.out.println("Error al ejecutar el metodo sleep");
//		}
//	}
//	
//	public void preguntas(LinkedList preguntas){
//		
//		
//	}
//	
//	
//}

package co.edu.uniquindio.controller;

import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import co.edu.uniquindio.interfaz.OwnImage;
import co.edu.uniquindio.interfaz.PanelImagenFondo;
import co.edu.uniquindio.interfaz.panelJugar;

public class HiloMov extends Thread {

	// Declaramos todas las variables que utilizaremos, ya sean logicas o
	// visuales.
	panelJugar pnlJugar;
	JButton[][] botones;
	ImageIcon imagen;
	ArrayList<Posicion> pasos;
	private ImageIcon iconLibre = new ImageIcon(getClass().getResource(
			"Imagenes Estc/suelo.jpg"));
	private ImageIcon iconBanderin = new ImageIcon(getClass().getResource(
			"Imagenes Estc/boo_32.png"));

	/**
	 * Aquí el constructor recibe por parametro el laberinto visual, es decir,
	 * la matriz de botones, la imagen que estaremos enviando para mostrar el
	 * movimiento del personaje, los pasos que el personaje seguirá, y el panel
	 * donde se mostrará.
	 * 
	 * @param imagen
	 *            , Imagen que será mostrada.
	 * @param botones
	 *            , matriz visual.
	 * @param pasos
	 *            , arreglo de pasos a seguir por el personaje.
	 * @param pnlJugar
	 */

	public HiloMov(ImageIcon imagen, JButton[][] botones,
			ArrayList<Posicion> pasos, panelJugar pnlJugar) {
		// TODO Auto-generated constructor stub
		this.imagen = imagen;
		this.botones = botones;
		this.pasos = pasos;
		this.pnlJugar = pnlJugar;

	}

	/**
	 * Metodo propio de la clase Thread, para la ejecución de el hilo. Aquí, se
	 * mostraran las preguntas, y se hará avanzar al personaje hasta el final,
	 * manejando la puntuación que este lleve.
	 * 
	 */

	public void run() {

		// Aquí creamos la pila con las preguntas de reacreditación
		Stack<ArrayList> pilaPreguntas = new Stack();
		LecturaPreguntas lec2 = new LecturaPreguntas();
		ArrayList<ArrayList> pregu2 = lec2.leer();
		pilaPreguntas = lec2.pila(pregu2);
		try {

			// Creamos dos variables para conocer cuando estemos en la celda
			// final.
			int xF = pasos.get(pasos.size() - 1).getX();
			int yF = pasos.get(pasos.size() - 1).getY();

			/*
			 * Con este for, hacemos avanzar por los pasos de la solución al
			 * personaje. Mientas que este se va encontrando con las preguntas y
			 * la puntuacion va camiando.
			 */
			for (int i = 0; i < pasos.size(); i++) {
				int x = pasos.get(i).getX();
				int y = pasos.get(i).getY();
				botones[x][y].setBackground(Color.darkGray);
				if (i == 1) {

					botones[x][y].setIcon(imagen);
				}
				if (i >= 2 && i < pasos.size() - 1) {

					if (botones[x][y].getName().equals("banderin")) {

						try {
							preguntasLaberinto(pilaPreguntas);
						} catch (Exception e) {
							// TODO: handle exception
							JOptionPane
									.showMessageDialog(null,
											"HAS PERDIDO, POR FAVOR RECARGA EL LABERINTO ó ELIGE UNO NUEVO");
							stop();
						}

					}
					botones[x][y].setIcon(imagen);
					botones[pasos.get(i - 1).getX()][pasos.get(i - 1).getY()]
							.setIcon(iconLibre);

				}
				if (i == (pasos.size() - 1)) {
					botones[x][y].setBackground(Color.darkGray);
					botones[x][y].setIcon(imagen);
					botones[pasos.get(i - 1).getX()][pasos.get(i - 1).getY()]
							.setIcon(iconLibre);

				}

				sleep(140);
			}
			ImageIcon ima = new ImageIcon(getClass().getResource(
					"Imagenes Estc/marioFinal.gif"));
			UIManager.put("OptionPane.background", Color.white);
			UIManager.put("Panel.background", Color.white);
			JOptionPane.showMessageDialog(null, ima, "GANASTE!!!!!",
					JOptionPane.PLAIN_MESSAGE);

		} catch (InterruptedException ex) {

			System.out.println("Error al ejecutar el metodo sleep");
		}
	}

	/**
	 * Metodo que se encarga de mostrar las preguntas, sacandola de la pila y
	 * mostrandola en JOptionPane. Ayudado de radio botones.
	 * 
	 * @param pilaPreguntas
	 *            , Pila que contiene las preguntas.
	 */

	public void preguntasLaberinto(Stack<ArrayList> pilaPreguntas) {

		ImageIcon ima = new ImageIcon(getClass().getResource(
				"Imagenes Estc/question_coin_101421.jpg"));

		JRadioButton[] rad = new JRadioButton[5];
		ButtonGroup btn = new ButtonGroup();
		ArrayList<String[]> pregunta = new ArrayList<>();
		try {
			pregunta = pilaPreguntas.pop();
		} catch (Exception e) {
			// TODO: handle exception
		}

		String[] linea = (String[]) pregunta.get(0);
		rad[0] = new JRadioButton(linea[1], ima);
		rad[0].setBackground(Color.white);
		btn.add(rad[0]);
		for (int k = 1; k < pregunta.size(); k++) {
			linea = (String[]) pregunta.get(k);
			rad[k] = new JRadioButton(linea[1], null);
			rad[k].setBackground(Color.white);
			btn.add(rad[k]);
		}
		UIManager.put("OptionPane.background", Color.white);
		UIManager.put("Panel.background", Color.white);
		int respuesta = JOptionPane.showOptionDialog(null, rad, "pregunta",
				JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null,
				null, null);
		verificarPregunta(rad, respuesta, pilaPreguntas, pregunta);

	}

	/**
	 * Método que se encarga de verificar si la respuesta de el usuario es correcta o no;
	 * para así mostrar de nuevo la pregunta en caso de eror e incrementar o decrementar 
	 * la puntuación.
	 * @param rad
	 * @param respuesta
	 * @param pilaPreguntas
	 * @param pregunta
	 */
	public void verificarPregunta(JRadioButton[] rad, int respuesta,
			Stack pilaPreguntas, ArrayList<String[]> pregunta) {

		if (respuesta == 0) {

			if (rad[0].isSelected()) {
				UIManager.put("OptionPane.background", Color.white);
				UIManager.put("Panel.background", Color.white);
				JOptionPane.showMessageDialog(null,
						"ELIJA UNA DE LAS RESPUESTAS");
				UIManager.put("OptionPane.background", Color.white);
				UIManager.put("Panel.background", Color.white);
				respuesta = JOptionPane.showOptionDialog(null, rad, "Pregunta",
						JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE,
						null, null, null);
			} else if (rad[1].isSelected()) {
				String[] lineaPregunta = pregunta.get(1);
				if (lineaPregunta[0].equalsIgnoreCase("+")) {
					pnlJugar.setScoreP(pnlJugar.getScoreP() + 5);
					pnlJugar.puntuacion.setText(Integer.toString(pnlJugar
							.getScoreP()));

					JOptionPane.showMessageDialog(null, "MUY BIEN");
				} else {
					pnlJugar.setScoreP(pnlJugar.getScoreP() - 5);
					pnlJugar.puntuacion.setText(Integer.toString(pnlJugar
							.getScoreP()));
					JOptionPane.showMessageDialog(null,
							"TU RESPUESTA HA SIDO INCORRECTA");
					if (!comprobarPuntuacion()) {
						preguntasLaberinto(pilaPreguntas);
					}
				}
			} else if (rad[2].isSelected()) {
				String[] lineaPregunta = pregunta.get(2);
				if (lineaPregunta[0].equalsIgnoreCase("+")) {
					pnlJugar.setScoreP(pnlJugar.getScoreP() + 5);
					pnlJugar.puntuacion.setText(Integer.toString(pnlJugar
							.getScoreP()));
					JOptionPane.showMessageDialog(null, "MUY BIEN");

				} else {
					pnlJugar.setScoreP(pnlJugar.getScoreP() - 5);
					pnlJugar.puntuacion.setText(Integer.toString(pnlJugar
							.getScoreP()));
					JOptionPane.showMessageDialog(null,
							"TU RESPUESTA HA SIDO INCORRECTA");
					if (!comprobarPuntuacion()) {
						preguntasLaberinto(pilaPreguntas);
					}

				}
			} else if (rad[3].isSelected()) {
				String[] lineaPregunta = pregunta.get(3);
				if (lineaPregunta[0].equalsIgnoreCase("+")) {
					pnlJugar.setScoreP(pnlJugar.getScoreP() + 5);
					pnlJugar.puntuacion.setText(Integer.toString(pnlJugar
							.getScoreP()));
					JOptionPane.showMessageDialog(null, "MUY BIEN");
				} else {
					pnlJugar.setScoreP(pnlJugar.getScoreP() - 5);

					pnlJugar.puntuacion.setText(Integer.toString(pnlJugar
							.getScoreP()));
					JOptionPane.showMessageDialog(null,
							"TU RESPUESTA HA SIDO INCORRECTA");
					if (!comprobarPuntuacion()) {
						preguntasLaberinto(pilaPreguntas);
					}

				}
			} else if (rad[4].isSelected()) {
				String[] lineaPregunta = pregunta.get(4);
				if (lineaPregunta[0].equalsIgnoreCase("+")) {
					pnlJugar.setScoreP(pnlJugar.getScoreP() + 5);
					pnlJugar.puntuacion.setText(Integer.toString(pnlJugar
							.getScoreP()));
					JOptionPane.showMessageDialog(null, "MUY BIEN");
				} else {
					pnlJugar.setScoreP(pnlJugar.getScoreP() - 5);
					pnlJugar.puntuacion.setText(Integer.toString(pnlJugar
							.getScoreP()));
					JOptionPane.showMessageDialog(null,
							"TU RESPUESTA HA SIDO INCORRECTA");
					if (!comprobarPuntuacion()) {
						preguntasLaberinto(pilaPreguntas);
					}
				}
			} else {

				JOptionPane.showMessageDialog(null,
						"NO HAS ELEGIDO UNA RESPUESTA");
				respuesta = JOptionPane.showOptionDialog(null, rad, "pregunta",
						JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE,
						null, null, null);
				verificarPregunta(rad, respuesta, pilaPreguntas, pregunta);
			}
		} else {

			JOptionPane.showMessageDialog(null, "NO HAS ELEGIDO UNA RESPUESTA");
			respuesta = JOptionPane.showOptionDialog(null, rad, "pregunta",
					JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null,
					null, null);
			verificarPregunta(rad, respuesta, pilaPreguntas, pregunta);
		}
	}

	/**
	 * Comprueba la puntuación para determinar si el usuario ya perdió todos sus puntos.
	 * @return True o False.
	 */
	public boolean comprobarPuntuacion() {
		if (pnlJugar.getScoreP() == 0) {
			JOptionPane.showMessageDialog(null, "Perdiste");
			ImageIcon ima = new ImageIcon(getClass().getResource(
					"Imagenes Estc/triste.gif"));
			UIManager.put("OptionPane.background", Color.BLACK);
			UIManager.put("Panel.background", Color.BLACK);
			JOptionPane.showMessageDialog(null, ima, "PERDISTE!!!!!",
					JOptionPane.PLAIN_MESSAGE);
			return true;
		}
		return false;

	}

}
