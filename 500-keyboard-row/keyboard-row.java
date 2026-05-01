class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        int k = 0;
        ArrayList<String> list = new ArrayList<>();
        for(String str : words){
            boolean r1 = true;
            boolean r2 = true;
            boolean r3 = true;
            for(char c : str.toCharArray()){
                if(!row1.contains(String.valueOf(Character.toLowerCase(c)))){
                    r1  = false;
                }
                if(!row2.contains(String.valueOf(Character.toLowerCase(c)))){
                    r2  = false;
                }
                if(!row3.contains(String.valueOf(Character.toLowerCase(c)))){
                    r3  = false;
                }
            }
            if(r1 || r2 ||r3){
                list.add(str); 
            } 
        }
        String[] res = new String[list.size()];
        for(String s :  list){
            res[k++] = s;
        }
        return res;
    }
}