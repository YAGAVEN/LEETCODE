class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int maxlen = 0;
        for(int i:set){
            if(!set.contains(i-1)){
                int cur = i;
                int len = 1;
                while(set.contains(cur+1)){
                    cur++;
                    len++;
                }
                maxlen = Math.max(len,maxlen);
            }
        }
        return maxlen;
        
    }
}