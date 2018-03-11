package co.edu.uniquindio.controller;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;

public class HiloSeñalar extends Thread {

	JButton[][] botones;
	ArrayList<Posicion> camino;

	/**
	 * Metodo constructor que recibe la matriz visual, y que escoogió el usuario
	 * para seguir.
	 * 
	 * @param botones
	 * @param camino
	 */
	public HiloSeñalar(JButton[][] botones, ArrayList<Posicion> camino) {
		// TODO Auto-generated constructor stub
		this.botones = botones;
		this.camino = camino;

	}

	/**
	 * Metodo propio de la clase Thread para correr hilos, Aquí señalaremos el
	 * camino escogido por el usuario.
	 */

	public void run() {

		try {

			for (int i = 0; i < botones.length; i++) {
				for (int j = 0; j < botones[0].length; j++) {
					// botones[i][j].setBackground(null);
					botones[i][j].setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					botones[i][j].setBackground(Color.darkGray);
				}

				for (int k = 0; k < camino.size(); k++) {

					botones[camino.get(k).getX()][camino.get(k).getY()]
							.setBorder(BorderFactory
									.createEtchedBorder(BevelBorder.LOWERED));
					botones[camino.get(k).getX()][camino.get(k).getY()]
							.setBackground(Color.red);

				}
				sleep(15);
			}
		} catch (InterruptedException e) {
			System.out.println("Error al ejecutar el metodo sleep");
		}
	}

}
