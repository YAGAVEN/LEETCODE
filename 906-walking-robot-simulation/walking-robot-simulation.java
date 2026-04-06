class Solution {
    public static int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> blocked = new HashSet<>();
        for (int[] obstacle : obstacles) {
            blocked.add(encode(obstacle[0], obstacle[1]));
        }

        // 0 = north, 1 = east, 2 = south, 3 = west
        int direction = 0;
        int x = 0;
        int y = 0;
        int maxDistanceSquared = 0;

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };

        for (int command : commands) {
            if (command == -2) {
                direction = (direction + 3) % 4;
            } else if (command == -1) {
                direction = (direction + 1) % 4;
            } else {
                for (int step = 0; step < command; step++) {
                    int nextX = x + dx[direction];
                    int nextY = y + dy[direction];

                    if (blocked.contains(encode(nextX, nextY))) {
                        break;
                    }

                    x = nextX;
                    y = nextY;
                    int currentDistanceSquared = x * x + y * y;
                    maxDistanceSquared = Math.max(maxDistanceSquared, currentDistanceSquared);
                }
            }
        }

        return maxDistanceSquared;
    }

    private static long encode(int x, int y) {
        return (((long) x) << 32) ^ (y & 0xffffffffL);
    }
}