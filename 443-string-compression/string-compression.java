class Solution {
    public int compress(char[] chars) {
        StringBuilder str = new StringBuilder();
        int count = 1;
        int n = chars.length;
        char chr = chars[0]; 
        for(int i=1;i<n;i++){
            if(chr == chars[i]){
                count++;
            }
            else{
                str.append(chr);
                if(count > 1){
                    str.append(count);
                }  
                count = 1;
                chr = chars[i];
            }
            
        }
        str.append(chr+"");
        if(count>1){
            str.append(count+"");
        }    
        String s = str.toString();
        int ind = 0;
        for(char c : s.toCharArray()){
            chars[ind++] = c;
        }
        return s.length();
    }
}