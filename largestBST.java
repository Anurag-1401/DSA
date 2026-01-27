/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {

    int max = 0;

    public int largestBST(TreeNode root) {
        helper(root);
        return max;
    }

    class Info {
        boolean isBst;
        int max, min, size;

        Info(boolean isBst, int max, int min, int size) {
            this.isBst = isBst;
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }

    private Info helper(TreeNode root) {

        if (root == null) {
            return new Info(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        Info left = helper(root.left);
        Info right = helper(root.right);

        if (left.isBst && right.isBst &&
            root.data > left.max && root.data < right.min) {

            int size = left.size + right.size + 1;
            max = Math.max(max, size);

            int mn = Math.min(root.data, left.min);
            int mx = Math.max(root.data, right.max);

            return new Info(true, mx, mn, size);
        }

        return new Info(false, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }
}
