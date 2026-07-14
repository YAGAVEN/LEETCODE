class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                int s = nums[i]+nums[l]+nums[r];
                if(s==0){
                    ArrayList<Integer> li = new ArrayList<>();
                    li.add(nums[i]);
                    li.add(nums[l]);
                    li.add(nums[r]);
                    ans.add(li);
                    l++;
                    r--;
                    while(l<r && nums[l-1]==nums[l])l++;
                    while(l<r && nums[r+1]==nums[r])r--;
                }
                else if(s > 0){
                    r--;
                }else if(s< 0){
                    l++;
                }


            }

        }
        return ans;
    }
}