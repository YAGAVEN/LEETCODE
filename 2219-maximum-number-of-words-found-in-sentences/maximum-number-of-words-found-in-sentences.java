class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        int len = 0;
        for(String str : sentences){
            len = stringLength(str);
            if(len > max){
                max = len;
            }
        }
        return max;
    }
    private static int stringLength(String s ){
        String[] str = s.split(" ");
        return str.length;
    }
}