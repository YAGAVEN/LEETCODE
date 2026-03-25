class Solution {
    public int subsetXORSum(int[] nums){
        return xor(nums,0,0);
    }
    public int xor(int[] nums,int i, int sum){
        if(i==nums.length){
            return sum;
        }
        int inc = xor(nums,i+1,sum^nums[i]);
        int exc = xor(nums,i+1,sum);
        return inc+exc;
    }
}