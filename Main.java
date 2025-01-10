// For testing instances withouth GUI

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    double mutationProbability = 0.5;
    int numberOfGenerations = 100;
    int populationSize = 100;
    int rectCount = 1;
    List<Rectangle> rectangles = new ArrayList<Rectangle>();

    Scanner sc = new Scanner(System.in);

    int materialWidth = sc.nextInt();
    int materialHeight = sc.nextInt();

    while (true) {
      String input = sc.next();
      if (input.equalsIgnoreCase("e")) {
        sc.close();
        break;
      }
      int width = Integer.parseInt(input);
      int height = sc.nextInt();
      rectangles.add(new Rectangle(width, height));
      System.out.println("Rectangle " + (rectCount++) + " added with width " + width + " and height " + height);
      Individual individual = new Individual(rectangles.size(), false);
      individual.evaluate(rectangles, materialWidth, materialHeight);
      printMaterial(individual.getMaterial());
      System.out.println("fitness " + individual.getFitness());
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(rectangles, materialWidth, materialHeight);
    Individual bestIndividual = geneticAlgorithm.performGeneticAlgorithm(mutationProbability, numberOfGenerations,
        populationSize);

    printMaterial(bestIndividual.getMaterial());
    System.out.println("best individual fitness " + bestIndividual.getFitness());

  }

  private static void printMaterial(int[][] material) {
    for (int i = material.length - 1; i >= 0; i--) {
      System.out.print(i + "|\t");
      for (int j = 0; j < material[0].length; j++)
        System.out.print(material[i][j] + "\t");
      System.out.println();
    }
    for (int i = 0; i < material[0].length; i++) {
      System.out.print("\t" + i);
    }
    System.out.println();
  }

}
