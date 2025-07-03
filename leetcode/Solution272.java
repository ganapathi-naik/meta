class Solution272 {
    int[] closestKValues(TreeNode root, double target, int k) {
        Queue<TreeNode> q = new LinkedList<>();

        dfs(root, q, target, k);

        //Forming result;
        int[] res = new int[k];
        int index = 0;
        while(!q.isEmpty()) {
            res[index++] = q.poll().val;
        }
        return res;
    }

    private void dfs(TreeNode node, Queue<TreeNode> q, int target, int k) {
        if(node == null) {
            return;
        }
        dfs(node.left, q, target, k);

        if(q.size() < k) {
            q.offer(node);
        } else {
            TreeNode topNode = q.peek();
            if(Math.abs(topNode.val - target) > Math.abs(node.val - target)) {
                q.poll();
                q.offer(node);
            } else {
                return;
            }
        }

        dfs(node.right, q, target, k);
    }
}
