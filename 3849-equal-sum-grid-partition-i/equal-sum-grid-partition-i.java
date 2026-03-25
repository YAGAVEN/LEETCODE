class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        long totalSum = 0L;
        long[] colSums = new long[cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                totalSum += grid[r][c];
                colSums[c] += grid[r][c];
            }
        }

        if ((totalSum & 1L) == 1L) {
            return false;
        }

        long target = totalSum / 2L;

        long topSum = 0L;
        for (int r = 0; r < rows - 1; r++) {
            for (int c = 0; c < cols; c++) {
                topSum += grid[r][c];
            }
            if (topSum == target) {
                return true;
            }
        }

        long leftSum = 0L;
        for (int c = 0; c < cols - 1; c++) {
            leftSum += colSums[c];
            if (leftSum == target) {
                return true;
            }
        }

        return false;
    }
}