class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // Sort both arrays to facilitate greedy matching
        Arrays.sort(players);
        Arrays.sort(trainers);
        
        int count = 0;
        int i = 0; // Pointer for players
        int j = 0; // Pointer for trainers
        
        // Iterate through both arrays to find matching pairs
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                // Found a match
                count++;
                i++;
                j++;
            } else {
                // Current trainer can't match this player, move to next trainer
                j++;
            }
        }
        return count;
    }
}