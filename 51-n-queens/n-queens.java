class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board) Arrays.fill(row, '.');

        int leftRow[] = new int[n];
        int lowerDiagonal[] = new int[2 * n - 1];
        int upperDiagonal[] = new int[2 * n - 1];

        solve(0, board, n, leftRow, lowerDiagonal, upperDiagonal, res);
        return res;
    }

    public void solve(int col, char[][] board, int n,
                      int[] leftRow, int[] lowerDiagonal,
                      int[] upperDiagonal, List<List<String>> res) {

        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }

        for (int r = 0; r < n; r++) {

            if (leftRow[r] == 0 &&
                lowerDiagonal[r + col] == 0 &&
                upperDiagonal[n - 1 + col - r] == 0) {

                board[r][col] = 'Q';
                leftRow[r] = 1;
                lowerDiagonal[r + col] = 1;
                upperDiagonal[n - 1 + col - r] = 1;

                solve(col + 1, board, n, leftRow, lowerDiagonal, upperDiagonal, res);

                board[r][col] = '.';
                leftRow[r] = 0;
                lowerDiagonal[r + col] = 0;
                upperDiagonal[n - 1 + col - r] = 0;
            }
        }
    }
}