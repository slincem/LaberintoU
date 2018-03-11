package co.edu.uniquindio.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

public class RendererArbol extends JLabel implements TreeCellRenderer {
	private ImageIcon imgRaiz;
	private ImageIcon[] imgBanderines;

	private boolean seleccionado;

	/**
	 * Metodo constructor que se encarga de iniciar las imagenes que se
	 * incluiran en el árbol en caso de éste renderer ser llamado.
	 */
	public RendererArbol() {
		// Cargamos las imgenes de las cartas
		imgRaiz = new ImageIcon(getClass().getResource(
				"Imagenes Estc/Blue_ball.png"));

		imgBanderines = new ImageIcon[9];

		imgBanderines[0] = new ImageIcon(getClass().getResource(
				"Imagenes Estc/Imagen9.png"));
		imgBanderines[1] = new ImageIcon(getClass().getResource(
				"Imagenes Estc/Imagen8.png"));
		imgBanderines[2] = new ImageIcon(getClass().getResource(
				"Imagenes Estc/Imagen7.png"));
		imgBanderines[3] = new ImageIcon(getClass().getResource(
				"Imagenes Estc/Imagen3.png"));
		imgBanderines[4] = new ImageIcon(getClass().getResource(
				"Imagenes Estc/Imagen4.png"));
		imgBanderines[5] = new ImageIcon(getClass().getResource(
				"Imagenes Estc/Imagen6.png"));
		imgBanderines[6] = new ImageIcon(getClass().getResource(
				"Imagenes Estc/Imagen1.png"));
		imgBanderines[7] = new ImageIcon(getClass().getResource(
				"Imagenes Estc/Imagen2.png"));
		imgBanderines[8] = new ImageIcon(getClass().getResource(
				"Imagenes Estc/Imagen5.png"));

	}

	/**
	 * Metodo encargado de darle el modelo que queremos al árbol, utilizando las
	 * imagenes inicializadas en su constructor.
	 */
	public Component getTreeCellRendererComponent(JTree arbol, Object valor,
			boolean seleccionado, boolean expandido, boolean rama, int fila,
			boolean conFoco) {
		// Hay que encontrar el nodo en que estamos y coger el
		// texto que contiene

		DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) valor;
		String texto = (String) nodo.getUserObject();
		this.seleccionado = seleccionado;
		// Se fija el color de fondo en función de que esté o no
		// seleccionada la celda del árbol
		if (!seleccionado)
			setForeground(Color.black);
		else
			setForeground(Color.white);
		// Fijamos el icono que corresponde al texto de la celda, para
		// presentar la imagen de la carta que corresponde a esa celda
		if (texto.equals("Raíz"))
			setIcon(imgRaiz);
		else if (texto.equals("0 Banderines"))
			setIcon(imgBanderines[0]);
		else if (texto.equals("1 Banderines"))
			setIcon(imgBanderines[1]);
		else if (texto.equals("2 Banderines"))
			setIcon(imgBanderines[2]);
		else if (texto.equals("3 Banderines"))
			setIcon(imgBanderines[3]);
		else if (texto.equals("4 Banderines"))
			setIcon(imgBanderines[4]);
		else if (texto.equals("5 Banderines"))
			setIcon(imgBanderines[5]);
		else if (texto.equals("6 Banderines"))
			setIcon(imgBanderines[6]);
		else if (texto.equals("7 Banderines"))
			setIcon(imgBanderines[7]);
		else if (texto.equals("8 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("9 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("10 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("11 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("12 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("13 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("14 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("15 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("16 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("17 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("18 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("19 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("20 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("21 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("22 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("23 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("24 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("25 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("26 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("27 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("28 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("29 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("30 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("31 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("32 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("33 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("34 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("35 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("36 Banderines"))
			setIcon(imgBanderines[8]);
		else if (texto.equals("37 Banderines"))
			setIcon(imgBanderines[8]);

		// A continuación del icono, ponemos el texto
		setText(texto);

		return (this);
	}

	/**
	 * Metodo en el que sobreescribimos el método paint() para fijar el color de fondo.
	 * Normalmente, un JLabel puede pintar su propio fondo, pero, seguramente
	 * debido aparentemente a un bug, o a una limitación en el TreeCellRenderer,
	 * es necesario recurrir al método paint() para hacer esto
	 */

	public void paint(Graphics g) {
		Color color;
		Icon currentI = getIcon();

		// Fijamos el colos de fondo
		color = seleccionado ? Color.red : null;
		g.setColor(color);
		// Rellenamos el rectángulo que ocupa el texto sobre la
		// celda del árbol
		g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

		super.paint(g);
	}

}