class Solution {
    public int subtractProductAndSum(int n) {
        int pr = 1;
        int su = 0;
        while(n>0){
            int digi = n%10;
            pr *= digi;
            su += digi;
            n/=10;
        }
        return pr-su;
        
    }
}