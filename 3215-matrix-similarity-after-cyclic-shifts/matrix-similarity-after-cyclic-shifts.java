class Solution {
public boolean areSimilar(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        int shift = k % cols;
        if (shift == 0) {
            return true;
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int sourceCol;
                if ((r & 1) == 0) {
                    // Even row: left shift by 'shift'.
                    sourceCol = (c + shift) % cols;
                } else {
                    // Odd row: right shift by 'shift'.
                    sourceCol = (c - shift + cols) % cols;
                }
                if (mat[r][c] != mat[r][sourceCol]) {
                    return false;
                }
            }
        }
        return true;
    }
}