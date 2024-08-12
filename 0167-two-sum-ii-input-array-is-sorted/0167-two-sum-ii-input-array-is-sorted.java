class Solution {
    public int[] twoSum(int[] nums, int target) {
      int l = 0, r = nums.length - 1;
        
        // Iterate until the two pointers meet the target condition
        while (nums[l] + nums[r] != target) {
            // Move the left pointer right if the
            // sum is less than the target
            if (nums[l] + nums[r] < target) {
                l++;
            } 
            // Move the right pointer left if the
            // sum is greater than the target
            else {
                r--;
            }
        }

        // Return the indices of the two numbers, 
        //using 1-based index as specified
        return new int[] {l + 1, r + 1};
    }
}