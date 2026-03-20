class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] ans = new int[m - k + 1][n - k + 1];
    for (int i = 0; i <= m - k; i++) {
        for (int j = 0; j <= n - k; j++) {
            // Collect all values in the k x k submatrix
            java.util.Set<Integer> values = new java.util.HashSet<>();
            for (int x = i; x < i + k; x++) {
                for (int y = j; y < j + k; y++) {
                    values.add(grid[x][y]);
                }
            }
            if (values.size() <= 1) {
                ans[i][j] = 0;
            } else {
                // Sort the distinct values
                java.util.List<Integer> sorted = new java.util.ArrayList<>(values);
                java.util.Collections.sort(sorted);
                int minDiff = Integer.MAX_VALUE;
                for (int idx = 1; idx < sorted.size(); idx++) {
                    minDiff = Math.min(minDiff, Math.abs(sorted.get(idx) - sorted.get(idx - 1)));
                }
                ans[i][j] = minDiff;
            }
        }
    }
    return ans;
}
}