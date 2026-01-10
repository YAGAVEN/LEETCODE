class Solution {
    public int findComplement(int num) {
        char[] bin = Integer.toBinaryString(num).toCharArray();
        StringBuilder sb = new StringBuilder();
        for( char i : bin){
            sb.append((i=='0')?'1':'0');
        }
        int n = Integer.parseInt((sb.toString()),2);
         return n;
    }
}