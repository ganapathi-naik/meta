class Solution33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // If we are left sorted array
            if (nums[mid] >= nums[left]) {
                if(target > nums[mid]) {
                    left = mid + 1;
                } else if (target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // If we are right sorted array
                if(target < nums[mid]) {
                    right = mid - 1;
                } else if (target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
