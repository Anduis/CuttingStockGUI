import java.util.*;

class Rectangle {// ok
  int id;
  int width;
  int height;

  public Rectangle(int id, int width, int height) {
    this.id = id;
    this.width = width;
    this.height = height;
  }
}

class Individual {
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

class Population {// ok
  List<Individual> individuals;

  public Population(int populationSize, int numberOfRectangles) {
    individuals = new ArrayList<>();

    for (int i = 0; i < populationSize; i++) {
      int[] permutation = generateRandomPermutation(numberOfRectangles);
      individuals.add(new Individual(permutation));
    }
  }

  public List<Individual> getIndividuals() {
    return individuals;
  }

  private int[] generateRandomPermutation(int size) {
    List<Integer> permutation = new ArrayList<>();
    for (int i = 1; i <= size; i++) {
      permutation.add(i);
    }

    Collections.shuffle(permutation);

    return permutation.stream().mapToInt(Integer::intValue).toArray();
  }
}

public class GeneticAlgorithm {
  public static void main(String[] args) {
    int populationSize = 100;
    int numberOfGenerations = 100;
    int numberOfRectangles = 3;
    int materialWidth = 10;
    int materialHeight = 10;

    List<Rectangle> rectangles = Arrays.asList(
        new Rectangle(1, 2, 4),
        new Rectangle(2, 5, 3),
        new Rectangle(3, 8, 2));

    Population population = new Population(populationSize, numberOfRectangles);

    for (int generation = 0; generation < numberOfGenerations; generation++) {
      for (Individual individual : population.getIndividuals()) {
        double fitness = fitnessFunction(individual, rectangles, materialWidth, materialHeight);
        individual.setFitness(fitness);
      }

      // selection, crossover, mutation

      // the population with the new generation
    }

    // Retrieve the best individual from the final population
    sortPopulationByFitness(population.getIndividuals());
    Individual bestIndividual = population.getIndividuals().get(0);
    System.out.println(bestIndividual.fitness);
  }

  private static void sortPopulationByFitness(List<Individual> population) {
    Collections.sort(population, Comparator.comparingDouble(Individual::getFitness).reversed());
  }

  public static double fitnessFunction(Individual individual, List<Rectangle> rectangles, int materialWidth,
      int materialHeight) {
    int[] permutation = individual.getPermutation();

    int[][] material = new int[materialHeight][materialWidth];

    for (int rectId : permutation) {
      Rectangle rectangle = rectangles.get(rectId - 1);

    }

    return 0;
  }

  private static boolean fits(int[][] material, int row, int col, Rectangle rectangle) {
    int rectWidth = rectangle.width;
    int rectHeight = rectangle.height;

    if (row + rectHeight > material.length || col + rectWidth > material[0].length) {
      return false;
    }

    for (int i = row; i < row + rectHeight; i++) {
      for (int j = col; j < col + rectWidth; j++) {
        if (material[i][j] != 0) {
          return false;
        }
      }
    }
    return true;
  }

}
