class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        for (int i = 0; i < n; i++) {
            if (lcp[i].length != n) {
                return "";
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = lcp[i][j];
                if (v < 0 || v > n) {
                    return "";
                }
            }
        }

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] > 0) {
                    uf.union(i, j);
                }
            }
        }

        int[] minIndex = new int[n];
        Arrays.fill(minIndex, n);
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            if (i < minIndex[root]) {
                minIndex[root] = i;
            }
        }

        int[] orderToRoot = new int[n];
        int groups = 0;
        for (int idx = 0; idx < n; idx++) {
            for (int root = 0; root < n; root++) {
                if (minIndex[root] == idx) {
                    orderToRoot[groups++] = root;
                }
            }
        }

        if (groups > 26) {
            return "";
        }

        char[] word = new char[n];
        for (int rank = 0; rank < groups; rank++) {
            int root = orderToRoot[rank];
            char ch = (char) ('a' + rank);
            for (int i = 0; i < n; i++) {
                if (uf.find(i) == root) {
                    word[i] = ch;
                }
            }
        }

        int[][] built = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] == word[j]) {
                    built[i][j] = built[i + 1][j + 1] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (built[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return new String(word);
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra == rb) {
                return;
            }

            if (rank[ra] < rank[rb]) {
                parent[ra] = rb;
            } else if (rank[ra] > rank[rb]) {
                parent[rb] = ra;
            } else {
                parent[rb] = ra;
                rank[ra]++;
            }
        }
    }
}