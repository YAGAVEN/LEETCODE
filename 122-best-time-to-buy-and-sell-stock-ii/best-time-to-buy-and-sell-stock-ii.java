class Solution {
    public int maxProfit(int[] prices) {
        int n  = prices.length;
        int ma = 0;
        int mi = prices[0];
        for(int i=1;i<n;i++){
            int p = prices[i] - prices[i-1];
            if(prices[i] > prices[i-1]){
                ma += p;
            }
        }
        return ma;
        
    }
}