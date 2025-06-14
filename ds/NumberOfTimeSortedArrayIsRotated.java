public class NumberOfTimeSortedArrayIsRotated {
    int findRotationCount(int arr) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while(left <= right) {
            if(nums[left] <= nums[right]) {
                return left + 1;
            }
            int mid = left + (right - left) / 2; // 0
            int prevIndex = (mid + n - 1) % n; // 0
            int nextIndex = (mid + 1) % n; // 1
            if(nums[mid] <= nums[prevIndex] && nums[mid] <= nums[nextIndex]) {
                return mid + 1;
            } else if(nums[mid] >= nums[left]) {
                left = mid + 1;
            } else if(nums[mid] <= nums[right]) {
                right = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
