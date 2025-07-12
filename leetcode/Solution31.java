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

class Solution31 {
    public void prevPermutation(int[] nums) {
        // Find the rightmost peak: where nums[i-1] > nums[i]
        int peakIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                peakIndex = i;
            }
        }

        int swapIndex = peakIndex - 1;

        if (swapIndex >= 0) {
            for (int i = peakIndex + 1; i < nums.length; i++) {
                if (nums[i] < nums[swapIndex] && nums[i] >= nums[peakIndex]) {
                    peakIndex = i;
                }
            }

            // Swap nums[swapIndex] with nums[candidateIndex]
            int temp = nums[swapIndex];
            nums[swapIndex] = nums[peakIndex];
            nums[peakIndex] = temp;
        }

        // Reverse the suffix to get the largest arrangement (descending order)
        reverse(nums, swapIndex + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
    }
}
