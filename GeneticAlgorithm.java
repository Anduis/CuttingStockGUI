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
      for (Individual individual : population.getIndividuals())
        individual.evaluate(rectangles, materialWidth, materialHeight);
      population.sortPopulationByFitness();

      // selection
      List<Individual> selected = population.getIndividuals().subList(0, (int) (populationSize * 0.15));
      // added a 20% of the individuals to the selection by elitism
      double totalFitness = population.getTotalFitness();
      // rest of the individuals are selected by roulette for mating

      // crossover
      while (selected.size() < populationSize) {
        Individual father = roulette(population.getIndividuals(), totalFitness);
        Individual mother = roulette(population.getIndividuals(), totalFitness);
        Individual child = orderCrossover(father, mother);
        // add the newborn to the selected individuals
        selected.add(child);
      }

      // mutation
      mutation(selected, mutationProbability);

      // update the new generation
      population.newGeneration(selected);
    }

    // return the best individual from the final population
    population.sortPopulationByFitness();
    return population.getIndividuals().get(0);
  }

  private void mutation(List<Individual> individuals, double probability) {
    Random random = new Random();
    for (Individual individual : individuals)
      if (random.nextDouble() <= probability)
        individual.mutates();
  }

  private Individual roulette(List<Individual> population, double totalFitness) {
    Random random = new Random();
    double randomNumber = random.nextDouble() * totalFitness;
    double currentSum = 0;

    for (Individual individual : population) {
      currentSum += individual.getFitness();
      if (currentSum >= randomNumber)
        return individual;
    }
    return population.get(random.nextInt(population.size()));
  }

  private Individual orderCrossover(Individual father, Individual mother) {
    int length = father.getPermutation().length;
    Individual child = new Individual(length, false);
    boolean[] used = new boolean[length];

    Random random = new Random();
    int start = random.nextInt(length);
    int end = random.nextInt(length);

    if (start > end) {// to ensure that start is at the left of end
      int temp = start;
      start = end;
      end = temp;
    }

    for (int i = start; i <= end; i++) {
      child.getPermutation()[i] = father.getPermutation()[i];
      used[Math.abs(father.getPermutation()[i]) - 1] = true;
    }

    int index = (end + 1) % length;
    for (int i = 0; i < length; i++) {
      int gene = mother.getPermutation()[(end + 1 + i) % length];
      if (!used[Math.abs(gene) - 1]) {
        child.getPermutation()[index] = gene;
        used[Math.abs(gene) - 1] = true;
        index = (index + 1) % length;
      }
    }
    return child;
  }

}
