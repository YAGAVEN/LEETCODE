class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == (n/3)+1) {
                list.add(nums[i]);
            }

            if (list.size() == 2) break;
        }
        
        return list;
    }
}