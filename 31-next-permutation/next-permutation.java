class Solution {
    public void nextPermutation(int[] nums) {
        int ind=-1;
        int n=nums.length-1;
        for(int i=n-1;i>=0;i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }
        if(ind==-1){
            reverse(0,n,nums);
            return;
        }
        for(int i=n;i>ind;i--){
            if(nums[i]>nums[ind]){
                swap(i,ind,nums);
                break;
            }
        }
        reverse(ind+1,n,nums);
    }
    private void swap(int i, int j, int[] arr){
        int t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    private void reverse(int i, int n, int[] arr){
        while(i<n){
            swap(i,n,arr);
            i++;
            n--;
        }
    }
}