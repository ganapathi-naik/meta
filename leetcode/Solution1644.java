/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution1644 {
    boolean isPPresent = false, isQPresent = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = postOrderTraversal(root, p, q);
        if(isPPresent && isQPresent) {
            return lca;
        }
        return null;
    }

    public TreeNode postOrderTraversal(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) {
            return node;
        }
        TreeNode left = postOrderTraversal(node.left, p, q);
        TreeNode right = postOrderTraversal(node.right, p, q);
        if(node == p) {
            isPPresent = true;
            return p;
        }
        if(node == q) {
            isQPresent = true;
            return q;
        }
        if(left != null && right != null) {
            return node;
        } else if(left == null) {
            return right;
        } else {
            return left;
        }
    }
}
