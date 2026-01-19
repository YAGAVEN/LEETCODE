class Solution {
    public boolean searchMatrix(int[][] matrix, int tar) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0,high=n * m-1;
        int mid = 0,row=0,col=0;
        while(low <= high){
            mid = (low + high)/2;
            row = mid/m;
            col=mid%m;
            if(matrix[row][col]==tar){
                return true;
            }
            else if(matrix[row][col] > tar){
               high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
        
    }
}