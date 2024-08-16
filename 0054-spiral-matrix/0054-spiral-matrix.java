class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Step 1: Initialize the result list where we'll 
        //store the spiral order elements.
        List<Integer> result = new ArrayList<>();

        // Step 2: Check if the matrix is empty or null. 
        //If it is, return the empty result list.
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        // Step 3: Initialize boundaries for the matrix traversal.
        int rows = matrix.length;          // Number of rows in the matrix.
        int cols = matrix[0].length;       // Number of columns in the matrix.
        int left = 0;                      // The left boundary (starting from the first column).
        int right = cols - 1;              // The right boundary (starting from the last column).
        int top = 0;                       // The top boundary (starting from the first row).
        int bottom = rows - 1;             // The bottom boundary (starting from the last row).

        // Step 4: Traverse the matrix in a spiral order 
        //until all boundaries collapse.
        while (left <= right && top <= bottom) {
            // Traverse from left to right across the top boundary.
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;  // Move the top boundary down.

            // Traverse from top to bottom along the right boundary.
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;  // Move the right boundary left.

            // Check if there is still a valid row to process after 
            //adjusting the top boundary.
            if (top <= bottom) {
                // Traverse from right to left across the bottom boundary.
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;  // Move the bottom boundary up.
            }

            // Check if there is still a valid column to process
            // after adjusting the right boundary.
            if (left <= right) {
                // Traverse from bottom to top along the left boundary.
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;  // Move the left boundary right.
            }
        }

        // Step 5: Return the result list containing elements in spiral order.
        return result;
    }
}
