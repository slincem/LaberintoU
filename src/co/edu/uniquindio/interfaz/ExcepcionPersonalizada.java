package co.edu.uniquindio.interfaz;

public class ExcepcionPersonalizada extends Exception {

	/**
	 * @param mensajePersonalizado
	 */
	public ExcepcionPersonalizada(String mensajePersonalizado) {
		super();
		this.mensajePersonalizado = mensajePersonalizado;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mensajePersonalizado;

	/**
	 * @return the mensajePersonalizado
	 */
	public final String getMensajePersonalizado() {
		return mensajePersonalizado;
	}

	/**
	 * @param mensajePersonalizado
	 *            the mensajePersonalizado to set
	 */
	public final void setMensajePersonalizado(String mensajePersonalizado) {
		this.mensajePersonalizado = mensajePersonalizado;
	}
}
