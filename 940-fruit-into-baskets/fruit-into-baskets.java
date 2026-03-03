class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int ma = 0;
        for(int i=0;i<n;i++){
            if(n-i <= ma) break;
            HashSet<Integer> set = new HashSet<>();
            for(int j=i;j<n;j++){
                set.add(fruits[j]);
                if(set.size()>2){
                    break;
                }
                ma = Math.max(ma,j-i+1);
            }
        }
        return ma;
    }
}