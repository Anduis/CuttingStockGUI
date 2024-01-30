import java.util.Random;

public class Individual {
  int[] permutation;
  boolean[] rotations;
  double fitness;

  public Individual(int[] permutation) {
    this.permutation = permutation;
    rotations = new boolean[permutation.length];
  }

  public int[] getPermutation() {
    return permutation;
  }

  void setFitness(double fitness) {
    this.fitness = fitness;
  }

  public double getFitness() {
    return fitness;
  }

  public void mutates() {
    Random random = new Random();
    int index = random.nextInt(permutation.length);
    rotations[index] = !rotations[index];

  }
}
