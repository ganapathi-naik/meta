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


class Solution53 {
    public int maxSubArray(int[] nums) {
        int maxEndingHere = 0;
        int maxSoFar = nums[0];
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}


class Solution53 {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
