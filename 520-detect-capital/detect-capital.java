class Solution {
    public boolean detectCapitalUse(String word) {
        boolean fullUpperCase = true;
        boolean fullLowerCase = true;
        boolean generalCase = true;
        for(char c : word.toCharArray()){
            if(Character.toUpperCase(c) != c){
                fullLowerCase = false;
            }
        }
        for(char c : word.toCharArray()){
            if(Character.toLowerCase(c) != c){
                fullUpperCase = false;
            }
        }
        if(word.charAt(0) != Character.toUpperCase(word.charAt(0))){
                generalCase = false;
            }
        for(int i=1;i<word.length();i++){
            
            if( Character.toLowerCase(word.charAt(i)) != word.charAt(i)){
                generalCase = false;
            }
        }
        return (fullUpperCase || generalCase || fullLowerCase);
        
    }
}