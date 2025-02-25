class Solution {
    public int pivotIndex(int[] nums) {
        int totalsum = 0;
        int leftsum = 0;
        for(int num : nums){
            totalsum += num;
        }
        for(int i = 0;i<nums.length;leftsum += nums[i++]){
            if(leftsum * 2 == totalsum - nums[i]){
                return i;
            }
        }
        return -1;

    }
}