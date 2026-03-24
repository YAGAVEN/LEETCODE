class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)){
                sb.append(c);
            }
        }
        String str = sb.reverse().toString();
        StringBuilder sk = new StringBuilder();
        int k=0;
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)){
                sk.append(str.charAt(k++));
            }
            else{
                sk.append(c);
            }
        }
        return sk.toString();
        
    }
}