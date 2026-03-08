class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{first(nums,target),last(nums,target)};
    }
    private int first(int []nums, int x){
        int l = 0;
        int r = nums.length-1;
        int ans = -1;
        while(l<=r){
            int mid = l +(r-l)/2;
            if(nums[mid]==x){
                r = mid-1;
                ans = mid;
            }
            else if(nums[mid] < x){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;  
    }
    private int last(int []nums, int x){
        int l = 0;
        int r = nums.length-1;
        int ans = -1;
        while(l<=r){
            int mid = l +(r-l)/2;
            if(nums[mid]==x){
                l = mid+1;
                ans = mid;
            }
            else if(nums[mid] < x){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;    
    }
}