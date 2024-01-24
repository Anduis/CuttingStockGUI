public class MainFrame extends javax.swing.JFrame {
  int anchoMaterial;
  int altoMaterial;

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
    lista = new java.awt.List();
    lista_optimiza = new javax.swing.JSeparator();
    optimizaButton = new java.awt.Button();
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

    lista_optimiza.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

    optimizaButton.setEnabled(false);
    optimizaButton.setLabel("Optimizar Orden");

    javax.swing.GroupLayout ajustesPanelLayout = new javax.swing.GroupLayout(ajustesPanel);
    ajustesPanel.setLayout(ajustesPanelLayout);
    ajustesPanelLayout.setHorizontalGroup(
        ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(material_pieza)
            .addComponent(pieza_lista)
            .addComponent(lista_optimiza)
            .addGroup(ajustesPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(piezaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ajustesPanelLayout.createSequentialGroup()
                .addGroup(ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ajustesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(optimizaButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ajustesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                            Short.MAX_VALUE))
                    .addGroup(ajustesPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(materialLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ajustesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(xPiezaLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(xPiezaField, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ajustesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ajustesPanelLayout
                                .createSequentialGroup()
                                .addGroup(ajustesPanelLayout
                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yMatLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(xMatLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(
                                    ajustesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(yMatField, javax.swing.GroupLayout.DEFAULT_SIZE,
                                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(xMatField, javax.swing.GroupLayout.DEFAULT_SIZE,
                                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                ajustesPanelLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(materialButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ajustesPanelLayout.createSequentialGroup()
                                .addComponent(yPiezaLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(yPiezaField, javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0))))
                    .addComponent(piezaButton, javax.swing.GroupLayout.Alignment.TRAILING,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(lista, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lista_optimiza, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optimizaButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(420, Short.MAX_VALUE)));

    yMatLbl.getAccessibleContext().setAccessibleName("Alto:");
    xPiezaLbl.getAccessibleContext().setAccessibleName("Ancho:");

    materialPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

    javax.swing.GroupLayout materialPanelLayout = new javax.swing.GroupLayout(materialPanel);
    materialPanel.setLayout(materialPanelLayout);
    materialPanelLayout.setHorizontalGroup(
        materialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 828, Short.MAX_VALUE));
    materialPanelLayout.setVerticalGroup(
        materialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 984, Short.MAX_VALUE));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ajustesPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
  }// </editor-fold>//GEN-END:initComponents

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

    xPiezaField.setEnabled(true);
    yPiezaField.setEnabled(true);
    piezaButton.setEnabled(true);

    initLienzo(anchoMaterial, altoMaterial);
  }

  int contadorPiezas = 0;

  private void piezaButtonActionPerformed(java.awt.event.ActionEvent evt) {
    int ancho = Integer.parseInt(xPiezaField.getText());
    int alto = Integer.parseInt(yPiezaField.getText());
    xPiezaField.setText("");
    yPiezaField.setText("");
    lista.add(++contadorPiezas + ".- " + "[" + ancho + "*" + alto + "]");
    lienzo.dibujarRectangulo(0, 0, ancho, alto);
    optimizaButton.setEnabled(true);

  }

  private javax.swing.JPanel ajustesPanel;
  private java.awt.List lista;
  private javax.swing.JSeparator lista_optimiza;
  private java.awt.Button materialButton;
  private java.awt.Label materialLabel;
  private javax.swing.JPanel materialPanel;
  private javax.swing.JSeparator material_pieza;
  private java.awt.Button optimizaButton;
  private java.awt.Button piezaButton;
  private java.awt.Label piezaLabel;
  private javax.swing.JSeparator pieza_lista;
  private java.awt.TextField xMatField;
  private java.awt.Label xMatLbl;
  private java.awt.TextField xPiezaField;
  private java.awt.Label xPiezaLbl;
  private java.awt.TextField yMatField;
  private java.awt.Label yMatLbl;
  private java.awt.TextField yPiezaField;
  private java.awt.Label yPiezaLbl;
  private Canvas lienzo;
}
