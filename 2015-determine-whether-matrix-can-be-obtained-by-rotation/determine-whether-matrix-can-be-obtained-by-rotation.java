class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i = 0;i<4;i++){
            if(check(mat,target)){
                return true;
            }
            mat = rotate(mat);
        }
        return false;
    }
    public boolean check(int[][] mat,int[][] tar){
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0; j<m;j++){
                if(mat[i][j] != tar[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public int[][] rotate(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[j][n - 1 - i] = mat[i][j];
            }
        }
        return ans;
    }
}