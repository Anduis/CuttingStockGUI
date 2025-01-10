import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Individual {
  // represents the order in which the rectangles are placed in the material
  int[] permutation;// genotype. if any value is negative, that rectangle is rotated
  double fitness;// from 0 to 100
  int[][] material;// phenotype. if first cell is -1, doesn't satisfy the requirements

  public Individual(int x, boolean random) {
    if (random)
      this.permutation = generateRandomPermutation(x);
    else
      this.permutation = naturalPerm(x);
  }

  public int[] getPermutation() {
    return permutation;
  }

  public double getFitness() {
    return fitness;
  }

  public int[][] getMaterial() {
    return material;
  }

  public void mutates() {// rotates a random rectangle
    Random random = new Random();
    int index = random.nextInt(permutation.length);
    permutation[index] = -permutation[index];
  }

  // heuristic code begins here
  public void evaluate(List<Rectangle> rectangles, int materialWidth, int materialHeight) {
    material = new int[materialHeight][materialWidth];
    int[][] temp = new int[materialHeight][materialWidth];
    DoubleLinkedList list = new DoubleLinkedList();
    list.addFirst(0, 0);
    Node pos = list.head;
    for (int rectIndex : permutation) {
      boolean isRotated = false;
      if (rectIndex < 0) {
        isRotated = true;
        rectIndex = -rectIndex;// make it positive
      }
      Rectangle rectangle = new Rectangle(rectangles.get(rectIndex - 1));
      if (isRotated)
        rectangle = new Rectangle(r.height, r.width);// swap width and height so it's rotated
      while (pos != null)
        if (fits(temp, pos, rectangle, list)) {
          int[] xy = placeRectangle(temp, pos.x, pos.y, rectangle, rectIndex);
          addExtremes(list, temp, xy);
          list.delete(pos);
          pos = list.head;
          break;
        } else {
          pos = list.tail;
          if (pos != null)
            while (!fits(temp, pos, rectangle, list)) {
              pos = pos.prev;
              if (pos == null) {
                temp[0][0] = -1;// rectangle doesn't fit
                break;
              }
            }
        }
    }
    material = temp;
    // calculate fitness
    if (material[0][0] == -1) {// doesn't satisfy problem requirements
      fitness = 0;
      return;
    }
    double usedArea = 0;
    double enclosedArea = 0;// area below the highest edge of the highest rectangle
    for (int[] row : material) {
      boolean isEmptyRow = true;
      for (int cell : row)
        if (cell != 0) {
          isEmptyRow = false;
          usedArea++;
        } else
          enclosedArea++;
      if (isEmptyRow)
        enclosedArea -= row.length;
    }
    fitness = ((usedArea / (usedArea + enclosedArea)) * 100);
  }

  public void addExtremes(DoubleLinkedList list, int[][] material, int[] xy) {// heuristic
    // esto es al reves? check!!!!
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

  public boolean fits(int[][] material, Node pos, Rectangle rectangle, DoubleLinkedList list) {
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

  public int[] placeRectangle(int[][] material, int x, int y, Rectangle rectangle, int index) {
    int[] ans = { x + rectangle.width, y + rectangle.height };
    for (int i = y; i < y + rectangle.height; i++)
      for (int j = x; j < x + rectangle.width; j++)
        material[i][j] = index;

    return ans;
  }

  // heuristic code ends here

  private static int[] naturalPerm(int x) {
    int[] ans = new int[x];
    for (int i = 0; i < ans.length; i++)
      ans[i] = i + 1;
    return ans;
  }

  public int[] generateRandomPermutation(int size) {
    List<Integer> permutation = new ArrayList<>();
    for (int i = 1; i <= size; i++)
      permutation.add(i);
    Collections.shuffle(permutation);
    return permutation.stream().mapToInt(Integer::intValue).toArray();
  }
}
