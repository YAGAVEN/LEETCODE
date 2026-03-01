class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for(int i=0;i<s.length();i+=2*k){
            rev(i,Math.min(i+k-1,s.length()-1),arr);
        }
        return new String(arr);    
    }
    public static void rev(int i,int j,char[]arr){
        int l=i;
        int r=j;
        while(l<r){
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}