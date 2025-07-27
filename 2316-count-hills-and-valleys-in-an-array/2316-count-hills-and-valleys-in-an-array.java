class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int count = 0;
        int i = 1;

        while (i < n - 1) {
            // Skip duplicates
            if (nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            // Find the closest non-equal neighbor on the left
            int left = i - 1;
            while (left >= 0 && nums[left] == nums[i]) {
                left--;
            }

            // Find the closest non-equal neighbor on the right
            int right = i + 1;
            while (right < n && nums[right] == nums[i]) {
                right++;
            }

            // If either side doesn't have a neighbor, skip
            if (left < 0 || right >= n) {
                i++;
                continue;
            }

            // Check if current is a hill or valley
            if (nums[i] > nums[left] && nums[i] > nums[right]) {
                count++;
            } else if (nums[i] < nums[left] && nums[i] < nums[right]) {
                count++;
            }

            i++;
        }
        return count;
    }
}