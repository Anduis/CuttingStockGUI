import java.util.Arrays;
import java.util.Random;

public class Crossover {

  public static int[] crossover(int[] father, int[] mother) {
    int[] child = new int[father.length];
    boolean[] used = new boolean[father.length];

    Random random = new Random();
    int start = random.nextInt(child.length);
    int end = random.nextInt(child.length);

    if (start > end) {
      int temp = start;
      start = end;
      end = temp;
    }

    for (int i = start; i <= end; i++) {
      child[i] = father[i];
      used[father[i] - 1] = true;
    }

    int index = (end + 1) % child.length;
    for (int i = 0; i < mother.length; i++) {
      int gene = mother[(end + 1 + i) % child.length];
      if (!used[gene - 1]) {
        child[index] = gene;
        used[gene - 1] = true;
        index = (index + 1) % child.length;
      }
    }
    return child;
  }

  public static void main(String[] args) {
    int[] father = { 3, 6, 5, 8, 1, 2, 7, 4, 9 };
    int[] mother = { 5, 7, 6, 2, 8, 4, 3, 1, 9 };

    int[] hijo = crossover(father, mother);

    System.out.println("Padre: " + Arrays.toString(father));
    System.out.println("Madre: " + Arrays.toString(mother));
    System.out.println("Hijo: " + Arrays.toString(hijo));
  }
}