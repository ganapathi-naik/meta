class Solution1344 {
    public double angleClock(int hour, int minutes) {
        // 6°/min = minute hand => 30°/hour
        // 0.5°/min = hour hand => 6°/min

        double diff = Math.abs(hour * 30 - minutes * 5.5);
        return Math.min(diff, 360 - diff);
    }
}

/**
Time complexity: O(1)
Space complexity: O(1)
 */
