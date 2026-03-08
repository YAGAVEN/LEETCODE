class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;  
    }
        public int singleNumber1(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for(int i : nums){
            if(map.contains(i)){
                map.remove(i);
            }else{
                map.add(i); 
            }
        }
        for(int i : map){
            return i;
        }
        return -1;
    }
}