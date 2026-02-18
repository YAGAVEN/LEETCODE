class Solution {
    public int myAtoi(String str) {
        int i=0;
        int n=str.length();
        int sign = 1;
        int res = 0;
        while(i<n && str.charAt(i) == ' '){
            i++;
        }
        if(i<n && (str.charAt(i)=='+' || str.charAt(i)=='-')){
            if(str.charAt(i) == '-'){
                sign = -1;
            }
            i++;
        }
        while(i<n && Character.isDigit(str.charAt(i))){
            int k = str.charAt(i) - '0';
            if(res> (Integer.MAX_VALUE - k) /10){
                return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE; 
            }
            res = res*10 + k;
            i++;
        }
        return res * sign;
    }
}