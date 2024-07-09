class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            // Check for existing pairs with difference k
            count += map.getOrDefault(num - k, 0);
            count += map.getOrDefault(num + k, 0);

            // Update the frequency map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}
