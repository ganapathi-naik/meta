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
class Solution2265 {
    int res;

    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode node) {
        int totalNodes = 1;
        int totalSum = node.val;
        if (node.left != null) {
            int[] left = dfs(node.left);
            totalSum += left[0];
            totalNodes += left[1];
        }

        if (node.right != null) {
            int[] right = dfs(node.right);
            totalSum += right[0];
            totalNodes += right[1];
        }

        if (node.val == (int) (totalSum / totalNodes)) {
            res += 1;
        }

        return new int[] { totalSum, totalNodes };
    }
}
