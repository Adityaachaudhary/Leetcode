class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSumCount = new int[n + 1]; // Array to store prefix sums
        prefixSumCount[0] = 1; // Base case: prefix sum of 0 occurs once
        int count = 0, oddCount = 0;
        
        for (int num : nums) {
            // Increment oddCount if the current number is odd
            oddCount += num % 2;
            
            // Check if there exists a subarray with exactly k odd numbers
            if (oddCount >= k) {
                count += prefixSumCount[oddCount - k];
            }
            
            // Increment the count of the current prefix sum
            prefixSumCount[oddCount]++;
        }
        
        return count; // Return the total number of valid subarrays
    }
}
