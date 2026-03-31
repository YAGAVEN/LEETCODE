class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;

        // Forced characters coming from all 'T' windows.
        char[] forced = new char[len];
        Arrays.fill(forced, '?');

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    char need = str2.charAt(j);
                    if (forced[pos] != '?' && forced[pos] != need) {
                        return "";
                    }
                    forced[pos] = need;
                }
            }
        }

        int[] pi = buildPrefixFunction(str2);
        int[][] go = buildKmpTransitions(str2, pi);

        // can[pos * m + state] => suffix from pos is feasible if current KMP state is
        // 'state'.
        byte[] can = new byte[(len + 1) * m];
        int base = len * m;
        for (int state = 0; state < m; state++) {
            can[base + state] = 1;
        }

        for (int pos = len - 1; pos >= 0; pos--) {
            char fixed = forced[pos];
            int stateBase = pos * m;
            int nextBase = (pos + 1) * m;

            for (int state = 0; state < m; state++) {
                int from = (fixed == '?') ? 0 : (fixed - 'a');
                int to = (fixed == '?') ? 25 : (fixed - 'a');

                for (int code = from; code <= to; code++) {
                    int k = go[state][code];
                    boolean match = (k == m);
                    int nextState = match ? pi[m - 1] : k;

                    int start = pos - m + 1;
                    if (start >= 0) {
                        boolean mustMatch = str1.charAt(start) == 'T';
                        if (mustMatch != match) {
                            continue;
                        }
                    }

                    if (can[nextBase + nextState] == 1) {
                        can[stateBase + state] = 1;
                        break;
                    }
                }
            }
        }

        if (can[0] == 0) {
            return "";
        }

        char[] answer = new char[len];
        int state = 0;

        for (int pos = 0; pos < len; pos++) {
            char fixed = forced[pos];
            int from = (fixed == '?') ? 0 : (fixed - 'a');
            int to = (fixed == '?') ? 25 : (fixed - 'a');
            int nextBase = (pos + 1) * m;

            for (int code = from; code <= to; code++) {
                int k = go[state][code];
                boolean match = (k == m);
                int nextState = match ? pi[m - 1] : k;

                int start = pos - m + 1;
                if (start >= 0) {
                    boolean mustMatch = str1.charAt(start) == 'T';
                    if (mustMatch != match) {
                        continue;
                    }
                }

                if (can[nextBase + nextState] == 1) {
                    answer[pos] = (char) ('a' + code);
                    state = nextState;
                    break;
                }
            }
        }

        return new String(answer);
    }

    private int[] buildPrefixFunction(String pattern) {
        int m = pattern.length();
        int[] pi = new int[m];
        for (int i = 1; i < m; i++) {
            int j = pi[i - 1];
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        return pi;
    }

    private int[][] buildKmpTransitions(String pattern, int[] pi) {
        int m = pattern.length();
        int[][] go = new int[m][26];

        for (int state = 0; state < m; state++) {
            for (int code = 0; code < 26; code++) {
                int j = state;
                char ch = (char) ('a' + code);

                while (j > 0 && pattern.charAt(j) != ch) {
                    j = pi[j - 1];
                }
                if (pattern.charAt(j) == ch) {
                    j++;
                }
                go[state][code] = j;
            }
        }

        return go;
    }

}