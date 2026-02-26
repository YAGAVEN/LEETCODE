class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String t = sb.toString();
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        return curse(n-1,m-1,s,t,dp);
    }
    public static int curse(int i, int j,String s,String t,int[][] dp){
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] = 1+curse(i-1,j-1,s,t,dp);
        }
        return dp[i][j]=Math.max(curse(i-1,j,s,t,dp),curse(i,j-1,s,t,dp));
    }
}