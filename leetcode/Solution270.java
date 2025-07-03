class Solution270 {
    public int closestValue(TreeNode root, double target) {
        double closestDistance = Integer.MAX_VALUE;
        int res = root.val;
        while(root != null) {
            double distance = Math.abs(root.val - target);
            if(distance < closestDistance || (closestDistance == distance && root.val < res)) {
                closestDistance = distance;
                res = root.val;
            }
            if(distance == 0) {
                return root.val;
            }
            if(root.val < target)  {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return res;
    }
}


// Target is interger
class Solution270 {
    public int closestValue(TreeNode root, int target) {
        int closestDistance = Integer.MAX_VALUE;
        int res = root.val;
        while(root != null) {
            int distance = Math.abs(root.val - target);
            if(distance < closestDistance || (closestDistance == distance && root.val < res)) {
                closestDistance = distance;
                res = root.val;
            }
            if(distance == 0) {
                return root.val;
            }
            if(root.val < target)  {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return res;
    }
}
