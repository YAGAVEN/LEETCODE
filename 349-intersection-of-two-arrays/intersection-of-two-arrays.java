class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums1){
            set.add(i);
        }
        HashSet<Integer> list = new HashSet<>();
        for(int i:nums2){
            if(set.contains(i)){
                list.add(i);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();        
    }
}