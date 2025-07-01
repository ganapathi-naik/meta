class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length < 1) {
            return new int[]{-1, -1};
        }
        int firstOccurrence = firstOccurrence(nums, target);
        int lastOccurrence = lastOccurrence(nums, target);
        return new int[] {firstOccurrence, lastOccurrence};
    }

    private int firstOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int res = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                res = mid;
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private int lastOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int res = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                res = mid;
                left = mid + 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
/**
34. Find Unique Count of Elements in Sorted Array
Given an array of integers nums sorted in non-decreasing order, find the count of unique elements.
You must write an algorithm with 0(k log n) runtime complexity where k is the number of unique elements.
Example 1:
Input: nums = [5,7,7,8,8,10]
Output: 4
Example 2:
Input: nums = [1,2,3,4,5,6,7,8,9,10]
Output: 10
Example 3:
Input: nums = []
Output: 0
Constraints:
    • 0 <= nums. length <= 105
    •-109 <= nums ［i］ <= 109
    • nums is a non-decreasing array.
 */

class Solution34 {
    public int countUniqueElements(int[] nums) {
        if(nums == null) {
            return 0;
        }
        if(nums.length < 2) {
            return nums.length;
        }
        int index = 0, count = 0;
        while(index < nums.length) {
            int left = 0, right = nums.length - 1;
            int res = -1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == nums[index]) {
                    res = mid;
                    left = mid + 1;
                } else if(nums[mid] < nums[index]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            index = res + 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution34().countUniqueElements(new int[] {1,2,3,4,5,6,7,8,9,10}));
    }
}
