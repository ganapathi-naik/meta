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

class Solution314 {

/**
 * This is using depth first search
 */
    private Map<Integer, List<Integer>> indexToNodes = new HashMap<>();
    int minIndex = Integer.MAX_VALUE;
    int maxIndex = Integer.MIN_VALUE;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        verticalOrder(root, 0);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = minIndex; i <= maxIndex; i++) {
            List<Integer> orderAtIndex = indexToNodes.get(i);
            res.add(orderAtIndex);
        }
        return res;
    }

    private void verticalOrder(TreeNode node, int index) {
        if(node == null) {
            return;
        }
        List<Integer> nodes = indexToNodes.getOrDefault(index, new ArrayList<>());
        nodes.add(node.val);
        indexToNodes.put(index, nodes);
        minIndex = Math.min(index, minIndex);
        maxIndex = Math.max(index, maxIndex);
        verticalOrder(node.left, index - 1);
        verticalOrder(node.right, index + 1);
    }

/**
 * This is using breadth first search
 */
    private Map<Integer, List<Node>> indexToNodes = new HashMap<>();
    int minIndex = Integer.MAX_VALUE;
    int maxIndex = Integer.MIN_VALUE;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                Node node = queue.poll();
                indexToNodes.putIfAbsent(node.col, new ArrayList<>());
                indexToNodes.get(node.col).add(node);

                minIndex = Math.min(minIndex, node.col);
                maxIndex = Math.max(maxIndex, node.col);

                if(node.treeNode.left != null) {
                    queue.offer(new Node(node.treeNode.left, node.col - 1));
                }

                if(node.treeNode.right != null) {
                    queue.offer(new Node(node.treeNode.right, node.col + 1));
                }
                size--;
            }
        }
        List<List<Integer>> res = new ArrayList<>(indexToNodes.size());

        for(int i = minIndex; i <= maxIndex; i++) {
            List<Node> nodes = indexToNodes.get(i);
            res.add(nodes.stream().map(node -> node.treeNode.val).collect(Collectors.toList()));
        }
        return res;
    }
}

class Node {
    TreeNode treeNode;
    int col;

    public Node(TreeNode treeNode, int col) {
        this.treeNode = treeNode;
        this.col = col;
    }
}
