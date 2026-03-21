class Solution {
    public int[][] reverseSubmatrixYagaven(int[][] grid, int x, int y, int k) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=x;i<((k-1)+x)/2;i++){
            for(int j=y;j<((k-1)+y)/2;j++){
                int temp = grid[i][j];
                grid[i][j] = grid[(k-1)+i][j];
                grid[(k-1)+i][j] = temp;
            }
        }
        return grid;
    }
        public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int rowOffset = 0; rowOffset < k / 2; rowOffset++) {
            int top = x + rowOffset;
            int bottom = x + k - 1 - rowOffset;
            for (int col = y; col < y + k; col++) {
                int temp = grid[top][col];
                grid[top][col] = grid[bottom][col];
                grid[bottom][col] = temp;
            }
        }
        return grid;
    }
}