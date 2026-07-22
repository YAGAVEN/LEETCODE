class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> ans = new ArrayList<>();
        int i=1;
        int val=0;
        while(n>0){
            val = n%10;
            if((val*i)!=0){
                ans.add(val*i);
            }
            i*=10;
            n/=10;
        }
        Collections.sort(ans,Collections.reverseOrder());
        int[] arr = new int[ans.size()];
        i=0;
        for(int k : ans){
            arr[i++] = k;
        }
        return arr;
        
        
    }
}