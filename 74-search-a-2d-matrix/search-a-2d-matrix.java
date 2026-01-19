class Solution {
    public boolean searchMatrix(int[][] matrix, int tar) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            if(matrix[i][0] <= tar && matrix[i][m-1]>= tar){
                return(binary(matrix[i],tar));
            }
        }
        return false;
        
    }
    public boolean binary(int[] mat, int tar){
        for(int i : mat){
            if(i==tar){
                return true;
            }
        }
        return false;
    }
}