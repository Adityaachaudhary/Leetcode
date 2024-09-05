class Solution {
    public int maxSubArray(int[] nums) {
        int firstSum= nums[0];
        int maxSum= nums[0];
        for(int i=1;i<nums.length;i++){
            if(firstSum<0){
                firstSum=0;
            }
        
        firstSum +=nums[i];
        maxSum = Math.max(maxSum,firstSum);
    }
    
    return maxSum;
}
}