import java.util.*;

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

class Solution987 {

/**
 * This is using breadth first search
 */
    private Map<Integer, List<Node>> indexToNodes = new HashMap<>();
    int minIndex = Integer.MAX_VALUE;
    int maxIndex = Integer.MIN_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0, 0));
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                Node node = queue.poll();
                indexToNodes.putIfAbsent(node.col, new ArrayList<>());
                indexToNodes.get(node.col).add(node);

                minIndex = Math.min(minIndex, node.col);
                maxIndex = Math.max(maxIndex, node.col);

                if(node.treeNode.left != null) {
                    queue.offer(new Node(node.treeNode.left, node.row + 1, node.col - 1));
                }

                if(node.treeNode.right != null) {
                    queue.offer(new Node(node.treeNode.right, node.row + 1, node.col + 1));
                }
                size--;
            }
        }
        List<List<Integer>> res = new ArrayList<>(indexToNodes.size());

        for(int i = minIndex; i <= maxIndex; i++) {
            List<Node> nodes = indexToNodes.get(i);
            Collections.sort(nodes, (n1, n2) -> {
                if(n1.col != n2.col) {
                    return n1.col - n2.col;
                }
                return n1.treeNode.val - n2.treeNode.val;
            });
            res.add(nodes.stream().map(node -> node.treeNode.val).collect(Collectors.toList()));
        }
        return res;
    }
}

class Node {
    TreeNode treeNode;
    int row;
    int col;

    public Node(TreeNode treeNode, int row, int col) {
        this.treeNode = treeNode;
        this.row = row;
        this.col = col;
    }
}
