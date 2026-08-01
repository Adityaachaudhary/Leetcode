class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        
        //If the net score is 0 or positive, Player 1 wins
        return getScore(nums, 0, n - 1, memo) >= 0;
    }

    private int getScore(int[] nums, int left, int right, Integer[][] memo) {
        //only one number left
        if (left == right) {
            return nums[left];
        }
        
        //If we already calculated this state, just return it
        if (memo[left][right] != null) {
            return memo[left][right];
        }

        int pickLeft = nums[left] - getScore(nums, left + 1, right, memo);
        
        int pickRight = nums[right] - getScore(nums, left, right - 1, memo);

        memo[left][right] = Math.max(pickLeft, pickRight);
        return memo[left][right];
    }
}