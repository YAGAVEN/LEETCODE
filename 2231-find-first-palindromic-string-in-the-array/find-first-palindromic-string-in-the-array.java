class Solution {
    public String firstPalindrome(String[] words) {
        for(String s : words){
            if(isPalindrome(s)){
                return s;
            }
        }
        return "";

        
    }
    public boolean isPalindrome(String s ){
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }
}