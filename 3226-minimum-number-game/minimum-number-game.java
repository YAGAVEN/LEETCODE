class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] sorted = nums.clone(); 
        int k=0;
        for(int i=1;i<nums.length;i+=2){
            nums[i] = sorted[i-1];
            nums[i-1] = sorted[i];
        }
        return nums;
    }
}