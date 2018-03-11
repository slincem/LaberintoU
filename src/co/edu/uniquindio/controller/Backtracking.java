package co.edu.uniquindio.controller;

import java.util.ArrayList;
import java.util.Arrays;

public class Backtracking {
	private ArrayList<Solucion> solu = new ArrayList<>();
	private ArrayList<Solucion> soluAux = new ArrayList<>();

	public ArrayList<Solucion> getSolu() {
		return solu;
	}

	public void setSolu(ArrayList<Solucion> solu) {
		this.solu = solu;
	}

	/**
	 * Método encargado de ejecutar todos los demás metodos, así, todas las
	 * variables quedarán inicializadas y podemos proceder a tomar sus valores.
	 * 
	 * @param labEnt
	 */

	public void Application(int[][] labEnt) {

		int[] entrada = new int[2];

		/*
		 * Encontramos la entrada, para enviar esta como posicion de inicio al
		 * laberinto.
		 */
		for (int i = 0; i < labEnt.length; i++) {
			for (int j = 0; j < labEnt.length; j++) {

				if (labEnt[i][j] == 1) {
					entrada[0] = i;
					entrada[1] = j;
				}
			}
		}

		int i = entrada[0];
		int j = entrada[1];

		ArrayList<Posicion> pos = new ArrayList<>();

		//Creamos una objeto laberinto, para poder clonar este.
		Laberinto lab = new Laberinto();
		lab.setLab(labEnt);

		/*
		 * Aqui hacemos llamado a los metodos que se encargan de organizar nuestras
		 *  soluciones.
		 */
		backtracking(lab.clonar(), i, j, pos);
		contaBanderines(labEnt);
		ordenarSolucion();

	}

	/**
	 * Metodo que ordena el arraylist de pasos, para que en el momento de que el
	 * árbol lo reciba, imprima los caminos en orden de los banderines
	 * contenidos en las soluciones.
	 */

	private void ordenarSolucion() {
		// TODO Auto-generated method stub

		while (!solu.isEmpty()) {
			int menorBand = 900;
			for (int i = 0; i < solu.size(); i++) {

				if (menorBand > solu.get(i).getNumBanderines()) {

					menorBand = solu.get(i).getNumBanderines();
				}
			}

			for (int i = 0; i < solu.size(); i++) {

				if (solu.get(i).getNumBanderines() == menorBand) {
					soluAux.add(solu.get(i));
					solu.remove(solu.get(i));
				}

			}
		}

		solu = soluAux;
		soluAux = new ArrayList<>();
	}

	/**
	 * Metodo que se encarga de contar los banderines en una solución, y
	 * agregarlo a la otra variable "numBanderines", y creamos una nueva
	 * solución que contiene ahora, ambos atributos.
	 * 
	 * @param laberinto
	 */
	public void contaBanderines(int[][] laberinto) {
		for (int i = 0; i < solu.size(); i++) {
			ArrayList<Posicion> posiciones = solu.get(i).getPosicion();
			int contaBanderines = 0;
			for (int j = 0; j < posiciones.size(); j++) {
				int x = posiciones.get(j).getX();
				int y = posiciones.get(j).getY();
				if (laberinto[x][y] == 4) {
					contaBanderines += 1;
				}
			}
			Solucion solucion = new Solucion();
			solucion.setNumBanderines(contaBanderines);
			solucion.setPosicion(posiciones);
			solu.set(i, solucion);
		}

	}

	/**
	 * Metodo que se encarga de encontrar todas las posibles soluciones del
	 * laberinto.
	 * 
	 * @param lab
	 *            , Laberinto.
	 * @param i
	 *            , Fila de la entrada,
	 * @param j
	 *            , columna de la entrada
	 * @param pos
	 *            , arreglo de posiciones que llevan a la solución.
	 */
	public void backtracking(Laberinto lab, int i, int j,
			ArrayList<Posicion> pos) {
		// TODO Auto-generated method stub

		int[][] labInt = lab.getLab();

		if (esPosible(labInt, i, j)) {

			if (labInt[i][j] == 2) {

				Posicion posicion = new Posicion();
				posicion.setX(i);
				posicion.setY(j);
				pos.add(posicion);

				Solucion solucion = new Solucion();

				solucion.setPosicion(pos);
				solu.add(solucion);
			}

			else {
				marcarLaberinto(labInt, i, j);

				Posicion posicion = new Posicion();

				posicion.setX(i);
				posicion.setY(j);

				pos.add(posicion);

				backtracking(lab.clonar(), i + 1, j,
						(ArrayList<Posicion>) pos.clone());

				backtracking(lab.clonar(), i, j + 1,
						(ArrayList<Posicion>) pos.clone());

				backtracking(lab.clonar(), i - 1, j,
						(ArrayList<Posicion>) pos.clone());

				backtracking(lab.clonar(), i, j - 1,
						(ArrayList<Posicion>) pos.clone());

			}
		}

	}

	/**
	 * Metodo que se encarga de analizar si podemos avanzar por una celda.
	 * 
	 * @param labInt
	 *            , Laberinto.
	 * @param i
	 *            , fila de la celda a analizar.
	 * @param j
	 *            , columna de la celda a analizar.
	 * @return
	 */
	private boolean esPosible(int[][] labInt, int i, int j) {
		// TODO Auto-generated method stub
		if (i >= 0 && i < labInt.length && j >= 0 && j < labInt[0].length
				&& labInt[i][j] != 3 && labInt[i][j] != 8) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que se encarga de marcar una celda para conocer que esta ya fue
	 * recorrida.
	 * 
	 * @param labInt
	 *            , Laberinto
	 * @param i
	 *            , fila de la celda a marcar.
	 * @param j
	 *            , columna de la celda a marcar.
	 */

	private void marcarLaberinto(int[][] labInt, int i, int j) {
		// TODO Auto-generated method stub
		labInt[i][j] = 8;
	}

}
