class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] suf = new int[n];
        // int[] prf = new int[n];
        // prf[0]=height[0];
        // for(int i=1;i<n;i++){
        //     prf[i]=Math.max(height[i],prf[i-1]);
        // }
        int leftMax = height[0];
        suf[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            suf[i]=Math.max(height[i],suf[i+1]);
        }
        int c = 0;
        for(int i=0;i<n;i++){
            leftMax = Math.max(leftMax,height[i]);
            if(height[i]<leftMax && height[i]<suf[i]){
                c+=Math.min(leftMax,suf[i])-height[i];
            }
        }
        return c;
    }
}