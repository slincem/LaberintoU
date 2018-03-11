package co.edu.uniquindio.controller;

public class Laberinto {

	int[][] lab;

	public int[][] getLab() {
		return lab;
	}

	public void setLab(int[][] lab) {
		this.lab = lab;
	}
	
	/**
	 * Metodo que se encarga de clonar el laberinto de enteros,
	 * para que al encontrar todas las soluciones y marcar, lo haga sobre 
	 * diferentes laberintos; de esta manera no se afectará en caso de no 
	 * hayar una solución.
	 * @return Laberinto.
	 */

	public Laberinto clonar() {

		Laberinto labClon = new Laberinto();

		int[][] labintClon = new int[lab.length][lab.length];

		for (int i = 0; i < labintClon.length; i++) {
			for (int j = 0; j < labintClon[0].length; j++) {

				labintClon[i][j] = lab[i][j];
			}
		}

		labClon.setLab(labintClon);

		return labClon;
	}

}
