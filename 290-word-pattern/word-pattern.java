class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if(pattern.length()!=str.length)return false;
        HashMap<Character,String> map1 = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            String sb = str[i];
            if(map1.containsKey(c)){
                if(!map1.get(c).equals(sb))return false;
            }
            else{
                map1.put(c,sb);
            }
            if(map2.containsKey(sb)){
                if(!map2.get(sb).equals(c))return false;
            }
            else{
                map2.put(sb,c);
            }
        }
        return true;
        
    }
}