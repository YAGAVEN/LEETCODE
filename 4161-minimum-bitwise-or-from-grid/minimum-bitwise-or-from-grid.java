class Solution {
    public int minimumOR(int[][] grid) {
        int m = grid.length;
        int ans = 0;
        int forbidden = 0;

        for (int bit = 31; bit >= 0; bit--) {
            int testForbidden = forbidden | (1 << bit);

            boolean canKeepBitZero = true;
            for (int i = 0; i < m; i++) {
                boolean foundSafe = false;
                for (int val : grid[i]) {
                    if ((val & testForbidden) == 0) {
                        foundSafe = true;
                        break;
                    }
                }
                if (!foundSafe) {
                    canKeepBitZero = false;
                    break;
                }
            }

            if (canKeepBitZero) {
                forbidden = testForbidden;
            } else {
                ans |= (1 << bit);
            }
        }

        return ans;
    }
}