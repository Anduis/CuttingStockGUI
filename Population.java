import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Population {
  List<Individual> individuals;

  public Population(int populationSize, int numberOfRectangles) {
    individuals = new ArrayList<>();

    for (int i = 0; i < populationSize; i++) {
      int[] permutation = generateRandomPermutation(numberOfRectangles);
      individuals.add(new Individual(permutation));
    }
  }

  public Population() {
    individuals = new ArrayList<>();
  }

  public List<Individual> getIndividuals() {
    return individuals;
  }

  private int[] generateRandomPermutation(int size) {
    List<Integer> permutation = new ArrayList<>();
    for (int i = 1; i <= size; i++)
      permutation.add(i);

    Collections.shuffle(permutation);

    return permutation.stream().mapToInt(Integer::intValue).toArray();
  }
}
