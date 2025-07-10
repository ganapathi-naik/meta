class Solution426 {
    TreeNode head;
    TreeNode prev;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) {
            return null;
        }
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        dfs(node.left);
        if(prev == null) {
            head = node;
        } else {
            node.left = prev;
            prev.right = node;
        }
        prev = node;
        dfs(node.right);
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
