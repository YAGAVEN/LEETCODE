class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int k = 0;
        int[] arr = new int[nums.length];
        int l = nums.length-1;
        for(int i:nums){
            if(i%2==0){
                arr[k++] = i;
            }else{
                arr[l--] = i;
            }
        }
        return arr;
        
    }
}