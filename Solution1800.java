class Solution1800 {
    public int maxAscendingSum(int[] nums) {
        int index = 1;
        int maxSum = nums[0], sum = nums[0];
        while(index < nums.length) {
            if(nums[index - 1] < nums[index]) {
                sum += nums[index];
                maxSum = Math.max(sum, maxSum);
            } else {
                sum = nums[index];
            }
            index++;
        }
        return maxSum;
    }
}
