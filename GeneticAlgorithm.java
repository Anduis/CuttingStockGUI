import java.util.List;
import java.util.Random;

public class GeneticAlgorithm {
  List<Rectangle> rectangles;
  int materialWidth;
  int materialHeight;

  public GeneticAlgorithm(List<Rectangle> rectangles, int materialWidth, int materialHeight) {
    this.rectangles = rectangles;
    this.materialHeight = materialHeight;
    this.materialWidth = materialWidth;
  }

  public Individual performGeneticAlgorithm(double mutationProbability, int numberOfGenerations, int populationSize) {
    Population population = new Population(populationSize, rectangles.size());
    for (int generation = 0; generation < numberOfGenerations; generation++) {
      // Evaluation
      for (Individual individual : population.getIndividuals()) {
        individual.getPattern(rectangles, materialWidth, materialHeight);
      }
      // selection
      population.sortPopulationByFitness();
      List<Individual> selected = population.getIndividuals().subList(0, (int) (populationSize * 0.1));
      double totalFitness = population.getTotalFitness();

      // crossover
      while (selected.size() < populationSize) {
        Individual father = roulette(population.getIndividuals(), totalFitness);
        Individual mother = roulette(population.getIndividuals(), totalFitness);
        Individual child = crossover(father, mother);
        // add the newborn to the selected individuals
        selected.add(child);
      }

      // mutation
      mutation(selected, mutationProbability);

      // update the new generation
      population.individuals = selected;
    }

    // printing the best individual from the final population
    population.sortPopulationByFitness();
    return population.getIndividuals().get(0);
  }

  public void mutation(List<Individual> individuals, double probability) {
    Random random = new Random();
    for (Individual individual : individuals)
      if (random.nextDouble() < probability)
        individual.mutates();
  }

  public Individual roulette(List<Individual> population, double totalFitness) {
    Random random = new Random();
    double randomNumber = random.nextDouble() * totalFitness;// check interval!!!!
    double currentSum = 0;

    for (Individual individual : population) {
      currentSum += individual.getFitness();
      if (currentSum >= randomNumber)
        return individual;
    }
    return population.get(random.nextInt(population.size()));
  }

  public Individual crossover(Individual father, Individual mother) {
    Individual child = new Individual(father.permutation.length, false);
    boolean[] used = new boolean[father.permutation.length];

    Random random = new Random();
    int start = random.nextInt(child.permutation.length);
    int end = random.nextInt(child.permutation.length);

    if (start > end) {
      int temp = start;
      start = end;
      end = temp;
    }

    for (int i = start; i <= end; i++) {
      child.permutation[i] = father.permutation[i];
      child.rotations[i] = father.rotations[i];
      used[father.permutation[i] - 1] = true;
    }

    int index = (end + 1) % child.permutation.length;
    for (int i = 0; i < mother.permutation.length; i++) {
      int gene = mother.permutation[(end + 1 + i) % child.permutation.length];
      boolean geneB = mother.rotations[(end + 1 + i) % child.rotations.length];
      if (!used[gene - 1]) {
        child.permutation[index] = gene;
        child.rotations[index] = geneB;
        used[gene - 1] = true;
        index = (index + 1) % child.permutation.length;
      }
    }
    return child;
  }

}
