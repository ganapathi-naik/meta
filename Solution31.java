class Solution31 {
    public void nextPermutation(int[] nums) {
        // Find the right most peak
        int peakIndex = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] < nums[i]) {
                peakIndex = i;
            }
        }
        // Find if there exist any number while falls between peak and number lesser than peak towards left of the peak
        int swapIndex = peakIndex - 1;
        if(swapIndex >= 0) {
            for(int i = peakIndex + 1; i < nums.length; i++) {
                if(nums[i] > nums[swapIndex] && nums[i] < nums[peakIndex]) {
                    peakIndex = i;
                }
            }
            int temp = nums[swapIndex];
            nums[swapIndex] = nums[peakIndex];
            nums[peakIndex] = temp;
        }
        // Sorting the element to right of the peak
        Arrays.sort(nums, swapIndex + 1, nums.length);
    }
}
