class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        long totalSum = 0L;
        Map<Integer, Integer> allFreq = new HashMap<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int value = grid[r][c];
                totalSum += value;
                allFreq.put(value, allFreq.getOrDefault(value, 0) + 1);
            }
        }

        if (checkHorizontalCuts(grid, totalSum, allFreq)) {
            return true;
        }
        return checkVerticalCuts(grid, totalSum, allFreq);
    }

    private boolean checkHorizontalCuts(int[][] grid, long totalSum, Map<Integer, Integer> allFreq) {
        int rows = grid.length;
        int cols = grid[0].length;

        Map<Integer, Integer> topFreq = new HashMap<>();
        Map<Integer, Integer> bottomFreq = new HashMap<>(allFreq);
        long topSum = 0L;

        for (int cutRow = 0; cutRow < rows - 1; cutRow++) {
            for (int c = 0; c < cols; c++) {
                int value = grid[cutRow][c];
                topSum += value;
                topFreq.put(value, topFreq.getOrDefault(value, 0) + 1);
                decrement(bottomFreq, value);
            }

            long bottomSum = totalSum - topSum;
            if (topSum == bottomSum) {
                return true;
            }

            if (topSum > bottomSum) {
                long diff = topSum - bottomSum;
                if (canDiscountFromHorizontalTop(grid, cutRow, diff, topFreq)) {
                    return true;
                }
            } else {
                long diff = bottomSum - topSum;
                if (canDiscountFromHorizontalBottom(grid, cutRow, diff, bottomFreq)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkVerticalCuts(int[][] grid, long totalSum, Map<Integer, Integer> allFreq) {
        int rows = grid.length;
        int cols = grid[0].length;

        Map<Integer, Integer> leftFreq = new HashMap<>();
        Map<Integer, Integer> rightFreq = new HashMap<>(allFreq);
        long leftSum = 0L;

        for (int cutCol = 0; cutCol < cols - 1; cutCol++) {
            for (int r = 0; r < rows; r++) {
                int value = grid[r][cutCol];
                leftSum += value;
                leftFreq.put(value, leftFreq.getOrDefault(value, 0) + 1);
                decrement(rightFreq, value);
            }

            long rightSum = totalSum - leftSum;
            if (leftSum == rightSum) {
                return true;
            }

            if (leftSum > rightSum) {
                long diff = leftSum - rightSum;
                if (canDiscountFromVerticalLeft(grid, cutCol, diff, leftFreq)) {
                    return true;
                }
            } else {
                long diff = rightSum - leftSum;
                if (canDiscountFromVerticalRight(grid, cutCol, diff, rightFreq)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean canDiscountFromHorizontalTop(int[][] grid, int cutRow, long diff, Map<Integer, Integer> topFreq) {
        int rowsInSection = cutRow + 1;
        int cols = grid[0].length;
        return canDiscountRectangle(grid, 0, cutRow, 0, cols - 1, rowsInSection, cols, diff, topFreq);
    }

    private boolean canDiscountFromHorizontalBottom(int[][] grid, int cutRow, long diff,
            Map<Integer, Integer> bottomFreq) {
        int startRow = cutRow + 1;
        int rowsInSection = grid.length - startRow;
        int cols = grid[0].length;
        return canDiscountRectangle(grid, startRow, grid.length - 1, 0, cols - 1, rowsInSection, cols, diff,
                bottomFreq);
    }

    private boolean canDiscountFromVerticalLeft(int[][] grid, int cutCol, long diff, Map<Integer, Integer> leftFreq) {
        int colsInSection = cutCol + 1;
        int rows = grid.length;
        return canDiscountRectangle(grid, 0, rows - 1, 0, cutCol, rows, colsInSection, diff, leftFreq);
    }

    private boolean canDiscountFromVerticalRight(int[][] grid, int cutCol, long diff, Map<Integer, Integer> rightFreq) {
        int startCol = cutCol + 1;
        int colsInSection = grid[0].length - startCol;
        int rows = grid.length;
        return canDiscountRectangle(grid, 0, rows - 1, startCol, grid[0].length - 1, rows, colsInSection, diff,
                rightFreq);
    }

    private boolean canDiscountRectangle(
            int[][] grid,
            int r1,
            int r2,
            int c1,
            int c2,
            int height,
            int width,
            long diff,
            Map<Integer, Integer> freq) {
        if (diff > 100000L) {
            return false;
        }

        int target = (int) diff;
        if (!freq.containsKey(target)) {
            return false;
        }

        if (height > 1 && width > 1) {
            return true;
        }

        if (height == 1 && width == 1) {
            return grid[r1][c1] == target;
        }

        if (height == 1) {
            return grid[r1][c1] == target || grid[r1][c2] == target;
        }

        return grid[r1][c1] == target || grid[r2][c1] == target;
    }

    private void decrement(Map<Integer, Integer> freq, int value) {
        int next = freq.get(value) - 1;
        if (next == 0) {
            freq.remove(value);
        } else {
            freq.put(value, next);
        }
    }
}