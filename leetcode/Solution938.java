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
class Solution938 {
    int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root, low, high);
        return sum;
    }

    void inorder(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }
        if (node.val > low) {
            inorder(node.left, low, high);
        }
        if (node.val >= low && node.val <= high) {
            sum += node.val;
        }
        if (node.val < high) {
            inorder(node.right, low, high);
        }
    }
}

//Using iterative approach
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
class Solution938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return -1;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.val > low) {
                stack.push(node.left);
            }

            if(node.val >= low && node.val <= high) {
                sum += node.val;
            }

            if(node.val < high) {
                stack.push(node.right);
            }
        }
        return sum;
    }
}

/**
Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
Note: At most 10^4 calls will be made to rangeSumBST.
 */

class Solution938 {
    List<Integer> nodes;
    List<Integer> prefixSum;
    public Solution938(TreeNode root) {
        nodes = new ArrayList<>();
        prefixSum = new ArrayList<>();
        inorder(root);
    }

    private void inorder(TreeNode node) {
        if(node == null) {
            return;
        }
        inorder(node.left);
        nodes.add(node.val);
        if(prefixSum.size() == 0) {
            prefixSum.add(node.val);
        } else {
            prefixSum.add(prefixSum.get(prefixSum.size() - 1) + node.val);
        }
        inorder(node.right);
    }

    public int rangeSumBST(int low, int high) {
        int leftBoundary = findLeftBoundary(low);
        int rightBoundary = findRightBoundary(high);

        if(leftBoundary == 0) {
            return prefixSum.get(rightBoundary);
        } else {
            return prefixSum.get(rightBoundary) - prefixSum.get(leftBoundary - 1);
        }
    }

    private int findLeftBoundary(int target) {
        int left = 0, right = nodes.size() - 1;
        int res = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nodes.get(mid) >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1
            }
        }
        return res;
    }

    private int findRightBoundary(int target) {
        int left = 0, right = nodes.size() - 1;
        int res = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nodes.get(mid) <= target) {
                res = mid;
                left = mid + 1
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
