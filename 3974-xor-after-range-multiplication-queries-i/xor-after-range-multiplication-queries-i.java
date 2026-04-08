class Solution {
    private static final int MOD = 1_000_000_007;
    public static int xorAfterQueries(int[] nums, int[][] queries) {

        // Brute force: apply each query by iterating on li, li + ki, ... <= ri.
        for (int[] query : queries) {
            int li = query[0];
            int ri = query[1];
            int ki = query[2];
            int vi = query[3];

            for (int idx = li; idx <= ri; idx += ki) {
                long updated = ((long) nums[idx] * vi) % MOD;
                nums[idx] = (int) updated;
            }
        }

        int xor = 0;
        for (int value : nums) {
            xor ^= value;
        }
        return xor;
    }
}