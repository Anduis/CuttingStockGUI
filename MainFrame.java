import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MainFrame extends javax.swing.JFrame {
	double mutationProbability;
	int numberOfGenerations;
	int populationSize;
	int anchoMaterial;
	int altoMaterial;

	List<Rectangle> rectangles = new ArrayList<Rectangle>();
	int c = 1;
	Population population;

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
		anchoMaterial = Integer.parseInt(xMatField.getText());
		altoMaterial = Integer.parseInt(yMatField.getText());
		xMatField.setEnabled(false);
		yMatField.setEnabled(false);
		materialButton.setEnabled(false);
		// enable piece input area
		xPiezaField.setEnabled(true);
		yPiezaField.setEnabled(true);
		piezaButton.setEnabled(true);

		initLienzo(anchoMaterial * 10, altoMaterial * 10);
	}

	int contadorPiezas = 0;

	private void piezaButtonActionPerformed(java.awt.event.ActionEvent evt) {
		int ancho = Integer.parseInt(xPiezaField.getText());
		int alto = Integer.parseInt(yPiezaField.getText());
		xPiezaField.setText("");
		yPiezaField.setText("");
		// agrega un rectangulo
		rectangles.add(new Rectangle(c++, ancho, alto));
		itemDisplay.add(++contadorPiezas + ".- " + "[" + ancho + "*" + alto + "]");

		Individual individual = new Individual(naturalPerm(rectangles.size()));
		int[][] material = new int[altoMaterial][anchoMaterial];
		material = getPattern(individual, rectangles, anchoMaterial, altoMaterial);
		individual.setFitness(fitnessFunction(material));
		lienzo.dibujarMatriz(material, rectangles.size());
		mensaje.setText("Fitness " + String.format("%.2f", individual.fitness) + "%");
		// enable genetic area
		optimizaButton.setEnabled(true);
		generationsField.setEnabled(true);
		populationField.setEnabled(true);
		mutationField.setEnabled(true);

	}

	private void optimizaButtonActionPerformed(java.awt.event.ActionEvent evt) {
		numberOfGenerations = Integer.parseInt(generationsField.getText());
		populationSize = Integer.parseInt(populationField.getText());
		mutationProbability = Double.parseDouble(mutationField.getText());

		population = new Population(populationSize, rectangles.size());
		int[][] material = new int[altoMaterial][anchoMaterial];

		for (int generation = 0; generation < numberOfGenerations; generation++) {
			// Evaluation
			for (Individual individual : population.getIndividuals()) {
				material = getPattern(individual, rectangles, anchoMaterial, altoMaterial);
				individual.setFitness(fitnessFunction(material));
			}
			// selection
			sortPopulationByFitness(population.getIndividuals());
			int selectedSize = (int) (populationSize * 0.1); // Tamaño de la selección del 10%
			List<Individual> seleccionados = population.getIndividuals().subList(0, selectedSize);
			double totalFitness = getTotalFitness(population.getIndividuals());

			// crossover
			while (seleccionados.size() < populationSize) {
				Individual father = roulette(population.getIndividuals(), totalFitness);
				Individual mother = roulette(population.getIndividuals(), totalFitness);
				// Realizar el crossover
				int[] childPermutation = crossover(father.getPermutation(), mother.getPermutation());
				Individual child = new Individual(childPermutation);
				// Agregar el nuevo hijo a la población
				seleccionados.add(child);
			}

			// mutation
			mutation(seleccionados, mutationProbability);

			// the new generation
			population.individuals = seleccionados;
		}

		// the best individual from the final population
		sortPopulationByFitness(population.getIndividuals());
		Individual bestIndividual = population.getIndividuals().get(0);
		material = getPattern(bestIndividual, rectangles, anchoMaterial, altoMaterial);
		lienzo.dibujarMatriz(material, rectangles.size());
		mensaje.setText("Fitness " + String.format("%.2f", bestIndividual.fitness) + "%");
	}

	private static void sortPopulationByFitness(List<Individual> population) {
		Collections.sort(population, Comparator.comparingDouble(Individual::getFitness).reversed());
	}

	private static void mutation(List<Individual> individuals, double probability) {
		Random random = new Random();
		for (Individual individual : individuals)
			if (random.nextDouble() < probability)
				individual.mutates();
	}

	private static double getTotalFitness(List<Individual> individuals) {
		double totalFitness = 0;
		for (Individual individual : individuals)
			totalFitness += individual.getFitness();
		return totalFitness;
	}

	private static Individual roulette(List<Individual> population, double totalFitness) {
		Random random = new Random();
		double randomNumber = random.nextDouble() * totalFitness;
		double currentSum = 0;

		for (Individual individual : population) {
			currentSum += individual.getFitness();
			if (currentSum >= randomNumber)
				return individual;
		}
		return population.get(random.nextInt(population.size()));
	}

	public static int[] crossover(int[] father, int[] mother) {
		Random random = new Random();
		int length = father.length;
		int partition = random.nextInt(length / 2);
		int[] child = new int[father.length];

		for (int i = 0; i < father.length / 2; i++)
			child[i] = father[partition + i];

		for (int i = length / 2; i < length; i++)
			for (int motherGen : mother)
				if (i == length)
					break;
				else {
					boolean isIn = false;
					for (int childGen : child)
						if (childGen == 0)
							break;
						else if (motherGen == childGen) {
							isIn = true;
							break;
						}
					if (!isIn)
						child[i++] = motherGen;
				}
		return child;
	}

	private static int[] naturalPerm(int x) {
		int[] ans = new int[x];
		for (int i = 0; i < ans.length; i++)
			ans[i] = i + 1;
		return ans;
	}

	private static int[][] getPattern(Individual individual, List<Rectangle> rectangles, int materialWidth,
			int materialHeight) {
		int[][] material = new int[materialHeight][materialWidth];
		DoubleLinkedList list = new DoubleLinkedList();
		list.addFirst(0, 0);
		Node pos = list.head;
		for (int rectId : individual.permutation) {
			Rectangle rectangle = rectangles.get(rectId - 1);
			if (individual.rotations[rectId - 1])
				rectangle = rotated(rectangle);
			while (pos != null)
				if (fits(material, pos, rectangle, list)) {
					int[] xy = placeRectangle(material, pos.x, pos.y, rectangle);
					addExtremes(list, material, xy);
					list.delete(pos);
					pos = list.head;
					break;
				} else {
					pos = list.tail;
					if (pos != null)
						while (!fits(material, pos, rectangle, list)) {
							pos = pos.prev;
							if (pos == null) {
								material[0][0] = -1;// rectangle doesn't fit
								break;
							}
						}
				}
		}
		return material;
	}

	private static Rectangle rotated(Rectangle r) {
		return new Rectangle(r.id, r.height, r.width);
	}

	private static boolean isEmptyRow(int[] row) {
		for (int value : row)
			if (value != 0)
				return false;
		return true;
	}

	private static double fitnessFunction(int[][] material) {
		if (material[0][0] == -1)
			return 0;// doesn't satisfy problem requirements
		double totalArea = material[0].length * material.length;
		double enclosedArea = 0;
		for (int i = 0; i < material.length; i++)
			for (int j = 0; j < material[0].length; j++) {
				if (isEmptyRow(material[i])) {
				} else if (material[i][j] == 0)
					enclosedArea++;
			}

		double ans = 100 - ((enclosedArea / totalArea) * 100);
		return ans;
	}

	private static void addExtremes(DoubleLinkedList list, int[][] material, int[] xy) {// Reestructurar esto
		int x = xy[0];
		int y = xy[1];
		if (xy[1] < material.length) {
			if (x != 0)
				while (material[xy[1]][x - 1] == 0 && x >= 0) {
					x--;
					if (x == 0)
						break;
				}
			if (x != xy[0])
				list.addFirst(x, xy[1]);
		}
		if (xy[0] < material[0].length) {
			if (y != 0)
				while (material[y - 1][xy[0]] == 0 && y >= 0) {
					y--;
					if (y == 0)
						break;
				}
			if (y != xy[1])
				list.addFirst(xy[0], y);
		}
	}

	private static boolean fits(int[][] material, Node pos, Rectangle rectangle, DoubleLinkedList list) {
		if (material[pos.y][pos.x] != 0) {
			list.delete(pos);
			return false;
		}
		if (pos.y + rectangle.height > material.length || pos.x + rectangle.width > material[0].length)
			return false;
		for (int i = pos.y; i < pos.y + rectangle.height; i++)
			for (int j = pos.x; j < pos.x + rectangle.width; j++)
				if (material[i][j] != 0)
					return false;
		return true;
	}

	private static int[] placeRectangle(int[][] material, int x, int y, Rectangle rectangle) {
		int[] ans = { x + rectangle.width, y + rectangle.height };
		for (int i = y; i < y + rectangle.height; i++)
			for (int j = x; j < x + rectangle.width; j++)
				material[i][j] = rectangle.id;

		return ans;
	}

	private static void printMaterial(int[][] material) {
		for (int i = material.length - 1; i >= 0; i--) {
			System.out.print(i + "|\t");
			for (int j = 0; j < material[0].length; j++)
				System.out.print(material[i][j] + "\t");
			System.out.println();
		}
		System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");
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
