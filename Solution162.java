class Solution162 {
    public int findPeakElement(int[] nums) {
        int peakIndex = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] < nums[i]) {
                peakIndex = i;
            }
        }
        return peakIndex;
    }
}
