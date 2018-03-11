package co.edu.uniquindio.interfaz;

import java.io.File;

public class FiltroTxt extends javax.swing.filechooser.FileFilter {
	String txt = "txt";

	/**
	 * Verificamos que en el fileChooser efectivamente se escoja un archivo con
	 * extensión txt.
	 */
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < s.length() - 1) {
			String extension = s.substring(i + 1).toLowerCase();

			if (txt.equals(extension)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public String getDescription() {
		return "Archivos.txt";
	}
}
