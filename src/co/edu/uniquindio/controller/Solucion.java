package co.edu.uniquindio.controller;

import java.util.ArrayList;

public class Solucion {
	int numBanderines;
	ArrayList<Posicion> posicion = new ArrayList<>();

	public int getNumBanderines() {
		return numBanderines;
	}

	public void setNumBanderines(int numBanderines) {
		this.numBanderines = numBanderines;
	}

	public ArrayList<Posicion> getPosicion() {
		return posicion;
	}

	public void setPosicion(ArrayList<Posicion> posicion) {
		this.posicion = posicion;
	}

}
