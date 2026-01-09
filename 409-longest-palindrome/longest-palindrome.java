class Solution {
    public int longestPalindrome(String s) {
        if( s==null || s.length()==0){
            return 0;
        }
        int freq[] = new int[128];
        for(char c : s.toCharArray()){
            freq[c]++;
        }
        int len = 0;
        boolean has = false;
        for(int i : freq){
            len += (i/2)*2;
            if(i%2==1){
                has=true;
            }
        }
        if(has){
            len+=1;
        }
        return len;
    }
}