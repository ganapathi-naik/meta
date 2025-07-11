class Solution298 {
    int longestConsecutive = 1;
    public int longestConsecutive(TreeNode root) {
        if(root == null) {
            return 0;
        }
        dfs(root, root.val - 1, 0);
        return longestConsecutive;
    }

    private void dfs(TreeNode node, int parent, int res) {
        if(root == null) {
            return;
        }
        if(parent + 1 == root.val) {
            res++;
            longestConsecutive = Math.max(longestConsecutive, res);
            dfs(node.left, node.val, res);
            dfs(node.right, node.val, res);
        } else {
            dfs(node.left, node.val, 1);
            dfs(node.right, node.val, 1);
        }
    }
}
