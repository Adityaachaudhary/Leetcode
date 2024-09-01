class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/ 2;

            // Check if mid is the target
            if (nums[mid] == target) {
                return mid;
            }

             // Determine which part is sorted
            if (nums[left] <= nums[mid]) {
                 // Left side is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;// Search in the left half
                } else {
                    left = mid + 1;// Search in the right half
                }
            } else {
                // Right side is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;// Search in the right half
                } else {
                    right = mid - 1;// Search in the left half
                }
            }
        }
          // Target not found
        return -1;
    }
}