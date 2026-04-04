class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int negInf = Integer.MIN_VALUE / 4;

        // dp[i][j][k] = best profit at (i, j) using exactly k neutralizations.
        int[][][] dp = new int[m][n][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = negInf;
                }
            }
        }

        int start = coins[0][0];
        dp[0][0][0] = start;
        if (start < 0) {
            dp[0][0][1] = 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                for (int k = 0; k < 3; k++) {
                    int bestPrev = negInf;
                    if (i > 0) {
                        bestPrev = Math.max(bestPrev, dp[i - 1][j][k]);
                    }
                    if (j > 0) {
                        bestPrev = Math.max(bestPrev, dp[i][j - 1][k]);
                    }
                    if (bestPrev != negInf) {
                        dp[i][j][k] = Math.max(dp[i][j][k], bestPrev + coins[i][j]);
                    }

                    // If current cell is a robber cell, optionally neutralize it.
                    if (coins[i][j] < 0 && k > 0) {
                        int bestPrevWithOneLess = negInf;
                        if (i > 0) {
                            bestPrevWithOneLess = Math.max(bestPrevWithOneLess, dp[i - 1][j][k - 1]);
                        }
                        if (j > 0) {
                            bestPrevWithOneLess = Math.max(bestPrevWithOneLess, dp[i][j - 1][k - 1]);
                        }
                        if (bestPrevWithOneLess != negInf) {
                            dp[i][j][k] = Math.max(dp[i][j][k], bestPrevWithOneLess);
                        }
                    }
                }
            }
        }

        int ans = Math.max(dp[m - 1][n - 1][0], dp[m - 1][n - 1][1]);
        ans = Math.max(ans, dp[m - 1][n - 1][2]);
        return ans;
    
    }
}