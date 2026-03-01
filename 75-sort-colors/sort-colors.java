class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int o = 0;
        int t = 0;
        for(int i:nums){
            if(i==1)o++;
            if(i==2)t++;
        }
        int z = n-o-t;
        for(int i=0;i<z;i++){
            nums[i]=0;
        }
        for(int i=z;i<z+o;i++){
            nums[i]=1;
        }
        for(int j=z+o;j<n;j++){
            nums[j]=2;
        }
        
    }
}