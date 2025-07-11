/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode parent;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution1650 {
    public TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
        Set<TreeNode> lcaNodes = new HashSet<>();
        while(p != null) {
            lcaNodes.add(p);
            p = p.parent;
        }

        while(q != null) {
            if(lcaNodes.conatins(q)) {
                return q;
            }
            q = q.parent;
        }
        return null;
    }

    //Optimised solution with constant memory
    public TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
        TreeNode cp = p, cq = q;
        while(cp != cq) {
            cp = cp.parent == null ? q : cp.parent;
            cq = cq.parent == null ? p : cq.parent;
        }
        return cp;
    }
}
