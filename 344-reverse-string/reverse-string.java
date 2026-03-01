class Solution {
    // public void reverseString(char[] s) {
    //     int l = 0;
    //     int r = s.length-1;
    //     while(l<r){
    //         char temp = s[l];
    //         s[l]=s[r];
    //         s[r]=temp;
    //         l++;
    //         r--;
    //     }
        
    // }
        public void reverseString(char[] s) {
        StringBuilder sb = new StringBuilder();
        for(char i : s){
            sb.append(i);
        }
        sb.reverse();
        String str = sb.toString();
        for(int i=0;i<s.length;i++){
            s[i] = str.charAt(i);
        }
        
    }
}