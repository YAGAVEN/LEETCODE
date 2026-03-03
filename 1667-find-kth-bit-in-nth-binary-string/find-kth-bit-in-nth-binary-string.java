class Solution {
    public char findKthBit(int n, int k) {
        String str = "0";
        while(n>1){
            str = str + "1" + invert(rev(str));
            n--;
        }
        return str.charAt(k-1);   
    }
    public String rev(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    public String invert(String str){
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            if(c == '0'){
                sb.append('1');
            }else{
                sb.append('0');
            }
        }
        return sb.toString();
    }
}