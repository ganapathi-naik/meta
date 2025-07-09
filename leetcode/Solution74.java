class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int top = 0, bottom = rows - 1;
        while(top <= bottom) {
            int row = top + (bottom - top) / 2;
            if(matrix[row][cols - 1] < target) {
                top = row + 1;
            } else if(matrix[row][0] > target) {
                bottom = row - 1;
            } else {
                break;
            }
        }
        if(top > bottom) {
            return false;
        }
        int row = top + (bottom - top) / 2;
        int left = 0, right = cols - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target == matrix[row][mid]) {
                return true;
            } else if(matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

/**
✅ Time Complexity
There are two binary searches:
Binary search over rows to find the correct row:
Runs in O(log m) time, where m is the number of rows.
Binary search over columns within that row:
Runs in O(log n) time, where n is the number of columns.
Total Time Complexity:O(logm+logn)

✅ Space Complexity
The algorithm uses only a constant amount of extra space (no recursion, no extra data structures).
Total Space Complexity:O(1)

✅ Summary
Time: O(log m + log n)
Space: O(1)
 */
