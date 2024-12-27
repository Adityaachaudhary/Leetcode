class Solution {
    public int maxOperations(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int complement = k - num;

            // Check if the complement exists and has a positive count
            if (map.containsKey(complement) && map.get(complement) > 0) {
                count++;
                // Decrement the count for the complement
                map.put(complement, map.get(complement) - 1);
            } else {
                // Add or increment the count for the current number
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }
}