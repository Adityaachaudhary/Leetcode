class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        int[] dp = new int[200001]; // This array will keep track of the frequency of each number in nums.

        for (int i : nums) {
            // Update count based on the frequencies of (i - k) and (i + k)
            if (i - k >= 0) count += dp[i - k];
            if (i + k <= 200000) count += dp[i + k];

            // Update the frequency array
            dp[i]++;
        }

        return count;
    }
}
