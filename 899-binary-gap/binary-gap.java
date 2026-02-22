class Solution {
    public int binaryGap(int n) {
        String str = Integer.toBinaryString(n);
        int ma = 0;
        int i=0;
        // while(i<str.length()){
        //     if(str.charAt(i)=='1')break;
        //     i++;
        // }
        int j=i+1;
        while(i<str.length() && j<str.length()){
            if(str.charAt(i) == '1' && str.charAt(j)== '1' ){
                int d = j-i;
                ma = Math.max(ma,d);
                i=j;
            }
            j++;
        }
        return ma;
    }
}