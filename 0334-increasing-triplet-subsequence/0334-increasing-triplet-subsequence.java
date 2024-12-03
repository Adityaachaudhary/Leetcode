class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;

        int first = Integer.MAX_VALUE; //Smallest element found so far
        int second = Integer.MAX_VALUE; //Second smallest element found so far
        
        for(int num : nums){
            if(num <= first){
                first = num;
            }
            else if(num <= second){
                second = num;
            }
            else{
        //If we find an element larger than both, the triplet exists
                return true;
            }
        }
        return false;
    }
}