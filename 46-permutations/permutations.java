class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0,nums,ans);
        return ans;
    }
    private void swap( int i, int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void backtrack(int ind,int[] arr,List<List<Integer>> ans){
        if(ind==arr.length){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                list.add(arr[i]);
            }
            ans.add(list);
            return;
        }
        for(int i=ind;i<arr.length;i++){
            swap(i,ind,arr);
            backtrack(ind+1,arr,ans);
            swap(ind,i,arr);
        }
    }
}