class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> Integer.compare(positions[a], positions[b]));

        int[] currentHealth = Arrays.copyOf(healths, n);
        boolean[] removed = new boolean[n];

        int[] stack = new int[n];
        int top = -1;

        for (int idx : order) {
            char dir = directions.charAt(idx);

            if (dir == 'R') {
                stack[++top] = idx;
                continue;
            }

            while (top >= 0 && !removed[idx]) {
                int rightIdx = stack[top];

                if (currentHealth[rightIdx] < currentHealth[idx]) {
                    removed[rightIdx] = true;
                    top--;
                    currentHealth[idx]--;
                } else if (currentHealth[rightIdx] == currentHealth[idx]) {
                    removed[rightIdx] = true;
                    removed[idx] = true;
                    top--;
                } else {
                    currentHealth[rightIdx]--;
                    removed[idx] = true;
                }
            }
        }

        List<Integer> survivors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                survivors.add(currentHealth[i]);
            }
        }
        return survivors;
    }
}