class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        HashMap<Character,Character> maps = new HashMap<>();
        HashMap<Character,Character> mapt = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);
            char j = t.charAt(i);
            if(maps.containsKey(x)){
                if(maps.get(x)!=j){
                    return false;
                }    
            }else{
                maps.put(x,j);
            }
            if(mapt.containsKey(j)){
                if(mapt.get(j)!=x){
                    return false;
                }
            }else{
                mapt.put(j,x);
            }
        }
        return true;
    }
}