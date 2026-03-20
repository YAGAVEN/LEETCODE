class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int n = nums.length;
        List<Integer> nonNeg = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                nonNeg.add(nums[i]);
                indices.add(i);
            }
        }
        int m = nonNeg.size();
        if (m == 0) return Arrays.copyOf(nums, n);
        k = k % m;
        List<Integer> rotated = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            rotated.add(nonNeg.get((i + k) % m));
        }
        int[] res = Arrays.copyOf(nums, n);
        for (int i = 0; i < m; i++) {
            res[indices.get(i)] = rotated.get(i);
        }
        return res;
    }
}