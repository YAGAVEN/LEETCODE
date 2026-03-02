class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int minSize=Integer.MAX_VALUE;
        int curr=0;
        for(int right=0;right<nums.length;right++){
            curr += nums[right];
            while(curr >= target){
                minSize = Math.min(minSize,right-left+1);
                curr -= nums[left];
                left++;
            }
        }
        return (minSize==Integer.MAX_VALUE) ? 0 : minSize;
        
    }
}