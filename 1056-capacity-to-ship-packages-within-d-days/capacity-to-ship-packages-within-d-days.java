class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = getMax(weights);
        int r = getSum(weights);

        while(l<r){
            int mid = l + (r-l)/2;
            if(canShip(weights,days,mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    public boolean canShip(int[] arr,int d , int n){
        int dn = 1;
        int ld = 0;
        for(int i:arr){
            if(ld + i > n){
                dn++;
                ld=0;
            }
            ld += i;
        }
        return dn <= d;
    }
    public int getMax(int[] arr){
        int max = 0;
        for(int i:arr){
            max = Math.max(max,i);
        }
        return max;
    }
    public int getSum(int[] arr){
        int sum = 0;
        for(int i:arr){
            sum+= i;
        }
        return sum;
    }
}