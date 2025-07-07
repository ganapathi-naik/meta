import java.util.*;

class Solution536 {
    public TreeNode str2tree(String s) {
        if(s == null || s.equals("")) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '-') {
                int val = 0;
                i = i + 1;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = (val * 10) + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                stack.push(new TreeNode(-1 * val));
            } else if(Character.isDigit(s.charAt(i))) {
                int val = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = (val * 10) + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                stack.push(new TreeNode(val));
            } else if(s.charAt(i) == ')') {
                TreeNode node = stack.pop();
                TreeNode parentNode = stack.peek();
                if(parentNode.left == null) {
                    parentNode.left = node;
                } else {
                    parentNode.right = node;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        TreeNode root = new Solution536().str2tree("4(2(3)(1))(6(5))");
        printBinaryTree(root);
    }

    public static void printBinaryTree(TreeNode root) {
        if (root == null) {
            System.out.println("(empty tree)");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Print all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    System.out.print(node.val + " ");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println(); // Move to next line after each level
        }
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
/**
 4(2(3)(1))(6(5))

 */
