class Solution1060 {
    public int missingElement(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - arr[0] - mid < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // k - (arr[right] - 1 - right) + arr[right] => k + right + 1 => k + left (i.e. right + 1 = left)
        return arr[0] + k + right;
    }
}
