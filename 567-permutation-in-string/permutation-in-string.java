class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())return false;
        int[] s1c = new int[26];
        int[] win = new int[26];
        for(char c : s1.toCharArray()){
            s1c[c-'a']++;
        }
        int left = 0;
        for(int right = 0;right<s2.length();right++){
            win[s2.charAt(right)-'a']++;
            if(right -left + 1 > s1.length()){
                win[s2.charAt(left)-'a']--;
                left++;
            }
            if(Arrays.equals(win,s1c))return true;
        }
        return false;

        
    }
}