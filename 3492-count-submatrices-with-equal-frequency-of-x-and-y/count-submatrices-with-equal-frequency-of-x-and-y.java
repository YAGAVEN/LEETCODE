class Solution {
    public int numberOfSubmatrices(char[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    int[][] px = new int[n+1][m+1]; 
    int[][] py = new int[n+1][m+1]; 

    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            int isX = (grid[i][j] == 'X') ? 1 : 0;
            int isY = (grid[i][j] == 'Y') ? 1 : 0;

            px[i+1][j+1] = px[i][j+1] + px[i+1][j] - px[i][j] + isX;
            py[i+1][j+1] = py[i][j+1] + py[i+1][j] - py[i][j] + isY;
        }
    }

    int count = 0;

    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            int x = px[i+1][j+1];
            int y = py[i+1][j+1];

            if(x == y && x > 0){
                count++;
            }
        }
    }

    return count;
}
}