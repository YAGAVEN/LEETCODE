class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i+1][j+1]= grid[i][j]+dp[i+1][j]+dp[i][j+1]-dp[i][j];
                if(dp[i+1][j+1] <= k){
                    count++;
                }
            }
        }
        return count;
    }
}