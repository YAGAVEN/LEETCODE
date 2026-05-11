class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list  = new ArrayList<>();
        for(int i: nums){
            addSplit(i,list);
        }
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
    public void addSplit(int i , ArrayList<Integer> list){
        String s = i+"";
        for( char c : s.toCharArray()){
            list.add(Integer.parseInt(c+""));
        }
    }
}