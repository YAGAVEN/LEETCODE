class Solution {
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        int res = start;
        for(int i=1;i<n;i++){
            nums[i] = start + 2 * i;
            res^= nums[i];
        }
        return res;
        
    }
}