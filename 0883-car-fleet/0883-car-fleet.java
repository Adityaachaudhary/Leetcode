class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // Create a list of cars as pairs of position and speed
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort cars in descending order of position
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 0;
        double time = 0;

        // Calculate the time each car takes to reach the target
        for (int[] car : cars) {
            double currentTime = (double) (target - car[0]) / car[1];
            // If the current car's time is greater than the last recorded time,
            // it forms a new fleet
            if (currentTime > time) {
                time = currentTime;
                fleets++;
            }
        }

        return fleets;
    }
}
