class Solution398 {
    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int count = 0, pickIndex = -1;
        Random r = new Random();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                count++;
                if(r.nextInt(1, count + 1) == count) {
                    pickIndex = i;
                }
            }
        }
        return pickIndex;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

/**
398. Random Pick Index - Variant asked in Facebook interviews
Given an integer array nums of possible duplicates, randomly output k numbers and return them as an integer array. You cannot pick a number twice or replace an existing picked number with an already picked number in the resulting integer array.
Note that you must do this without using extra space complexity.
Furthermore, you must write an algorithm with 0(n) runtime complexity.

Example 1:
Input: [6,8,2,1,3,10,41, k = 3
Output: [6,3,4]
Explanation: Any other combination of 3 integers is also valid such as [8,2,10] or [1,10,4]

Example 2:
Input: [1,2], k = 2
Output: [1,2]
K=3
nums = [ 6, 8, 2, 1, 3,10, 4]
result: [1, 2]

Constraints:
• 1 <= k <= nums. length <= 2 * 104
• -100 <= nums [i] <= 100
*/
class Solution398 {
    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int[] nums, int k) {
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = nums[i];
        }

        for(int i = k; i < nums.length; i++) {
            int numberOfElements = i + 1;
            int r = random.nextInt(0, n);
            if(n < k) {
                result[r] = nums[i];
            }
        }
        return result;
    }
}
