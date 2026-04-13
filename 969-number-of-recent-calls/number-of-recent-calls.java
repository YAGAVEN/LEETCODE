class RecentCounter {
    private final Queue<Integer> requests;
    public RecentCounter() {
        this.requests = new ArrayDeque<>();
    }
    public int ping(int t) {
        requests.offer(t);
        int minAllowed = t - 3000;
        while (!requests.isEmpty() && requests.peek() < minAllowed) {
            requests.poll();
        }
        return requests.size();
    }
}
