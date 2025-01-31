import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Canvas extends JPanel {

  int[][] matriz;
  List<Color> colores;

  public Canvas() {
    matriz = new int[1][1];
    colores = generarColores(15);
  }

  public void dibujarMatriz(int[][] m, int numRectangulos) {
    matriz = m;
    while (colores.size() < numRectangulos) {
      colores.add(randColor());
    }
    repaint();
  }

  private List<Color> generarColores(int cantidad) {
    List<Color> lista = new ArrayList<>();
    float hueStep = 1.0f / cantidad;
    for (int i = 0; i < cantidad; i++) {
      lista.add(Color.getHSBColor(i * hueStep, 0.8f, 0.9f));
    }
    return lista;
  }

  private Color randColor() {
    return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (matriz[0][0] != -1)
      for (int i = 0; i < matriz.length; i++)
        for (int j = 0; j < matriz[0].length; j++)
          if (matriz[i][j] != 0) {
            g.setColor(colores.get(matriz[i][j] - 1));
            g.fillRect(j * 10, i * 10, 10, 10);
          }
  }
}
