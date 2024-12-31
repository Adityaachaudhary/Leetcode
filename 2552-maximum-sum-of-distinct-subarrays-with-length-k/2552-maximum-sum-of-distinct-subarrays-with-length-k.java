import java.util.HashMap;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;
        long winSum = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
        // Step 1: Include the right element
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            winSum += nums[i];

// Step 2: Exclude the left element if the window size exceeds k
            if (i >= k) {
                winSum -= nums[i - k];
                freq.put(nums[i - k], freq.get(nums[i - k]) - 1);
                if (freq.get(nums[i - k]) == 0) {
                    freq.remove(nums[i - k]);
                }
            }

// Step 3: Maximize maxSum if window size is k and all elements are unique
            if (i >= k - 1 && freq.size() == k) {
                maxSum = Math.max(maxSum, winSum);
            }
        }

        return maxSum;
    }
}
