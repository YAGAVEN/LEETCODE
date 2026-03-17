class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = getMax(piles);

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (canFinish(piles, h, mid)) {
                r = mid;        
            } else {
                l = mid + 1;    
            }
        }

        return l;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        int hours = 0;

        for (int pile : piles) {
            hours += (pile + k - 1) / k; 

            if (hours > h) return false; 
        }

        return hours <= h;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}