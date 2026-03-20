class Solution {
    public long nthSmallest(long n, int k) {
        if (k == 1)
            return 1L << (n - 1);
        int M = 51;
        long[][] dp = new long[M][M];
        for (int i = 0; i < M; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
            }
        }
        long ans = 0;
        int bits = k;
        long rank = n;
        for (int i = bits; i > 0; i--) {
            for (int j = 0; j < M; j++) {
                long count = dp[i - 1][j];
                if (rank > count) {
                    rank -= count;
                } else {
                    ans |= (1L << j);
                    break;
                }
            }
        }
        return ans;
    }
}