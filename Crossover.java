//just for making tests of this component

import java.util.Arrays;
import java.util.Random;

public class Crossover {

  public static int[] crossover(int[] father, int[] mother) {
    Random random = new Random();
    int length = father.length;
    int partition = random.nextInt(length / 2);
    int[] child = new int[father.length];

    for (int i = 0; i < father.length / 2; i++)
      child[i] = father[partition + i];

    for (int i = length / 2; i < length; i++)
      for (int motherGen : mother)
        if (i == length)
          break;
        else {
          boolean isIn = false;
          for (int childGen : child)
            if (childGen == 0)
              break;
            else if (motherGen == childGen) {
              isIn = true;
              break;
            }
          if (!isIn)
            child[i++] = motherGen;
        }
    return child;

  }

  public static void main(String[] args) {
    int[] padre = { 3, 6, 5, 8, 1, 2, 7, 4, 9 };
    int[] madre = { 5, 7, 6, 2, 8, 4, 3, 1, 9 };

    int[] hijo = crossover(padre, madre);

    System.out.println("Padre: " + Arrays.toString(padre));
    System.out.println("Madre: " + Arrays.toString(madre));
    System.out.println("Hijo: " + Arrays.toString(hijo));
  }
}
