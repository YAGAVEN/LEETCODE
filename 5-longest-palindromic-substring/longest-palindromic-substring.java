class Solution {
    public String longestPalindrome(String s) {
        int c=0;
        int p =0;
        int e =0;
        for(int i=0;i<s.length();i++){
            int len1 = expand(s,i,i+1);
            int len2 = expand(s,i,i);
            int len = Math.max(len1,len2);
            if(c<len){
                c=len;
                p=i-(len-1)/2;
                e=i+len/2;
            }
        }
        return s.substring(p,e+1);

    }
    public int expand(String s, int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
}
class BruteForce{
    public String longestPalindrome(String s) {
        if(s.length()== 1)return s;
        int ma = 0;
        String  ans = "";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String x = s.substring(i,j+1);
                if(isPalind(x) && x.length() > ma){           
                ans =x;
                ma = x.length();
                }
            }
        }
        return ans;
        
    }
    public boolean isPalind(String s){
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }
}