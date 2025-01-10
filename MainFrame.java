import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MainFrame extends javax.swing.JFrame {
	double mutationProbability;
	int numberOfGenerations;
	int populationSize;
	int materialWidth;
	int materialHeight;

	List<Rectangle> rectangles = new ArrayList<Rectangle>();
	int rectCount = 1;

	public MainFrame() {
		initComponents();
	}

	private void initComponents() {
		ajustesPanel = new javax.swing.JPanel();
		materialLabel = new java.awt.Label();
		xMatLbl = new java.awt.Label();
		xMatField = new java.awt.TextField();
		yMatLbl = new java.awt.Label();
		yMatField = new java.awt.TextField();
		materialButton = new java.awt.Button();
		material_pieza = new javax.swing.JSeparator();
		piezaLabel = new java.awt.Label();
		xPiezaLbl = new java.awt.Label();
		xPiezaField = new java.awt.TextField();
		yPiezaLbl = new java.awt.Label();
		yPiezaField = new java.awt.TextField();
		piezaButton = new java.awt.Button();
		pieza_lista = new javax.swing.JSeparator();
		itemDisplay = new java.awt.List();
		lista_optimize = new javax.swing.JSeparator();
		optimizaButton = new java.awt.Button();
		mensaje = new java.awt.Label();
		generationsField = new java.awt.TextField();
		populationField = new java.awt.TextField();
		mutationField = new java.awt.TextField();
		generationsLbl = new java.awt.Label();
		populationLbl = new java.awt.Label();
		mutationLbl = new java.awt.Label();
		materialPanel = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Optimizador de Cortes");
		setName("pantalla"); // NOI18N

		ajustesPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		ajustesPanel.setPreferredSize(new java.awt.Dimension(150, 988));

		materialLabel.setText("Crear Material");

		xMatLbl.setText("Ancho:");

		yMatLbl.setText("Alto:");

		materialButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		materialButton.setLabel("Crear");
		materialButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				materialButtonActionPerformed(evt);
			}
		});

		material_pieza.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		piezaLabel.setText("Crear Pieza");

		xPiezaLbl.setText("Ancho:");

		xPiezaField.setEnabled(false);

		yPiezaLbl.setText("Alto:");

		yPiezaField.setEnabled(false);

		piezaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		piezaButton.setEnabled(false);
		piezaButton.setLabel("Crear");
		piezaButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				piezaButtonActionPerformed(evt);
			}
		});

		pieza_lista.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		lista_optimize.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		optimizaButton.setEnabled(false);
		optimizaButton.setLabel("Optimizar Orden");
		optimizaButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				optimizaButtonActionPerformed(evt);
			}
		});

		generationsField.setEnabled(false);

		populationField.setEnabled(false);

		mutationField.setEnabled(false);

		generationsLbl.setText("Generaciones:");

		populationLbl.setText("Poblacion:");

		mutationLbl.setText("Mutacion [0,1]");

		javax.swing.GroupLayout ajustesPanelLayout = new javax.swing.GroupLayout(ajustesPanel);
		ajustesPanel.setLayout(ajustesPanelLayout);
		ajustesPanelLayout.setHorizontalGroup(
				ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(material_pieza)
						.addComponent(pieza_lista)
						.addComponent(lista_optimize)
						.addGroup(ajustesPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(optimizaButton, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(itemDisplay, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(materialButton, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(ajustesPanelLayout.createSequentialGroup()
												.addComponent(yPiezaLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(14, 14, 14)
												.addComponent(yPiezaField, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(ajustesPanelLayout.createSequentialGroup()
												.addGroup(ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(yMatLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(xMatLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(0, 0, 0)
												.addGroup(ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(ajustesPanelLayout.createSequentialGroup()
																.addComponent(materialLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(0, 0, 0))
														.addComponent(yMatField, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
														.addComponent(xMatField, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ajustesPanelLayout.createSequentialGroup()
												.addGroup(ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
																.addComponent(generationsLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(populationLbl, javax.swing.GroupLayout.Alignment.LEADING,
																		javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(mutationLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(
														ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(mutationField, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
																.addComponent(populationField, javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(generationsField, javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addComponent(piezaButton, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(ajustesPanelLayout.createSequentialGroup()
												.addComponent(xPiezaLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(0, 0, 0)
												.addGroup(ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(ajustesPanelLayout.createSequentialGroup()
																.addComponent(piezaLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(0, 0, 0))
														.addComponent(xPiezaField, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		ajustesPanelLayout.setVerticalGroup(
				ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(ajustesPanelLayout.createSequentialGroup()
								.addGap(18, 18, 18)
								.addComponent(materialLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(xMatLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(xMatField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(ajustesPanelLayout.createSequentialGroup()
												.addComponent(yMatField, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(materialButton, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(material_pieza, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(yMatLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addComponent(piezaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(xPiezaLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(xPiezaField, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(yPiezaLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(yPiezaField, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(piezaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(pieza_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(itemDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(lista_optimize, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(generationsField, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(generationsLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(populationField, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(populationLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(mutationField, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(mutationLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(optimizaButton, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		generationsLbl.getAccessibleContext().setAccessibleName("Generaciones");

		materialPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		javax.swing.GroupLayout materialPanelLayout = new javax.swing.GroupLayout(materialPanel);
		materialPanel.setLayout(materialPanelLayout);
		materialPanelLayout.setHorizontalGroup(
				materialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 798, Short.MAX_VALUE));
		materialPanelLayout.setVerticalGroup(
				materialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 0, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(ajustesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(materialPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(materialPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(ajustesPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap()));

		pack();
	}

	public Canvas lienzo;

	void initLienzo(int x, int y) {
		lienzo = new Canvas();
		lienzo.setBackground(new java.awt.Color(255, 255, 255));
		lienzo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		lienzo.setPreferredSize(new java.awt.Dimension(x, y));

		javax.swing.GroupLayout lienzoLayout = new javax.swing.GroupLayout(lienzo);
		lienzo.setLayout(lienzoLayout);
		lienzoLayout.setHorizontalGroup(
				lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 662, Short.MAX_VALUE));
		lienzoLayout.setVerticalGroup(
				lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 884, Short.MAX_VALUE));

		javax.swing.GroupLayout materialPanelLayout = new javax.swing.GroupLayout(materialPanel);
		materialPanel.setLayout(materialPanelLayout);
		materialPanelLayout.setHorizontalGroup(
				materialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(materialPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		materialPanelLayout.setVerticalGroup(
				materialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(materialPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
	}

	private void materialButtonActionPerformed(java.awt.event.ActionEvent evt) {
		materialWidth = Integer.parseInt(xMatField.getText());
		materialHeight = Integer.parseInt(yMatField.getText());
		// disable material input area
		xMatField.setEnabled(false);
		yMatField.setEnabled(false);
		materialButton.setEnabled(false);
		// enable item input area
		xPiezaField.setEnabled(true);
		yPiezaField.setEnabled(true);
		piezaButton.setEnabled(true);

		initLienzo(materialWidth * 10, materialHeight * 10);
	}

	private void piezaButtonActionPerformed(java.awt.event.ActionEvent evt) {
		int width = Integer.parseInt(xPiezaField.getText());
		int height = Integer.parseInt(yPiezaField.getText());
		// clear fields
		xPiezaField.setText("");
		yPiezaField.setText("");
		// add item to list
		rectangles.add(new Rectangle(width, height));
		itemDisplay.add((rectCount++) + ".- " + "[" + width + "*" + height + "]");

		Individual individual = new Individual(rectangles.size(), false);
		individual.evaluate(rectangles, materialWidth, materialHeight);
		lienzo.dibujarMatriz(individual.getMaterial(), rectangles.size());
		mensaje.setText("Fitness " + String.format("%.2f", individual.getFitness()) + "%");
		// enable genetic algorithm area
		optimizaButton.setEnabled(true);
		generationsField.setEnabled(true);
		populationField.setEnabled(true);
		mutationField.setEnabled(true);

	}

	private void optimizaButtonActionPerformed(java.awt.event.ActionEvent evt) {
		numberOfGenerations = Integer.parseInt(generationsField.getText());
		populationSize = Integer.parseInt(populationField.getText());
		mutationProbability = Double.parseDouble(mutationField.getText());

		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(rectangles, materialWidth, materialHeight);
		Individual bestIndividual = geneticAlgorithm.performGeneticAlgorithm(mutationProbability, numberOfGenerations,
				populationSize);

		lienzo.dibujarMatriz(bestIndividual.getMaterial(), rectangles.size());
		mensaje.setText("Fitness " + String.format("%.2f", bestIndividual.getFitness()) + "%");
	}

	// Variables declaration - do not modify
	private javax.swing.JPanel ajustesPanel;
	private java.awt.TextField generationsField;
	private java.awt.Label generationsLbl;
	private java.awt.List itemDisplay;
	private javax.swing.JSeparator lista_optimize;
	private java.awt.Button materialButton;
	private java.awt.Label materialLabel;
	private javax.swing.JPanel materialPanel;
	private javax.swing.JSeparator material_pieza;
	private java.awt.TextField mutationField;
	private java.awt.Label mutationLbl;
	private java.awt.Button optimizaButton;
	private java.awt.Button piezaButton;
	private java.awt.Label piezaLabel;
	private javax.swing.JSeparator pieza_lista;
	private java.awt.TextField populationField;
	private java.awt.Label populationLbl;
	private java.awt.Label mensaje;
	private java.awt.TextField xMatField;
	private java.awt.Label xMatLbl;
	private java.awt.TextField xPiezaField;
	private java.awt.Label xPiezaLbl;
	private java.awt.TextField yMatField;
	private java.awt.Label yMatLbl;
	private java.awt.TextField yPiezaField;
	private java.awt.Label yPiezaLbl;
	// End of variables declaration
}
