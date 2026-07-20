class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<k;i++){
            grid = shift(grid,grid.length,grid[0].length);
        }
        for(int[] arr : grid){
            List<Integer> list = new ArrayList<>();
            for(int i : arr){
                list.add(i);
            }
            ans.add(list);
        }
        return ans;
        
    }
    public int[][] shift(int[][] grid, int m, int n) {

         int[][] ans = new int[m][n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {

            if (j != n - 1) {
                ans[i][j + 1] = grid[i][j];
            }
            else if (i != m - 1) {
                ans[i + 1][0] = grid[i][j];
            }
            else {
                ans[0][0] = grid[i][j];
            }
        }
    }

    return ans;
}
}