class Solution {
    public List<List<Integer>> subsetsBacktracking(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list,new ArrayList<>(),nums,0);
        return list;
    }
    public void backtrack(List<List<Integer>> list,List<Integer> temp,int[]nums, int st){
        list.add(new ArrayList<>(temp));
        for(int i=st;i<nums.length;i++){
            temp.add(nums[i]);
            backtrack(list,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int subSetCount = 1<<nums.length;
        for(int i=0;i<subSetCount;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if ((i & (1 << j)) != 0){
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        return ans;

   
    }

}