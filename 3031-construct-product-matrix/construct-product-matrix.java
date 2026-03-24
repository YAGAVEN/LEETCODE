class Solution {
    public static int[][] constructProductMatrix(int[][] grid) {
        final int MOD = 12345;
        int n = grid.length;
        int m = grid[0].length;
        int total = n * m;

        int[][] result = new int[n][m];

        long prefix = 1;
        for (int idx = 0; idx < total; idx++) {
            int r = idx / m;
            int c = idx % m;

            result[r][c] = (int) prefix;
            prefix = (prefix * (grid[r][c] % MOD)) % MOD;
        }

        long suffix = 1;
        for (int idx = total - 1; idx >= 0; idx--) {
            int r = idx / m;
            int c = idx % m;

            result[r][c] = (int) ((result[r][c] * suffix) % MOD);
            suffix = (suffix * (grid[r][c] % MOD)) % MOD;
        }

        return result;
    }   
}