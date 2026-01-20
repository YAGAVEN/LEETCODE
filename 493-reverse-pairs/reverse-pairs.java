class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return merge_sort(nums,0,n-1);
    }
    public int  merge_sort(int[] nums,int low,int high){
        int c = 0;
        if(low>=high)return c;
        int mid = (low+high)/2;
        c += merge_sort(nums,low,mid);
        c += merge_sort(nums,mid+1,high);
        c += count_pairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return c;
    }
    public int count_pairs(int[] nums,int low,int mid, int high){
        int c = 0;
        int right = mid+1;
        for(int i=low;i<=mid;i++){
            while(right <= high && nums[i] > 2L*nums[right]){
                right++;
            }
            c += right - (mid+1);
        }
        return c;
    }
    public void merge(int[] nums, int low, int mid, int high){
        List<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high){
            if(nums[left]<= nums[right]){
                list.add(nums[left]);
                left++;
            }else{
                list.add(nums[right]);
                right++;
            }
        }
        while(left <= mid){
            list.add(nums[left]);
            left++;
        }
        while(right <= high){
            list.add(nums[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            nums[i] = list.get(i -low);
        }
    }
}