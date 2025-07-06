class Solution1094 {
    public boolean carPooling(int[][] trips, int maxCapacity) {
        if(trips == null || trips.length == 0) {
            return false;
        }
        Arrays.sort(trips, (t1, t2) -> t1[1] - t2[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((t1, t2) -> t1[1] - t2[1]); //{capacity, end}
        int currCapacity = 0;
        for(int i = 0; i < trips.length; i++) {
            int capacity = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];

            while(!pq.isEmpty() && pq.peek()[1] <= start) {
                currCapacity -= pq.peek()[0];
                pq.poll();
            }
            currCapacity += capacity;
            if(currCapacity > maxCapacity) {
                return false;
            }
            pq.offer(new int[]{capacity, end});
        }
        return true;
    }
}
