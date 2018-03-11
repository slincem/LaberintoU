package co.edu.uniquindio.interfaz;

import javax.swing.ImageIcon;

public class OwnImage extends ImageIcon{

	ImageIcon imagen;

	String nombre;
	
	/**
	 * Metodo constructor para hacer nuestra propia clase ocn una imagen y un nombre
	 * asociado. Para así poder comparar éste segundo atributo y tomar ciertas decisiones.
	 * @param nombre, nombre de la imagen
	 * @param imagen, icono de la imagen.
	 */

	public OwnImage(String nombre, ImageIcon imagen) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.imagen = imagen;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
