import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                set.add(grid[i][j]); // size 0 rhombus

                for(int k = 1; i + 2*k < m && j-k >= 0 && j+k < n; k++){

                    int sum = 0;

                    int r = i;
                    int c = j;

                    // top → left
                    for(int t = 0; t < k; t++){
                        sum += grid[r+t][c-t];
                    }

                    // left → bottom
                    for(int t = 0; t < k; t++){
                        sum += grid[r+k+t][c-k+t];
                    }

                    // bottom → right
                    for(int t = 0; t < k; t++){
                        sum += grid[r+2*k-t][c+t];
                    }

                    // right → top
                    for(int t = 0; t < k; t++){
                        sum += grid[r+k-t][c+k-t];
                    }

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] res = new int[size];

        int idx = 0;
        for(int val : set){
            res[idx++] = val;
            if(idx == size) break;
        }

        return res;
    }
}