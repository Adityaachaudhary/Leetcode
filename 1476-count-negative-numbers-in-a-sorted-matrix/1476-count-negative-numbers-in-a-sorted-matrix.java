class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int[] row : grid) {
            count += countNegativesInRow(row);
        }

        return count;
    }

    // Binary search to find first negative in a row
    private int countNegativesInRow(int[] row) {
        int left = 0, right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] < 0) {
        // negatives might be to the left as well
                right = mid - 1;
            } else {
        // current and all left are >= 0, go right
                left = mid + 1;
            }
        }
        return row.length - left;
    }
}
