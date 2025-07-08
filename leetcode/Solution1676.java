import java.util.*;
class Solution1676 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> set = new HashSet<>();
         for (TreeNode node : nodes) {
            set.add(node.val);
        }
        return lca(root, set);
    }
    private TreeNode lca(TreeNode root, Set<Integer> set) {
        if(root == null) {
            return null;
        }
        if(set.contains(root.val)) {
            return root;
        }
        TreeNode leftLca = lca(root.left, set);
        TreeNode rightLca = lca(root.right, set);
        if(leftLca == null) {
            return rightLca;
        }

        if(rightLca == null) {
            return leftLca;
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
