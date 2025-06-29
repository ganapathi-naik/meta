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
class Solution129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int val) {
        if (node.left == null && node.right == null) {
            return val * 10 + node.val;
        }

        int sum = 0;
        if (node.left != null) {
            sum += dfs(node.left, val * 10 + node.val);
        }
        if (node.right != null) {
            sum += dfs(node.right, val * 10 + node.val);
        }
        return sum;
    }
}
