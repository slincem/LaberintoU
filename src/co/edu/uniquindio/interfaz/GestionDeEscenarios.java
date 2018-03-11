package co.edu.uniquindio.interfaz;

import java.awt.Label;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.*;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GestionDeEscenarios extends JFrame implements ComponentListener {

	static JPanel panelMatrizLabel;
	static int tamanoGlobal;
	private int[][] escenarioCarga;
	private VentanaJugar vtnJugar;
	private VentanaEditar vtnEditar;
	private String nomArchivo = null;

	/**
	 * @return the nomArchivo
	 */
	public String getNomArchivo() {
		return nomArchivo;
	}

	/**
	 * @param nomArchivo
	 *            the nomArchivo to set
	 */
	public void setNomArchivo(String nomArchivo) {
		this.nomArchivo = nomArchivo;
	}

	/**
	 * Metodo que se encarga de recibir la matriz visual, para que de acuerdo al
	 * icono que haya en su celda, transforme en una matriz de enteros.
	 * 
	 * @param escenarioButon
	 *            , Matriz visual de botones.
	 * @param cositos
	 *            , Iconos contenidos en las celdas de los botones,
	 * @return Matriz de Enteros.
	 */

	public int[][] llenarMatriz(JButton[][] escenarioButon, ImageIcon[] cositos) {
		// TODO Auto-generated method stub

		int[][] escenario = new int[escenarioButon.length][escenarioButon.length];
		int conPartida = 0;
		int conLlegada = 0;
		for (int i = 0; i < escenario.length; i++) {
			for (int j = 0; j < escenario.length; j++) {

				if (escenarioButon[i][j].getIcon().equals(cositos[0])) {
					escenario[i][j] = 0;
				}
				if (escenarioButon[i][j].getIcon().equals(cositos[1])) {
					escenario[i][j] = 1;
					conPartida++;
				}
				if (escenarioButon[i][j].getIcon().equals(cositos[2])) {
					escenario[i][j] = 2;
					conLlegada++;
				}
				if (escenarioButon[i][j].getIcon().equals(cositos[3])) {
					escenario[i][j] = 3;
				}
				if (escenarioButon[i][j].getIcon().equals(cositos[4])) {
					escenario[i][j] = 4;
				}
			}
		}
		if (conLlegada == 1 && conPartida == 1) {
			String nombreArchivo;
			if (getNomArchivo() == null) {
				nombreArchivo = JOptionPane
						.showInputDialog("Ingrese el nombre del archivo");
			} else {
				nombreArchivo = getNomArchivo();
			}
			try {
				escribirArchivo(escenario, nombreArchivo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
			JOptionPane
					.showMessageDialog(null, "El laberinto ha sido guardado");

		} else {
			/*
			 * Debe haber 1 entrada y 1 salida, en caso de que no, se muestra un
			 * mensaje haciendolo saber.
			 */
			JOptionPane
					.showMessageDialog(null,
							"Señor usuario debe haber una sola llegada y una sola salida. Corrija!! ");

		}
		return escenario;
	}

	/**
	 * Metodo encargado de escribir la matriz de enteros en un archivo para
	 * guardar esta información, y poder mostrarla en caso de que se quiera
	 * editar o jugar.
	 * 
	 * @param escenario
	 *            , Escenario de enteros (Matriz de enteros)
	 * @param arc
	 *            , Ruta del archivo en la cual guardaremos el proyecto.
	 * @throws IOException
	 */
	private void escribirArchivo(int[][] escenario, String arc)
			throws IOException {
		if (!arc.contains(".txt")) {
			arc = arc + ".txt";
		}

		File archivo = new File("Escenarios/" + arc);
		// pregunta si existe el archivo txt.
		if (!archivo.exists()) {
			// crea el archivo de txt.
			archivo.createNewFile();
		}
		// instancias de clases.

		FileWriter ficheroGrado = null;
		PrintWriter pw = null;

		try {

			ficheroGrado = new FileWriter(archivo, false);
			pw = new PrintWriter(ficheroGrado);
			// escribimos en el archivo txt.

			for (int i = 0; i < escenario.length; i++) {
				for (int j = 0; j < escenario.length; j++) {
					pw.print((escenario[i][j] + ","));
				}
				pw.println();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// si el archivo no contiene dato.
				if (null != ficheroGrado)
					// cierre el archivo.
					ficheroGrado.close();
			} catch (Exception e2) {// posible excepcion

				System.out.println("Error al escribir");
			}
		}
	}

	/**
	 * Metodo que se encarga de leer un archivo, para poder jugarlo.
	 * 
	 * @param archivo
	 *            , Archivo que contiene la matriz de enteros que se pasará a
	 *            matriz visual.
	 * @throws ExcepcionPersonalizada
	 *             , Excepcion propia para mostrar un posible error.
	 */

	public void leerArchivoPlay(File archivo) throws ExcepcionPersonalizada {

		BufferedReader reader = null;

		try {
			int k = 0;

			BufferedReader reader1 = new BufferedReader(new FileReader(archivo));
			String lineaAux = reader1.readLine();
			k = lineaAux.split(",").length;
			reader1.close();

			reader = new BufferedReader(new FileReader(archivo));
			String linea;

			int t = 0;

			escenarioCarga = new int[k][k];

			while ((linea = reader.readLine()) != null) {
				String[] ayuda = linea.split(",");
				for (int i = 0; i < k; i++) {
					escenarioCarga[t][i] = Integer.parseInt(ayuda[i]);
				}
				t++;
			}

		} catch (Exception ex) {
			escenarioCarga = null;
			throw new ExcepcionPersonalizada("Ingtreso no valido ");

		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e) {
				escenarioCarga = null;
				throw new ExcepcionPersonalizada("Ingtreso no valido ");

			}
		}

	}

	/**
	 * Metodo que se encarga de leer un archivo para poder editarlo, éste
	 * volverá a ser una matriz visual para que el usuario pueda cambiarlo.
	 * 
	 * @param archivo
	 *            , archivo que contiene la matriz de enteros.
	 * @throws ExcepcionPersonalizada
	 *             , excepcion propia para mostrar un posible error.
	 */

	public void leerArchivoEdite(File archivo) throws ExcepcionPersonalizada {

		BufferedReader reader = null;

		try {
			int k = 0;

			BufferedReader reader1 = new BufferedReader(new FileReader(archivo));
			String lineaAux = reader1.readLine();
			k = lineaAux.split(",").length;
			reader1.close();

			reader = new BufferedReader(new FileReader(archivo));
			String linea;

			int t = 0;

			escenarioCarga = new int[k][k];

			while ((linea = reader.readLine()) != null) {
				String[] ayuda = linea.split(",");
				for (int i = 0; i < k; i++) {

					escenarioCarga[t][i] = Integer.parseInt(ayuda[i]);
				}
				t++;
			}

		} catch (Exception ex) {
			escenarioCarga = null;
			throw new ExcepcionPersonalizada("Ingtreso no valido ");

		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e) {
				escenarioCarga = null;
				throw new ExcepcionPersonalizada("Ingtreso no valido ");

			}
		}
	}

	public VentanaJugar getVtnJugar() {
		return vtnJugar;
	}

	public void setVtnJugar(VentanaJugar vtnJugar) {
		this.vtnJugar = vtnJugar;
	}

	public VentanaEditar getVtnEditar() {
		return vtnEditar;
	}

	public void setVtnEditar(VentanaEditar vtnEditar) {
		this.vtnEditar = vtnEditar;
	}

	public int[][] getEscenarioCarga() {
		return escenarioCarga;
	}

	public void setEscenarioCarga(int[][] escenarioCarga) {
		this.escenarioCarga = escenarioCarga;
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
