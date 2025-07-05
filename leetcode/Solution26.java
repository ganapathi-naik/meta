class Solution26 {
    public int removeDuplicates(int[] nums) {
        int left = 1;
        for(int right = 1; right < nums.length; right++) {
            if(nums[right - 1] == nums[right]) {
                continue;
            }
            nums[left++] = nums[right];
        }
        return left;
    }
}
