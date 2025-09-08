public class Solution {
    public int minStartValue(int[] nums) {
        int Sum = 0;
        int minSum = 0;

        for (int num : nums) {
            Sum += num;
            minSum = Math.min(minSum, Sum);
        }

        return 1 - minSum;
    }
}
