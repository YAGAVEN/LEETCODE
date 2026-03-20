class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;
        int suffixStart = n - 1;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                suffixStart = i - 1;
                continue;
            } else {
                suffixStart = i;
                break;
            }
        }
        return suffixStart;
    }
}