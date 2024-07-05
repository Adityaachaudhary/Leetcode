class Solution {
    //public int numSubseq(int[] nums, int target) {
        private static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] power = new int[n];
        power[0] = 1;

        // Precompute powers of 2 modulo MOD
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1;
        int count = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // All subsequences between left and right are valid
                count = (count + power[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
    }
