class Solution {
    public int minOperations(String s) {
        int countwith0 = 0;
        int countwith1 = 0;
        for(int i=0;i<s.length();i++){
            char exp0 = (i%2==0)?'0':'1';
            char exp1 = (i%2==0)?'1':'0';
            if(s.charAt(i)!=exp0){
                countwith0++;
            }
            if(s.charAt(i)!=exp1){
                countwith1++;
            }
        }
        return Math.min(countwith0,countwith1);
        
    }
    public int minOperationsYagaven(String s) {
        if(s.charAt(0)=='1'){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i+=2){
                sb.append("10");
            }
            String ori = sb.toString();
            int c=0;
            for(int i=0;i<s.length();i++){
                if(ori.charAt(i)!=s.charAt(i)){
                    c++;
                }
            }
            return c;

        }else{
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i+=2){
                sb.append("01");
            }
            String ori = sb.toString();
            int c=0;
            for(int i=0;i<s.length();i++){
                if(ori.charAt(i)!=s.charAt(i)){
                    c++;
                }
            }
            return c;
        }
        
    }
}