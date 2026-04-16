class Solution {
    public boolean canAliceWin(int[] nums) {
        int s = 0;
        int d = 0;
        for(int i: nums){
            if(i>=0 && i<=9){
                s+=i;
            }else if(i>9 && i<=99){
                d+=i;
            }
        }
        return !(d==s);
    }
}