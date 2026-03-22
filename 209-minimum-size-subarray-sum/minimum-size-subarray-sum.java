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
    public int minSubArrayLenBrute(int target ,int[] nums){
        int n = nums.length;
        int min  = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                if(sum >= target){
                    min = Math.min(min,j - i + 1);
                    break;
                }
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}