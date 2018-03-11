package co.edu.uniquindio.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import co.edu.uniquindio.interfaz.VentanaJugar;
import co.edu.uniquindio.interfaz.VentanaMenu;
import co.edu.uniquindio.interfaz.panelJugar;

public class ArbolCaminos extends JFrame implements TreeSelectionListener,
		ActionListener {

	JTree arbol;
	DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Raíz");
	DefaultMutableTreeNode camino;
	ArrayList<Solucion> pasos = new ArrayList<>();
	int banderines;
	int banderinesAct;
	int numCamino;
	Solucion sChoose;
	JScrollPane panelArbol;
	JPanel panelChoose;
	JButton escoger, menu;
	panelJugar pnlJugar;
	VentanaJugar vtnJugar;

	public VentanaJugar getVtnJugar() {
		return vtnJugar;
	}

	public void setVtnJugar(VentanaJugar vtnJugar) {
		this.vtnJugar = vtnJugar;
	}

	public panelJugar getPnlJugar() {
		return pnlJugar;
	}

	public void setPnlJugar(panelJugar pnlJugar) {
		this.pnlJugar = pnlJugar;
	}

	public ArrayList<Solucion> getPasos() {
		return pasos;
	}

	public void setPasos(ArrayList<Solucion> pasos) {
		this.pasos = pasos;
	}

	/**
	 * Metodo que se encarga de crear el ScrollPane del árbol.
	 * 
	 * @JScrollPane con el JTree contenido en él.
	 */

	public JScrollPane crearArbol() {
		if (!pasos.isEmpty()) {
			if (panelArbol == null) {
				panelArbol = new JScrollPane();

				panelArbol.setBounds(809, 150, 200, 300);
				// panelArbol.setOpaque(false);
				panelArbol.setBorder(BorderFactory
						.createEtchedBorder(BevelBorder.LOWERED));

				// poner rutas.
				numCamino = 1;

				banderines = pasos.get(0).getNumBanderines();
				banderinesAct = pasos.get(0).getNumBanderines();

				// Hacemos un llamado al metodo que se encarga de agregar a la
				// raiz
				// los nuevos nodos camino.
				agregarPasos();

				arbol = new JTree(raiz);

				arbol.getSelectionModel().addTreeSelectionListener(this);
				arbol.setBackground(Color.DARK_GRAY);
				arbol.setCellRenderer(new RendererArbol());

				panelArbol.add(arbol);
				panelArbol.setViewportView(arbol);

			}
			panelArbol.setOpaque(false);
			return panelArbol;
		} else {
			return null;
		}
	}

	/**
	 * Método que se encarga de crear el panel de opciones, donde aparecerá
	 * escoger y regresar.
	 * 
	 * @return JPanel con los botones contenidos en él.
	 */

	public JPanel panelChoose() {

		if (panelChoose == null) {
			panelChoose = new JPanel();

			panelChoose.setBounds(809, 480, 200, 100);
			panelChoose.setLayout(null);
			panelChoose.setBorder(BorderFactory
					.createEtchedBorder(BevelBorder.LOWERED));
			{
				menu = new JButton();
				panelChoose.add(menu);
				// menu.setText("Menu");
				menu.setBounds(55, 30, 40, 40);
				ImageIcon imaMenu = new ImageIcon(getClass().getResource(
						"Imagenes Estc/home-negra.jpg"));
				menu.setIcon(imaMenu);
				menu.addActionListener(this);
			}

			{
				escoger = new JButton();
				panelChoose.add(escoger);
				// escoger.setText("Escoger Camino");
				escoger.setBounds(105, 30, 40, 40);
				escoger.addActionListener(this);
				ImageIcon imaEscoger = new ImageIcon(getClass().getResource(
						"Imagenes Estc/iconEscoger.png"));
				escoger.setIcon(imaEscoger);
				if (sChoose == null) {
					escoger.setEnabled(false);
				}
			}

		}

		return panelChoose;

	}

	/**
	 * Método que se encarga de crear nuevos nodos a caminos nuevos, cada vez
	 * que el número de banderines crezca, habrá un camino nuevo
	 * representandolo.
	 */

	public void agregarPasos() {

		// El primer camino corresponde a la primera solución que hay en pasos.
		String nombre1 = Integer.toString(banderines) + " Banderines";
		camino = new DefaultMutableTreeNode(nombre1);

		/*
		 * Recorremos los pasos y cada vez que haya un cambio en el número de
		 * banderines Creamos un nuevo camino.
		 */
		for (Solucion s : pasos) {

			boolean asignado = false;
			/*
			 * Hasta que la solución de pasos no sea asignada, el while no
			 * termina Esto se hace con el proposito de que no siga iterando y
			 * gastando iteraciones del foreach
			 */
			while (!asignado) {
				if (banderinesAct != banderines) {

					String nombre = Integer.toString(banderines)
							+ " Banderines";

					camino = new DefaultMutableTreeNode(nombre);

					banderinesAct = banderines;

				}

				if (banderines == s.getNumBanderines()) {

					String nombre = "Camino " + numCamino + " de: "
							+ Integer.toString(s.getPosicion().size())
							+ " Pasos";
					DefaultMutableTreeNode pasos = new DefaultMutableTreeNode(
							nombre);
					for (int i = 0; i < s.getPosicion().size(); i++) {

						DefaultMutableTreeNode pasoI = new DefaultMutableTreeNode(
								"Paso " + i);
						pasos.add(pasoI);
					}

					camino.add(pasos);
					raiz.add(camino);
					numCamino++;
					asignado = true;
				} else {

					banderines = s.getNumBanderines();

				}
			}
		}

	}

	@Override
	/**
	 * Metodo propio de la intarface TreeSelection Listener, para
	 * detectar cuando se escoja un nuevo nodo en el árbol.
	 */
	public void valueChanged(TreeSelectionEvent p) {
		// TODO Auto-generated method stub

		/*
		 * Aqui, al encontrar que lo escogido en el árbol es igual a una
		 * solución, encontramos la solución y la guardamos.
		 */
		for (int i = 0; i < pasos.size(); i++) {

			int auxConta = i + 1;
			String pasoN = "Camino " + auxConta + " de: "
					+ Integer.toString(pasos.get(i).getPosicion().size())
					+ " Pasos";
			try {
				if (((DefaultMutableTreeNode) p.getNewLeadSelectionPath()
						.getLastPathComponent()).getUserObject().equals(pasoN)) {

					sChoose = pasos.get(i);
					escoger.setEnabled(true);

				}
			} catch (Exception e) {

			}

		}
	}

	@Override
	/**
	 * Método de la interface ActionListener para oir eventos.
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == escoger) {

			HiloSeñalar hiloSenalar = new HiloSeñalar(pnlJugar.getBotones(),
					sChoose.getPosicion());
			hiloSenalar.start();
			pnlJugar.setArbolChoose(sChoose);

		}
		if (e.getSource() == menu) {
			VentanaMenu menu = new VentanaMenu();

			if (pnlJugar.getVtnJugar() != null) {
				pnlJugar.getVtnJugar().setVisible(false);
			}
			if (pnlJugar.getVtnJugarAgain() != null) {
				pnlJugar.getVtnJugarAgain().setVisible(false);
			}
		}

	}

}