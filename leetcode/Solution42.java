class Solution42 {
    public int trap(int[] height) {
        int maxLeft = height[0], maxRight = height[height.length - 1];
        int left = 0, right = height.length - 1;
        int res = 0;
        while(left <= right) {
            if(maxLeft <= maxRight) {
                res += height[left] < maxLeft ? maxLeft - height[left] : 0;
                maxLeft = Math.max(maxLeft, height[left]);
                left++;
            } else {
                res += height[right] < maxRight ? maxRight - height[right] : 0;
                maxRight = Math.max(maxRight, height[right]);
                right--;
            }
        }
        return res;
    }
}
