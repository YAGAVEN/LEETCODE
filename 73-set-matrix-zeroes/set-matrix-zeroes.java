class Solution {
    public void setZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] col = new int[n];
        int[] row = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    col[i]=1;
                    row[j]=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(col[i]==1 || row[j]==1){
                    mat[i][j]=0;
                }
            }
        }
        
    }
}