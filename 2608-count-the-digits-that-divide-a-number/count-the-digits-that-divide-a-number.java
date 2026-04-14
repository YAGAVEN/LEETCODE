class Solution {
    public int countDigits(int num) {
        int count = 0;
        int n = num;
        while(n>0){
            int digi = n%10;
            if(num % digi == 0){
                count++;
            }
            n/=10;
        }
        return count;
        
    }
}