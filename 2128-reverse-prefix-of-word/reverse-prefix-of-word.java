class Solution {
    public String reversePrefix(String word, char ch) {
        int point = word.indexOf(ch);
        if(point != -1){
            String lh = word.substring(point+1,word.length());
            StringBuilder sb = new StringBuilder(word.substring(0,point+1));
            return sb.reverse().append(lh).toString();
            
        }
        else{
            return word;
        }
        

    }
}