class Solution {
    public int climbStairs(int n) {
        if(n<=2)return n;
        int p2 = 1;
        int p1 = 2;
        for(int i=3;i<=n;i++){
            int c = p1+p2;
            p2 = p1;
            p1 =c; 
        }
        return p1;

    }

}