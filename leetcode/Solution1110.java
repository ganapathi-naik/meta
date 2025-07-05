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
class Solution1110 {
    List<TreeNode> res;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for(int node : to_delete) {
            toDelete.add(node);
        }
        dfs(root, toDelete, true);
        return res;
    }

    private void dfs(TreeNode node, Set<Integer> toDelete, boolean isRoot) {
        if (node == null) {
            return;
        }

        if (toDelete.contains(node.val)) {
            dfs(node.left, toDelete, true);
            dfs(node.right, toDelete, true);
        } else {
            if (node.left != null) {
                if (toDelete.contains(node.left.val)) {
                    dfs(node.left, toDelete, true);
                    node.left = null;
                } else {
                    dfs(node.left, toDelete, false);
                }
            }

            if (node.right != null) {
                if (toDelete.contains(node.right.val)) {
                    dfs(node.right, toDelete, true);
                    node.right = null;
                } else {
                    dfs(node.right, toDelete, false);
                }
            }

            if (isRoot) {
                res.add(node);
            }
        }
    }
}
