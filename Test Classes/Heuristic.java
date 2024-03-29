//just for making tests of this component

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Heuristic {
  public static void main(String[] args) {
    int c = 1;
    List<Rectangle> rectangles = new ArrayList<Rectangle>();
    int materialWidth = 8;
    int materialHeight = 6;
    Scanner sc = new Scanner(System.in);
    while (true) {
      int ancho = sc.nextInt();
      int alto = sc.nextInt();
      rectangles.add(new Rectangle(c++, ancho, alto));
      Individual individual = new Individual(naturalPerm(rectangles.size()));

      int[][] material = new int[materialHeight][materialWidth];

      material = getPattern(individual, rectangles, materialWidth, materialHeight);
      individual.setFitness(fitnessFunction(material));
      printMaterial(material);

    }
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
}