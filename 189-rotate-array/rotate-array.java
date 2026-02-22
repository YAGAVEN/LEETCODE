class Solution {
    public void rotate(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i:nums){
            list.add(i);
        }
        for(int i=0;i<k;i++){
            int last = list.removeLast();
            list.addFirst(last);
        }
        int j=0;
        for(int l:list){
            nums[j++]=l;
        }

    }
}