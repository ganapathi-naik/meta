class Solution56 {
    public int[][] merge(int[][] intervals) {
        //sort the intervals by start_time
        Arrays.sort(intervals, (i1, i2) -> {
            if(i1[0] != i2[0]) {
                return i1[0] - i2[0];
            }
            return i1[1] - i2[1];
        });
        // Take prev_interval, curr_interval and merge the intervals
        int[] prevInterval = intervals[0];
        List<int[]> res = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if(currInterval[0] > prevInterval[1]) {
                res.add(prevInterval);
                prevInterval = currInterval;
            }
            prevInterval[1] = Math.max(prevInterval[1], currInterval[1]);
        }
        res.add(prevInterval);
        return res.toArray(new int[0][]);
    }
}
