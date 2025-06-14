class Solution1752 {
    public boolean check(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return true;
        }
        int len = 1;
        for(int i = 1; i < 2 * n; i++) {
            if(nums[(i - 1) % n] <= nums[i % n]) {
                len++;
            } else {
                len = 1;
            }
            if(len == n) {
                return true;
            }
        }
        return false;
    }

    public boolean check(int[] nums) {
        int inversionCount = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] > nums[i]) { // 0,1  1,2  2,3  3,4  4,0
                inversionCount++;
                if(inversionCount > 1) {
                    return false;
                }
            }
        }
        if(nums[nums.length - 1] > nums[0]) {
            inversionCount++;
        }
        return inversionCount <= 1;
    }
}
