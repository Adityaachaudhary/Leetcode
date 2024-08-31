class Solution {
    public int[] rearrangeArray(int[] nums) {
        int [] ans = new int[nums.length];
        int postIndex=0;
        int negIndex=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < 0){
                ans[negIndex] = nums[i];
                negIndex += 2;

            }
            else{
                ans[postIndex] = nums[i];
                postIndex += 2;
            }
        }
        return ans;

        
    }
}