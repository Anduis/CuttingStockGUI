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

  public void calculateFitness() {
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

  // heuristic code begins here
  public void evaluate(List<Rectangle> rectangles, int materialWidth, int materialHeight) {
    this.material = new int[materialHeight][materialWidth];
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
        rectangle = new Rectangle(rectangle.height, rectangle.width);// swap width and height so it's rotated
      while (pos != null)
        if (fits(pos, rectangle, list)) {
          int[] xy = placeRectangle(pos.x, pos.y, rectangle, rectIndex);
          addExtremes(list, xy);
          list.delete(pos);
          pos = list.head;
          break;
        } else {// traverse the list bakwards until a position is found
          pos = list.tail;
          if (pos != null)
            while (!fits(pos, rectangle, list)) {
              pos = pos.prev;
              if (pos == null) {
                material[0][0] = -1;// rectangle doesn't fit
                break;
              }
            }
        }
    }
    calculateFitness();
  }

  public void addExtremes(DoubleLinkedList list, int[] xy) {
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
        list.addFirst(x, xy[1]);// where x coordinate collides
    }
    if (xy[0] < material[0].length) {
      if (y != 0)
        while (material[y - 1][xy[0]] == 0 && y >= 0) {
          y--;
          if (y == 0)
            break;
        }
      if (y != xy[1])
        list.addFirst(xy[0], y);// where y coordinate collides
    }
  }

  public boolean fits(Node pos, Rectangle rectangle, DoubleLinkedList list) {
    if (material[pos.y][pos.x] != 0) {// the position is already occupied
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

  public int[] placeRectangle(int leftMostX, int lowerY, Rectangle rectangle, int id) {
    int[] xy = { leftMostX + rectangle.width, lowerY + rectangle.height };// top right corner after placement
    for (int i = lowerY; i < xy[1]; i++)
      for (int j = leftMostX; j < xy[0]; j++)
        material[i][j] = id;

    return xy;
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
