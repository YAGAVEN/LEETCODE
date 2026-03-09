class Solution {

    int MOD = 1_000_000_007;
    Integer[][][][] memo;

    public int numberOfStableArrays(int zero, int one, int limit) {

        memo = new Integer[zero + 1][one + 1][2][limit + 1];

        long startZero = dfs(zero - 1, one, 0, 1, limit);
        long startOne = dfs(zero, one - 1, 1, 1, limit);

        return (int)((startZero + startOne) % MOD);
    }

    private int dfs(int zero, int one, int last, int count, int limit) {

        if (zero < 0 || one < 0) return 0;

        if (zero == 0 && one == 0) return 1;

        if (memo[zero][one][last][count] != null)
            return memo[zero][one][last][count];

        long ans = 0;

        if (last == 0) {

            if (count < limit)
                ans += dfs(zero - 1, one, 0, count + 1, limit);

            ans += dfs(zero, one - 1, 1, 1, limit);

        } else {

            if (count < limit)
                ans += dfs(zero, one - 1, 1, count + 1, limit);

            ans += dfs(zero - 1, one, 0, 1, limit);
        }

        ans %= MOD;

        return memo[zero][one][last][count] = (int) ans;
    }
}