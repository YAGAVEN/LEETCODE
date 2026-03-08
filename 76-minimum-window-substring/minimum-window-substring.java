class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length())return "";
        int[] count = new int[128];
        for(char c : t.toCharArray()){
            count[c]++;
        }
        int left = 0;
        int right = 0;
        int reg = t.length();
        int min = Integer.MAX_VALUE;
        int st = 0;
        while(right < s.length()){
            if(count[s.charAt(right)] > 0){
                reg--;
            }
            count[s.charAt(right)]--;
            right++;
            while(reg == 0){
                if(right-left < min){
                    min = right - left;
                    st = left;
                }
                count[s.charAt(left)]++;
                if(count[s.charAt(left)]>0){
                    reg++;
                }
                left++;
            }

        }
        return min == Integer.MAX_VALUE ? "" : s.substring(st,st+min);
        
    }
}