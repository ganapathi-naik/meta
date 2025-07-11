class Solution333 {
    int largestBSTSubtree = 0;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) {
            return largestBSTSubtree;
        }
        largestBSTSubtree = 1;
        dfs(root);
        return largestBSTSubtree;
    }

    public int[] dfs(TreeNode node) {
        if(node == null) {
            return new int[]{0, -10001, 10001, 0};
        }

        if(node.left == null && node.right == null) {
            return new int[]{1, node.val, node.val, 1};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        boolean leftIsBst = left[0] == 1 ? true : false;
        int leftMin = left[1];
        int leftMax = left[2];
        int leftTreeSize = left[3];

        boolean rightIsBst = right[0] == 1 ? true : false;
        int rightMin = right[1];
        int rightMax = right[2];
        int rightTreeSize = right[3];

        if(leftIsBst && rightIsBst && node.val > leftMax && node.val < rightMin) {
            int currSize = leftTreeSize + rightTreeSize + 1;
            largestBSTSubtree = Math.max(largestBSTSubtree, currSize);
            return new int[]{1, leftMin, rightMax, currSize};
        } else if(leftIsBst && node.val > leftMax) {
            int currSize = leftTreeSize;
            largestBSTSubtree = Math.max(largestBSTSubtree, currSize);
            return new int[]{1, leftMin, node.val, currSize};
        } else if(rightIsBst && node.val < rightMin) {
            int currSize = rightTreeSize + 1;
            largestBSTSubtree = Math.max(largestBSTSubtree, currSize);
            return new int[]{1, node.val, rightMax, currSize};
        } else {
            return new int[]{0, -10001, 10001, 0};
        }
    }
}
