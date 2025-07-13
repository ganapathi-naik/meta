class Solution53 {
    public int maxSubArray(int[] nums) {
        int maxSubArray = nums[0];
        int currSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(currSum < 0) {
                currSum = 0;
            }
            currSum += nums[i];
            maxSubArray = Math.max(maxSubArray, currSum);
        }
        return maxSubArray;
    }
}
