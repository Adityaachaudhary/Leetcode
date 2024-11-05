class Solution {
    
    public int maxFrequency(int[] nums, int k) {
    Arrays.sort(nums); // Sort the input array in ascending order.

    int i = 0; // Initialize a pointer i at the beginning of the sorted array.
    long sum = 0; // Initialize a variable to keep track of the sum of elements within the window.
    int maxlen = 1; // Initialize the maximum window length.

    for (int j = 0; j < nums.length; j++) {
        sum += nums[j]; // Add the current element to the sum.

        // Use a while loop to adjust the window size to maximize the window length without exceeding k.
        while ((long)nums[j] * (j - i + 1) > sum + k) {
            sum -= nums[i]; // Remove the element at position i from the window.
            i++; // Increment i to make the window smaller (moving the left end to the right).
        }

        maxlen = Math.max(maxlen, j - i + 1); // Update the maximum window length.
    }

    return maxlen; // Return the maximum window length.
}
}
