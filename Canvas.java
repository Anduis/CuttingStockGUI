import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class Canvas extends JPanel {

  private int xRectangulo;
  private int yRectangulo;
  private int anchoRectangulo;
  private int altoRectangulo;

  public Canvas() {
    // Inicializamos valores por defecto
    xRectangulo = 0;
    yRectangulo = 0;
    anchoRectangulo = 0;
    altoRectangulo = 0;
  }

  // Método para dibujar el rectángulo en el panel
  public void dibujarRectangulo(int x, int y, int ancho, int alto) {
    xRectangulo = x;
    yRectangulo = y;
    anchoRectangulo = ancho;
    altoRectangulo = alto;
    repaint();
  }

  Color randColor() {
    Random r = new Random();
    return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
  }

  // Método que se llama automáticamente para dibujar en el panel
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // Dibujamos el rectángulo con los valores actuales
    g.setColor(randColor());
    g.fillRect(xRectangulo, yRectangulo, anchoRectangulo, altoRectangulo);
  }
}
