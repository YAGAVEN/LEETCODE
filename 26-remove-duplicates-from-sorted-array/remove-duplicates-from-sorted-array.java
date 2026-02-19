class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        LinkedHashSet<Integer> arr = new LinkedHashSet<>();
        for(int i:nums){
            arr.add(i);
        }
        int k=0;
        for(int i :arr){
            nums[k++]=i;
        }
        return k;
        
    }
}