class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String str = s + s;

        int alt1 = 0, alt2 = 0;
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < str.length(); i++) {

            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';

            if(str.charAt(i) != expected1) alt1++;
            if(str.charAt(i) != expected2) alt2++;

            if(i >= n) {
                char prev = str.charAt(i - n);

                char prevExp1 = ((i - n) % 2 == 0) ? '0' : '1';
                char prevExp2 = ((i - n) % 2 == 0) ? '1' : '0';

                if(prev != prevExp1) alt1--;
                if(prev != prevExp2) alt2--;
            }

            if(i >= n - 1) {
                res = Math.min(res, Math.min(alt1, alt2));
            }
        }

        return res;
    }
}