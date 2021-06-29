package com.company;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        Population population = new Population(GeneticAlgorithm.POPULATION_SIZE).initializePopulation();
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        int generationNumber = 0;
        System.out.println("---------------------------------------------");
        System.out.println("Generation # 0" + " | Fittest chromosome fitness: " +
                population.getChromosomes()[0].getFitness());
        printPopulation(population, "Target Chromosomes: " + Arrays.toString(GeneticAlgorithm.TARGET_CHROMOSOME));
        while (population.getChromosomes()[0].getFitness() < GeneticAlgorithm.TARGET_CHROMOSOME.length) {
            generationNumber++;
            System.out.println("---------------------------------------------------------");
            population = geneticAlgorithm.evolve(population);
            population.sortChromosomesByFitness();
            System.out.println("Generation #" + generationNumber + " | Fittest chromosome fittest: " +
                    population.getChromosomes()[0].getFitness());
            printPopulation(population, "Target Chromosome: " + Arrays.toString(GeneticAlgorithm.TARGET_CHROMOSOME));

        }
    }

    public static void printPopulation(Population population, String heading) {
        System.out.println(heading);
        System.out.println("---------------------------------------------------------");
        for (int x = 0; x < population.getChromosomes().length; x++) {
            System.out.println("Chromosome # " + x + " : " + Arrays.toString(population.getChromosomes()[x].getGenes())+
                    " | Fitness: " + population.getChromosomes()[x].getFitness());

        }
    }
}
