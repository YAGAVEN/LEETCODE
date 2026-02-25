class Solution {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] ans = new  int[n];
        int k=0;
        int j=0;
        while(k<n){
            for(int i=0;i<n;i++){
                if(Integer.bitCount(arr[i])==j){
                    ans[k++]=arr[i];
                }
            }
            j++;
        }
        return ans;
        
    }
}