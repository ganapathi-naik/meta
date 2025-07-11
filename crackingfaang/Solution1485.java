class Solution {
    private Map<Node, NodeCopy> nodeToCopyMapping;

    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root == null) {
            return null;
        }
        nodeToCopyMapping = new HashMap<>();

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            Node node = q.poll();
            nodeToCopyMapping.putIfAbsent(node, new NodeCopy(node.val));
            NodeCopy newNode = nodeToCopyMapping.get(node);

            if(node.random != null) {
                nodeToCopyMapping.putIfAbsent(node.random, new NodeCopy(node.random.val));
                newNode.random = nodeToCopyMapping.get(node.random);
            }

            if(node.left != null) {
                nodeToCopyMapping.putIfAbsent(node.left, new NodeCopy(node.left.val));
                q.offer(node.left);
                newNode.left = nodeToCopyMapping.get(node.left);
            }

            if(node.right != null) {
                nodeToCopyMapping.putIfAbsent(node.right, new NodeCopy(node.right.val));
                q.offer(node.right);
                newNode.right = nodeToCopyMapping.get(node.right);
            }
        }
        return nodeToCopyMapping.get(root);
    }
}
