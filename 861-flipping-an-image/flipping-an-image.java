class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int m = image[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                image[i][j] = (image[i][j]==0)?1:0;
            }
        }
        for(int i = 0;i<n;i++){
            reverse(image[i]);
        }
        return image;
    }
    public void reverse(int[] arr){
        int i=0;
        int j=arr.length-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--; 
        }
    }
}