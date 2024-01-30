public class Individual {
  int[] permutation;
  double fitness;

  public Individual(int[] permutation) {
    this.permutation = permutation;
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
}
