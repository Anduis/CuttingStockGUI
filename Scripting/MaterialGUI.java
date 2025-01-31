import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// javac MaterialGUI.java && java -Xms8g -Xmx14g -XX:+UseG1GC -XX:ParallelGCThreads=10 MaterialGUI < C7P2.txt && del *.class
public class MaterialGUI {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Material Layout");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800, 600);

      Canvas canvas = new Canvas();
      frame.add(canvas);
      frame.setVisible(true);

      // Simulamos la entrada de datos para probar la interfaz
      Scanner sc = new Scanner(System.in);
      int materialWidth = sc.nextInt();
      int optimalHeight = sc.nextInt();
      int materialHeight = optimalHeight * 2;
      List<Rectangle> rectangles = new ArrayList<>();

      while (true) {
        String input = sc.next();
        if (input.equalsIgnoreCase("e")) {
          sc.close();
          break;
        }
        int width = Integer.parseInt(input);
        int height = sc.nextInt();
        rectangles.add(new Rectangle(width, height));
      }

      GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(rectangles, materialWidth, materialHeight);
      Individual bestIndividual = geneticAlgorithm.performGeneticAlgorithm(0.06, 1000, 50);

      canvas.dibujarMatriz(bestIndividual.getMaterial(), rectangles.size());
    });
  }
}
