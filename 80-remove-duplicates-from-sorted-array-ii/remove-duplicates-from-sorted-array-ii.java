class Solution {
    public int removeDuplicates(int[] nums) {
        TreeMap<Integer,Integer> map  = new TreeMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int k=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                nums[k++] = entry.getKey();
            }else{
                nums[k++] = entry.getKey();
                nums[k++] = entry.getKey();
            }
        }
        return k;
        
    }
}