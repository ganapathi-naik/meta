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
class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        if(root != null) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()) {
                int size = q.size();
                boolean gotFirstElement = false;
                while(size > 0) {
                    TreeNode node = q.poll();
                    if(!gotFirstElement) {
                        rs.add(node.val);
                        gotFirstElement = true;
                    }
                    if(node.right != null) {
                        q.offer(node.right);
                    }
                    if(node.left != null) {
                        q.offer(node.left);
                    }
                    size--;
                }
            }
        }
        return rs;
    }
}
