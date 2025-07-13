class Solution918 {

    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0];
        int globalMin = nums[0];

        int currMax = 0;
        int currMin = 0;
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            if(currMax < 0) {
                currMax = 0;
            }
            currMax += nums[i];
            globalMax = Math.max(globalMax, currMax);

            if(currMin > 0) {
                currMin = 0;
            }
            currMin += nums[i];
            globalMin = Math.min(globalMin, currMin);
        }
        if(globalMax < 0) {
            return globalMax;
        }
        return Math.max(totalSum - globalMin, globalMax);
    }
}
