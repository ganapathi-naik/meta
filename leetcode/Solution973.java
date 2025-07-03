class Solution973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> (p2[0]*p2[0] + p2[1]*p2[1]) - (p1[0]*p1[0] + p1[1]*p1[1]));
        for(int i = 0; i < k; i++) {
            pq.offer(points[i]);
        }

        for(int i = k; i < points.length; i++) {
            int[] farthestPoint = pq.peek();
            int[] p = points[i];

            if((p[0]*p[0] + p[1]*p[1]) < (farthestPoint[0]*farthestPoint[0] + farthestPoint[1]*farthestPoint[1])) {
                pq.poll();
                pq.offer(p);
            }
        }
        int[][] res = new int[k][2];
        int index = 0;
        while(!pq.isEmpty()) {
            res[index++] = pq.poll();
        }
        return res;
    }
}
