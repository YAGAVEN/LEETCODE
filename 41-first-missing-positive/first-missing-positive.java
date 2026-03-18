class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            if(i>=0){
                set.add(i);
            }
        }
        int j=1;
        while(set.contains(j)){
            j++;
        }
        return j;
        
    }
}