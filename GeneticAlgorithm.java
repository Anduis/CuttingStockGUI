import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class GeneticAlgorithm {
  public static void main(String[] args) {
    double mutationProbability = 0.5;
    int numberOfGenerations = 100;
    int populationSize = 100;
    int materialWidth = 8;
    int materialHeight = 6;

    List<Rectangle> rectangles = Arrays.asList(
        new Rectangle(1, 2, 2),
        new Rectangle(2, 3, 1),
        new Rectangle(3, 1, 2),
        new Rectangle(4, 1, 3),
        new Rectangle(5, 2, 3),
        new Rectangle(6, 2, 2),
        new Rectangle(7, 4, 1));

    Population population = new Population(populationSize, rectangles.size());
    int[][] material = new int[materialHeight][materialWidth];

    for (int generation = 0; generation < numberOfGenerations; generation++) {
      // Evaluation
      for (Individual individual : population.getIndividuals()) {
        material = getPattern(individual, rectangles, materialWidth, materialHeight);
        individual.setFitness(fitnessFunction(material));
      }
      // selection
      sortPopulationByFitness(population.getIndividuals());
      int selectedSize = (int) (populationSize * 0.1); // Tamaño de la selección del 10%
      List<Individual> seleccionados = population.getIndividuals().subList(0, selectedSize);
      double totalFitness = getTotalFitness(population.getIndividuals());

      // crossover
      while (seleccionados.size() < populationSize) {
        Individual father = roulette(population.getIndividuals(), totalFitness);
        Individual mother = roulette(population.getIndividuals(), totalFitness);
        // Realizar el crossover
        int[] childPermutation = crossover(father.getPermutation(), mother.getPermutation());
        Individual child = new Individual(childPermutation);
        // Agregar el nuevo hijo a la población
        seleccionados.add(child);
      }

      // mutation
      mutation(seleccionados, mutationProbability);

      // the new generation
      population.individuals = seleccionados;
    }

    // the best individual from the final population
    sortPopulationByFitness(population.getIndividuals());
    Individual bestIndividual = population.getIndividuals().get(0);
    System.out.println(bestIndividual.fitness + " mejor");
    material = getPattern(bestIndividual, rectangles, materialWidth, materialHeight);
    printMaterial(material);
  }

  private static void sortPopulationByFitness(List<Individual> population) {
    Collections.sort(population, Comparator.comparingDouble(Individual::getFitness).reversed());
  }

  private static void mutation(List<Individual> individuals, double probability) {
    Random random = new Random();
    for (Individual individual : individuals)
      if (random.nextDouble() < probability)
        individual.mutates();
  }

  private static double getTotalFitness(List<Individual> individuals) {
    double totalFitness = 0;
    for (Individual individual : individuals)
      totalFitness += individual.getFitness();
    return totalFitness;
  }

  private static Individual roulette(List<Individual> population, double totalFitness) {
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

  private static int[][] getPattern(Individual individual, List<Rectangle> rectangles, int materialWidth,
      int materialHeight) {
    int[][] material = new int[materialHeight][materialWidth];
    DoubleLinkedList list = new DoubleLinkedList();
    list.addFirst(0, 0);
    Node pos = list.head;
    for (int rectId : individual.permutation) {
      Rectangle rectangle = rectangles.get(rectId - 1);
      if (individual.rotations[rectId - 1])
        rectangle = rotated(rectangle);
      while (pos != null)
        if (fits(material, pos, rectangle, list)) {
          int[] xy = placeRectangle(material, pos.x, pos.y, rectangle);
          addExtremes(list, material, xy);
          list.delete(pos);
          pos = list.head;
          break;
        } else {
          pos = list.tail;
          if (pos != null)
            while (!fits(material, pos, rectangle, list)) {
              pos = pos.prev;
              if (pos == null) {
                material[0][0] = -1;// rectangle doesn't fit
                break;
              }
            }
        }
    }
    return material;
  }

  private static Rectangle rotated(Rectangle r) {
    return new Rectangle(r.id, r.height, r.width);
  }

  private static boolean isEmptyRow(int[] row) {
    for (int value : row)
      if (value != 0)
        return false;
    return true;
  }

  private static double fitnessFunction(int[][] material) {
    if (material[0][0] == -1)
      return 0;// doesn't satisfy problem requirements
    double totalArea = material[0].length * material.length;
    double enclosedArea = 0;
    for (int i = 0; i < material.length; i++)
      for (int j = 0; j < material[0].length; j++) {
        if (isEmptyRow(material[i])) {
        } else if (material[i][j] == 0)
          enclosedArea++;
      }

    double ans = 100 - ((enclosedArea / totalArea) * 100);
    return ans;
  }

  private static void addExtremes(DoubleLinkedList list, int[][] material, int[] xy) {// Reestructurar esto
    int x = xy[0];
    int y = xy[1];
    if (xy[1] < material.length) {
      if (x != 0)
        while (material[xy[1]][x - 1] == 0 && x >= 0) {
          x--;
          if (x == 0)
            break;
        }
      if (x != xy[0])
        list.addFirst(x, xy[1]);
    }
    if (xy[0] < material[0].length) {
      if (y != 0)
        while (material[y - 1][xy[0]] == 0 && y >= 0) {
          y--;
          if (y == 0)
            break;
        }
      if (y != xy[1])
        list.addFirst(xy[0], y);
    }
  }

  private static boolean fits(int[][] material, Node pos, Rectangle rectangle, DoubleLinkedList list) {
    if (material[pos.y][pos.x] != 0) {
      list.delete(pos);
      return false;
    }
    if (pos.y + rectangle.height > material.length || pos.x + rectangle.width > material[0].length)
      return false;
    for (int i = pos.y; i < pos.y + rectangle.height; i++)
      for (int j = pos.x; j < pos.x + rectangle.width; j++)
        if (material[i][j] != 0)
          return false;
    return true;
  }

  private static int[] placeRectangle(int[][] material, int x, int y, Rectangle rectangle) {
    int[] ans = { x + rectangle.width, y + rectangle.height };
    for (int i = y; i < y + rectangle.height; i++)
      for (int j = x; j < x + rectangle.width; j++)
        material[i][j] = rectangle.id;

    return ans;
  }

  private static void printMaterial(int[][] material) {
    for (int i = material.length - 1; i >= 0; i--) {
      System.out.print(i + "|\t");
      for (int j = 0; j < material[0].length; j++)
        System.out.print(material[i][j] + "\t");
      System.out.println();
    }
    System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");
  }

}
