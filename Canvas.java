import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class Canvas extends JPanel {

  int[][] matriz;
  Color[] colores;

  public Canvas() {
    matriz = new int[1][1];
    colores = new Color[1];
    colores[0] = Color.WHITE;
  }

  public void dibujarMatriz(int[][] m, int s) {
    matriz = m;
    colores = new Color[s];
    for (int i = 0; i < colores.length; i++)
      colores[i] = randColor();
    repaint();
  }

  Color randColor() {
    Random r = new Random();
    return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
  }

  // Método que se llama automáticamente para dibujar en el panel
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (matriz[0][0] != -1)
      for (int i = 0; i < matriz.length; i++)
        for (int j = 0; j < matriz[0].length; j++)
          if (matriz[i][j] != 0) {
            g.setColor(colores[matriz[i][j] - 1]);
            g.fillRect(j * 10, i * 10, 10, 10);
          }
  }
}
