class Solution {
    public int searchInsert(int[] nums, int x) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
                int mid = left + (right - left) / 2;
            if(nums[mid] == x){
                return mid;
            }else if(nums[mid] > x){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }  
        return left;  
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