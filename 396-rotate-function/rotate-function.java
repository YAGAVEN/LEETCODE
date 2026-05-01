class Solution {
    public int maxRotateFunctionBruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int sum = 0;
            int k = i;
            for(int j=0;j<n;j++){
                k = k<n ? k : 0;
                sum += nums[k++] * j;
            }
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int sum = 0;
        int f0 = 0;

        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f0 += i * nums[i];
        }

        int max = f0;
        int fk = f0;

        for (int k = 1; k < n; k++) {
            fk = fk + sum - n * nums[n - k];
            max = Math.max(max, fk);
        }

        return max;
    }
}