package co.edu.uniquindio.interfaz;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImagenFondo extends JPanel {

	ImageIcon imagen;
	String nombre;

	/**
	 * Metodo constructor, que recibe el nombre de la imagen que contendran los
	 * paneles creados de esta clase.
	 * 
	 * @param n
	 *            , nombre de la imagen
	 */

	public PanelImagenFondo(String n) {
		this.nombre = n;
		this.setLayout(null);
	}

	/**
	 * Metodo que pinta la imagen en el panel.
	 */
	public void paint(Graphics g) {
		Dimension tamano = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamano.width, tamano.height, null);
		setOpaque(false);
		super.paint(g);
	}

}
