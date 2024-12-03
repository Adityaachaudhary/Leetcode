class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        
        // If the array is empty, return an empty output (edge case not necessary as per problem constraints)
        if (n == 0) {
            return output;
        }
        
        int product = 1;
        
        // Traverse from the left and calculate product
        for (int i = 0; i < n;i++) {
            output[i] = product;
            product *= nums[i];
        }
        
        // Traverse from the right and update the output array
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= product;
            product *= nums[i];
        }
        
        return output;
    }
}
