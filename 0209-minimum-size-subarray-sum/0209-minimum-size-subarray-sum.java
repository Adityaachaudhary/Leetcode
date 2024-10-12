class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;  // Correct initialization
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
    // Check if current subarray sum meets or exceeds the target
            while (sum >= target) {
                min = Math.min(min, i - start + 1); // Update the minimum length
                sum -= nums[start];  // Shrink the window from the left
                start++;
            }
        }
        
        // If no valid subarray found, return 0
        if( min == Integer.MAX_VALUE){
            return  0;
        } 
        return min;
    }
}
