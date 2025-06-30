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
