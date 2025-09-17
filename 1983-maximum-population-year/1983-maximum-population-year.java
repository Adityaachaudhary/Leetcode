class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] population = new int[101]; 

        for (int[] log : logs) {
            int birth = log[0], death = log[1];
            for (int year = birth; year < death; year++) {
                population[year - 1950]++;
            }
        }

        int maxPop = 0, year = 0;
        for (int i = 0; i < population.length; i++) {
            if (population[i] > maxPop) {
                maxPop = population[i];
                year = i;
            }
        }
        return 1950 + year;
    }
}