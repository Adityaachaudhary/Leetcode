class Solution {
    public int maxEvents(int[][] events) {
        // Sort events by their start day
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        
        // Min‑heap to keep track of event end days
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int i = 0, n = events.length, attended = 0;
        // Find the last day we need to consider
        int lastDay = 0;
        for (int[] e : events) lastDay = Math.max(lastDay, e[1]);
        
        // Sweep through each day
        for (int day = 1; day <= lastDay; day++) {
            // Add all events that start today to the heap
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }
            // Remove any events that already ended before today
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
            // Attend the event that ends the soonest (if any)
            if (!pq.isEmpty()) {
                pq.poll();
                attended++;
            }
            // Early exit: if no more upcoming events and heap empty
            if (i == n && pq.isEmpty()) break;
        }
        
        return attended;
    }
}
