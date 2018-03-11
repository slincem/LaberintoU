package co.edu.uniquindio.controller;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class LecturaPreguntas {

	/**
	 * Metodo encargado de leer el archivo de texto con las preguntas
	 * para meter estas dentro de un ArrayList.
	 * @return
	 */

	public static ArrayList<ArrayList> leer() {
		ArrayList<ArrayList> preguntas = new ArrayList<>();
		File file = new File("Preguntas Laberinto.txt");
		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			int cont = 0;
			ArrayList<String[]> pregunta = new ArrayList<>();
			while ((linea = br.readLine()) != null) {

				if (cont < 5) {
					String[] array = linea.split(";");

					pregunta.add(array);
					cont++;
				} else {
					cont = 0;
					preguntas.add(pregunta);
					pregunta = new ArrayList<>();
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preguntas;
	}

	/**
	 * Aquí del arraylist que contiene las preguntas leidas
	 * las pasamos aleaoteamente a una pila, para que en cada ejecución de
	 * la aplicación estas no se muestren en el mismo orden.
	 * @param preguntas
	 * @return
	 */
	public static Stack<ArrayList> pila(ArrayList<ArrayList> preguntas) {

		Stack<ArrayList> preguntasAleatorias = new Stack<>();
		int tam = preguntas.size();
		while (preguntas.size() != 0) {
			int n = (int) (Math.random() * tam);
			preguntasAleatorias.add(preguntas.remove(n));
			tam--;
		}
		return preguntasAleatorias;
	}

}
