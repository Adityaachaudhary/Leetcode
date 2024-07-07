class Solution {
   // public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

    private static final int MOD = 1_000_000_007;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] sortedNums1 = Arrays.copyOf(nums1, n);
        Arrays.sort(sortedNums1);

        long originalSum = 0;
        for (int i = 0; i < n; i++) {
            originalSum += Math.abs(nums1[i] - nums2[i]);
        }

        long minSum = originalSum;
        for (int i = 0; i < n; i++) {
            int originalDiff = Math.abs(nums1[i] - nums2[i]);
            int bestReplacementDiff = originalDiff;

            // Binary search for the closest element in sortedNums1
            int pos = binarySearchClosest(sortedNums1, nums2[i]);
            
            if (pos < n) {
                bestReplacementDiff = Math.min(bestReplacementDiff, Math.abs(sortedNums1[pos] - nums2[i]));
            }
            if (pos > 0) {
                bestReplacementDiff = Math.min(bestReplacementDiff, Math.abs(sortedNums1[pos - 1] - nums2[i]));
            }

            long newSum = originalSum - originalDiff + bestReplacementDiff;
            minSum = Math.min(minSum, newSum);
        }

        return (int) (minSum % MOD);
    }

    private int binarySearchClosest(int[] sortedArr, int target) {
        int left = 0, right = sortedArr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (sortedArr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

 
}
