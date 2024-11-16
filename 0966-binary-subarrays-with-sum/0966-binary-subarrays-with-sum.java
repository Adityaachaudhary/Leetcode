class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1); // Base case: prefix sum of 0 occurs once
        
        for (int num : nums) {
            sum += num;
            
            // Check if there's a prefix sum that satisfies the condition
            if (prefixSumFreq.containsKey(sum - goal)) {
                count += prefixSumFreq.get(sum - goal);
            }
            
            // Update the frequency of the current prefix sum
            prefixSumFreq.put(sum, prefixSumFreq.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
