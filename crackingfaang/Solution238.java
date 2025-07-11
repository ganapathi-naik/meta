class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] rightSideProduct = new int[nums.length];
        int product = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            rightSideProduct[i] = product;
            product = product * nums[i];
        }
        product = 1;
        for(int i = 0; i < nums.length; i++) {
            rightSideProduct[i] = product * rightSideProduct[i];
            product = product * nums[i];
        }
        return rightSideProduct;
    }
}
/**
[24,12,4,1]
product = 1
 */
