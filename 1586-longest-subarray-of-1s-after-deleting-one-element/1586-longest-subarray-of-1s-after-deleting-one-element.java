class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int zeros = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (i < n && nums[i] == 1)
                i++;
            ans = Math.max(ans, i - j + zeros);
            zeros = i - j;
            j = i + 1;
        }
        return ans == n ? n - 1 : ans;
    }
}