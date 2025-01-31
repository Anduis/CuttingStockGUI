import java.util.Arrays;
import java.util.Random;

public class GeneticAlgorithmTest {

  public static void main(String[] args) {
    int[] father = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int[] mother = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

    int[] child = orderCrossover(father, mother);

    System.out.println("Father: " + Arrays.toString(father));
    System.out.println("Mother: " + Arrays.toString(mother));
    System.out.println("Child: " + Arrays.toString(child));
  }

  private static int[] orderCrossover(int[] father, int[] mother) {
    int length = father.length;
    int[] child = new int[length];
    boolean[] used = new boolean[length];

    Random random = new Random();
    int start = random.nextInt(length);
    int end = random.nextInt(length);

    if (start > end) { // to ensure that start is at the left of end
      int temp = start;
      start = end;
      end = temp;
    }

    System.out.println("Crossover segment from father: start=" + start + ", end=" + end);

    // Copy the segment from father to child
    for (int i = start; i <= end; i++) {
      child[i] = father[i];
      used[Math.abs(father[i]) - 1] = true;
    }

    System.out.println("Child after copying segment from father: " + Arrays.toString(child));

    // Fill the remaining positions with genes from mother
    int index = (end + 1) % length;
    for (int i = 0; i < length; i++) {
      int gene = mother[(end + 1 + i) % length];
      if (!used[Math.abs(gene) - 1]) {
        child[index] = gene;
        used[Math.abs(gene) - 1] = true;
        index = (index + 1) % length;
      }
    }

    System.out.println("Child after filling with genes from mother: " + Arrays.toString(child));

    return child;
  }
}