class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ori = image[sr][sc];
        if(ori==color)return image;
        dsf(image,sr,sc,color,ori);
        return image;    
    }
    private void dsf(int[][] mat,int i,int j,int c,int ori){
        if(i<0||j<0||i>=mat.length||j>=mat[0].length||mat[i][j]!=ori){
            return;
        }
        mat[i][j]=c;
        dsf(mat,i+1,j,c,ori);
        dsf(mat,i-1,j,c,ori);
        dsf(mat,i,j+1,c,ori);
        dsf(mat,i,j-1,c,ori);

    }
}