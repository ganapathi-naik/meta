import java.util.*;
class Solution163 {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> missingRanges = new ArrayList<>();
        int n = nums.length;
        if(n == 0) {
            missingRanges.add(Arrays.asList(lower, upper));
            return missingRanges;
        }

        if(nums[0] > lower) {
            missingRanges.add(Arrays.asList(lower, nums[0] - 1));
        }

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] - nums[i] <= 1) {
                continue;
            }
            missingRanges.add(Arrays.asList(nums[i] + 1, nums[i + 1] - 1));
        }

        if(nums[n - 1] < upper) {
            missingRanges.add(Arrays.asList(nums[n - 1] + 1, upper));
        }

        return missingRanges;
    }
}

//Custom formatting
/**
You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are within the inclusive range.
A number x is considered missing if x is in the range [lower, upper] and x is not in nums. Additionally, there are formatting rules:
• If there are more than two consecutive missing numbers, then use a between the missing lower- and upper numbers.
• If there is one missing number, push it as an individual string.
• If there are exactly two consecutive missing numbers, push them individually.
Return the shortest sorted list of ranges that exactly covers all the missing numbers as a list of strings.
Example 1:
Input: nums = [5,8,9,15,16,18,20], lower = 2, upper = 87
Output： ["2-4"，"6", "7", "10-14, "17", "19", "21-87"]
Constraints:
• 0 < lower <= upper <= 109
• 0 <= nums.length <= 100
• lower <= nums [i] < upper
• All the values of nums are unique.
 */
class Solution163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> missingRanges = new ArrayList<>();
        int n = nums.length;
        if(n == 0) {
            if(lower == upper) {
                missingRanges.add("" + lower);
            } else {
                missingRanges.add("" + lower + "-" + upper);
            }
            return missingRanges;
        }

        if(nums[0] > lower) {
            if(lower + 1 == nums[0]) {
                missingRanges.add("" + lower);
            } else {
                missingRanges.add("" + lower + "-" + (nums[0] - 1));
            }
        }

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] - nums[i] <= 1) {
                continue;
            }
            if(nums[i] + 2 == nums[i + 1]) {
                missingRanges.add("" + (nums[i] + 1));
            } else {
                missingRanges.add("" + (nums[i] + 1) + "-" + (nums[i + 1] - 1));
            }
        }

        if(nums[n - 1] < upper) {
            if(nums[n - 1] + 1 == upper) {
                missingRanges.add("" + (upper));
            } else {
                missingRanges.add("" + (nums[n - 1] + 1) + "-" + upper);
            }
        }

        return missingRanges;
    }

    public static void main(String[] args) {
        System.out.println(new Solution163().findMissingRanges(new int[] {1, 12, 15, 16, 52, 89}, 0, 200));
    }
}
