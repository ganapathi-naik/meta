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


class Solution162 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long toLeft = (mid - 1) < 0 ? Long.MIN_VALUE : nums[mid-1];
            long toRight = (mid + 1) >= nums.length ? Long.MIN_VALUE : nums[mid + 1];
            if(nums[mid] > toLeft && nums[mid] > toRight) {
                return mid;
            } else if(toLeft < nums[mid] && nums[mid] < toRight) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
