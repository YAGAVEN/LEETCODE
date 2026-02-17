class Solution {
    public String reverseWords(String s) {
        String[] str = s.split("\\s+");
        int i = 0;
        int j = str.length-1;
        while(i<j){
            String temp = str[i];
            str[i] = str[j];
            str[j]=temp;
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        for(String sk : str){
            sb.append(sk);
            sb.append(" ");
        }
        return sb.toString().trim();
        
    }
}