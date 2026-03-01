class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        ArrayList<Character> list = new ArrayList<>(map.keySet());
        StringBuilder sb = new StringBuilder();
        list.sort((a,b)->map.get(b)-map.get(a));
        for(int i=0;i<list.size();i++){
            for(int j=0;j<map.get(list.get(i));j++){
                sb.append(list.get(i));
            }
        }
        return sb.toString();
        
    }
}