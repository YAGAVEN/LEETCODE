class Solution {
    public int numTimesAllBlue(int[] flips) {
        int maxNum = 0 ;
        int c = 0;
        for(int i=0;i<flips.length;i++){
            maxNum = Math.max(maxNum,flips[i]);
            if(maxNum == i+1){
                c++;
            }
        }
        return c;
    }
}