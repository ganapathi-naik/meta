class Solution153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left <= right) {
            if(nums[left] <= nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2; // 0
            int prevIndex = (mid + n - 1) % n; // 0
            int nextIndex = (mid + 1) % n; // 1
            if(nums[mid] <= nums[prevIndex] && nums[mid] <= nums[nextIndex]) {
                return nums[mid];
            } else if(nums[mid] >= nums[left]) {
                left = mid + 1;
            } else if(nums[mid] <= nums[right]) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
