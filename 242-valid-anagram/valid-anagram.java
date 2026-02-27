class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        // char[] sa = s.toCharArray();
        // char[] ta = t.toCharArray();
        // Arrays.sort(sa);
        // Arrays.sort(ta);
        // s = Arrays.toString(sa);
        // t = Arrays.toString(ta);
        // return s.equals(t);
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
            }else{
                return false;
            }
        }
        for(int i : map.values()){
            if(i<0){
                return false;
            }
        }
        return true;
        
    }
}