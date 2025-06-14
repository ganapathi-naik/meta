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
class Solution543 {
    int maxDiameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return maxDiameter;
    }

    private int diameter(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftDiameter = diameter(node.left);
        int rightDiameter = diameter(node.right);
        maxDiameter = Math.max(leftDiameter + rightDiameter, maxDiameter);
        return Math.max(leftDiameter, rightDiameter) + 1;
    }
}
