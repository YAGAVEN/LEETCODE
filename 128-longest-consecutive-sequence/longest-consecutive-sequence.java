class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int lcs = 0;
        int c = 0;
        for(int i : set){
            if(!set.contains(i-1)){
                c = con(set,i);
                lcs = Math.max(lcs,c);
            }
        }
        return lcs;
    }
    public int con(Set<Integer> set, int i){
        int co = 1;
        while(set.contains(i+1)){
            i++;
            co++;
        }
        return co;
    }
}