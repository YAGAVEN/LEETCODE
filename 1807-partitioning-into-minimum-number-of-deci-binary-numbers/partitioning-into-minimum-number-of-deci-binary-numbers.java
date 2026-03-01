class Solution {
    public int minPartitions(String n) {
        int mx = 0;
        for(char ch : n.toCharArray()){
            if(ch>mx){
                mx=ch;
            }
            
        }
        return mx-'0';
    }
}