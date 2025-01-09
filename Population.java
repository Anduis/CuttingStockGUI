import java.util.List;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

public class Population {
  List<Individual> individuals;

  public Population(int populationSize, int numberOfRectangles) {// initialize the population with random individuals
    individuals = new ArrayList<>();

    individuals.add(new Individual(numberOfRectangles, false));// to include the individual with secuential permutation

    for (int i = 0; i < populationSize - 1; i++) {
      individuals.add(new Individual(numberOfRectangles, true));
    }
  }

  public List<Individual> getIndividuals() {// return the individuals as a list
    return individuals;
  }

  public void sortPopulationByFitness() {// sort the individuals by fitness in descending order
    Collections.sort(individuals, Comparator.comparingDouble(Individual::getFitness).reversed());
  }

  public double getTotalFitness() {// sum of all the fitness of the individuals
    double totalFitness = 0;
    for (Individual individual : individuals)
      totalFitness += individual.getFitness();
    return totalFitness;
  }
}
