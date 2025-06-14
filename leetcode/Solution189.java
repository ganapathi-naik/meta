class Solution189 {
    public void rotate(int[] nums, int k) { //right rotate
        int n = nums.length;
        k = k % n;
        if(k < 0) {
            k = k + n;
        }
        reverse(nums, 0, n - 1); //comes first in order
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void rotate(int[] nums, int k) { //left rotate
        int n = nums.length;
        k = k % n;
        if(k < 0) {
            k = k + n;
        }
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1); // comes last inorder
    }

    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
