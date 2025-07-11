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
class Solution98 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long leftBoundary, long rightBoundary) {
        if(node == null) {
            return true;
        }
        if(node.val > leftBoundary && node.val < rightBoundary) {
            return isValidBST(node.left, leftBoundary, node.val) && isValidBST(node.right, node.val, rightBoundary);
        }
        return false;
    }
}
