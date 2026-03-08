class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
        
    }
    public int binarySearch(int[] nums , int x,int left , int right){
        if(left > right)return -1;
        int mid = left + (right - left) / 2;
        if(nums[mid] == x){
            return mid;
        }else if(nums[mid] > x){
            return binarySearch(nums,x,left,mid-1);
        }else{
            return binarySearch(nums,x,mid+1,right);
        }

    }
}