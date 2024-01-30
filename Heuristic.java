import java.util.*;

class Rectangle {
  int id;
  int width;
  int height;

  public Rectangle(int id, int width, int height) {
    this.id = id;
    this.width = width;
    this.height = height;
  }

}

public class Heuristic {

  public static void main(String[] args) {
    List<Rectangle> rectangles = Arrays.asList(
        new Rectangle(1, 2, 2),
        new Rectangle(2, 3, 1),
        new Rectangle(3, 1, 2),
        new Rectangle(4, 1, 3),
        new Rectangle(5, 2, 3),
        new Rectangle(6, 2, 2),
        new Rectangle(7, 4, 1));

    int materialWidth = 8;
    int materialHeight = 6;
    int[][] material = new int[materialHeight][materialWidth];
    DoubleLinkedList list = new DoubleLinkedList();
    list.addFirst(0, 0);
    Node pos = list.head;

    for (Rectangle rectangle : rectangles)
      while (pos != null)
        if (fits(material, pos, rectangle, list)) {
          int[] xy = placeRectangle(material, pos.x, pos.y, rectangle);
          addExtremes(list, material, xy);
          list.delete(pos);
          pos = list.head;
          break;
        } else {
          pos = list.tail;
          while (!fits(material, pos, rectangle, list))
            pos = pos.prev;
        }
    printMaterial(material);

  }

  private static void addExtremes(DoubleLinkedList list, int[][] material, int[] xy) {// plenty sure there exists a more
                                                                                      // elegant implementation
    int x = xy[0];
    int y = xy[1];
    if (xy[1] < material.length) {
      if (x != 0) {
        while (material[xy[1]][x - 1] == 0 && x >= 0) {
          x--;
          if (x == 0)
            break;
        }
      }
      if (x != xy[0])
        list.addFirst(x, xy[1]);
    }
    if (xy[0] < material[0].length) {
      if (y != 0) {
        while (material[y - 1][xy[0]] == 0 && y >= 0) {
          y--;
          if (y == 0)
            break;
        }
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