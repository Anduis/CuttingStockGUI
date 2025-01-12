// For testing instances withouth GUI

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    double mutationProbability = 0.06;
    int numberOfGenerations = 1000;
    int populationSize = 50;
    int rectCount = 1;
    List<Rectangle> rectangles = new ArrayList<Rectangle>();

    Scanner sc = new Scanner(System.in);

    int materialWidth = sc.nextInt();
    int optimalHeight = sc.nextInt();
    int materialHeight = optimalHeight * 2;// to ensure that the material is high enough

    while (true) {
      String input = sc.next();
      if (input.equalsIgnoreCase("e")) {
        sc.close();
        break;
      }
      int width = Integer.parseInt(input);
      int height = sc.nextInt();
      rectangles.add(new Rectangle(width, height));
      Individual individual = new Individual(rectangles.size(), false);
      individual.evaluate(rectangles, materialWidth, materialHeight);
    }
    GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(rectangles, materialWidth, materialHeight);
    Individual bestIndividual = geneticAlgorithm.performGeneticAlgorithm(mutationProbability, numberOfGenerations,
    populationSize);
    
    //printMaterial(bestIndividual.getMaterial());
    System.out.println(percentageAboveOptimal(optimalHeight, highestOccupiedRow(bestIndividual.getMaterial())));
    //System.out.println("highest occupied row " + highestOccupiedRow(bestIndividual.getMaterial()));
    //System.out.println("optimal height " + optimalHeight);

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

  private static int highestOccupiedRow(int[][] material) {
    for (int i = material.length - 1; i >= 0; i--)
      for (int j = 0; j < material[0].length; j++)
        if (material[i][j] != 0)
          return i + 1;
    return -1;
  }

  private static double percentageAboveOptimal(int optimal, int obtained) {
    return (((double) (obtained - optimal) / optimal) * 100);
  }

}
