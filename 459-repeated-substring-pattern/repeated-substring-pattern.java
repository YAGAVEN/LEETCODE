class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s==null || s.length()<=1)return false;
        String doubled = s + s ;
        String window = doubled.substring(1,doubled.length()-1);
        return window.contains(s);

    }
}