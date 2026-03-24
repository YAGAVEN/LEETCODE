class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] arr = new int[s.length()];

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                arr[i] = 0;
            } else {
                int l = i, r = i;

                while (l >= 0 && s.charAt(l) != c) l--;
                while (r < s.length() && s.charAt(r) != c) r++;

                int leftDist = (l >= 0) ? i - l : Integer.MAX_VALUE;
                int rightDist = (r < s.length()) ? r - i : Integer.MAX_VALUE;

                arr[i] = Math.min(leftDist, rightDist);
            }
        }

        return arr;
    }
}