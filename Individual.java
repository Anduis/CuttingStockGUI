import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Individual {
  // represents the order in which the rectangles are placed in the material
  private int[] permutation;// genotype. if any value is negative, that rectangle is rotated
  private double fitness;// from 0 to 100
  private int[][] material;// phenotype. if first cell is -1, doesn't satisfy the requirements

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

  private void calculateFitness() {
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
    Node currentPosition = list.getHead();
    for (int rectIndex : permutation) {
      boolean isRotated = false;
      if (rectIndex < 0) {
        isRotated = true;
        rectIndex = -rectIndex;// make it positive
      }
      Rectangle rectangle = new Rectangle(rectangles.get(rectIndex - 1));
      if (isRotated)
        rectangle = new Rectangle(rectangle.getHeight(), rectangle.getWidth());// swap width and height so it's rotated
      while (currentPosition != null)
        if (fits(currentPosition, rectangle, list)) {
          int[] xy = placeRectangle(currentPosition.x, currentPosition.y, rectangle, rectIndex);
          addExtremes(list, xy);
          list.delete(currentPosition);
          currentPosition = list.getHead();
          break;
        } else {// traverse the list bakwards until a position is found
          currentPosition = list.getTail();
          if (currentPosition != null)
            while (!fits(currentPosition, rectangle, list)) {
              currentPosition = currentPosition.prev;
              if (currentPosition == null) {
                material[0][0] = -1;// rectangle doesn't fit
                break;
              }
            }
        }
    }
    calculateFitness();
  }

  private void addExtremes(DoubleLinkedList list, int[] xy) {
    // it adds new available positions to the list, from the top rigth corner,
    // searches for the last empty cell in the x and y axis
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

  private boolean fits(Node position, Rectangle rectangle, DoubleLinkedList list) {
    if (material[position.y][position.x] != 0) {// the position is already occupied
      list.delete(position);
      return false;
    }
    if (position.y + rectangle.getHeight() > material.length || position.x + rectangle.getWidth() > material[0].length)
      return false;
    for (int i = position.y; i < position.y + rectangle.getHeight(); i++)
      for (int j = position.x; j < position.x + rectangle.getWidth(); j++)
        if (material[i][j] != 0)
          return false;
    return true;
  }

  private int[] placeRectangle(int leftMostX, int lowerY, Rectangle rectangle, int id) {
    int[] xy = { leftMostX + rectangle.getWidth(), lowerY + rectangle.getHeight() };// top right corner after placement
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

  private int[] generateRandomPermutation(int size) {
    List<Integer> permutation = new ArrayList<>();
    for (int i = 1; i <= size; i++)
      permutation.add(i);
    Collections.shuffle(permutation);
    return permutation.stream().mapToInt(Integer::intValue).toArray();
  }
}
