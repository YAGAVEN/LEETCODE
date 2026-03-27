class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(1,n,k,ans,list);
        return ans;
        
    }
     public static void backtrack(int i,int n,int k,List<List<Integer>> ans , List<Integer> list) {
        if(list.size()==k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i>n)return;
        list.add(i);
        backtrack(i+1,n,k,ans,list);
        list.remove(list.size() - 1);
        backtrack(i+1,n,k,ans,list);
    }
}