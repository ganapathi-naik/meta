/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution124 {
    int maxPathSum = -1001;

    public int maxPathSum(TreeNode root) {
        postorder(root);
        return maxPathSum;
    }

    private int postorder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = postorder(node.left);
        int right = postorder(node.right);

        int leftMax = Math.max(0, left);
        int rightMax = Math.max(0, right);

        int sum = node.val + leftMax + rightMax;
        maxPathSum = Math.max(maxPathSum, sum);

        return node.val + Math.max(leftMax, rightMax);
    }
}
