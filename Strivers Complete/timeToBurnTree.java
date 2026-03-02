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

    int maxTime = 0;

    public int timeToBurnTree(TreeNode root, int start) {
        burn(root, start);
        return maxTime;
    }

    private int burnChildren(TreeNode node) {
        if (node == null) return 0;

        int left = burnChildren(node.left);
        int right = burnChildren(node.right);

        return 1 + Math.max(left, right);
    }

    private int burn(TreeNode root, int start) {
        if (root == null) return -1;

        if (root.data == start) {
            maxTime = Math.max(maxTime, burnChildren(root) - 1);
            return 1;
        }

        int leftDist = burn(root.left, start);
        int rightDist = burn(root.right, start);

        if (leftDist != -1) {
            int rightHeight = burnChildren(root.right);
            maxTime = Math.max(maxTime, leftDist + rightHeight);
            return leftDist + 1;
        }

        if (rightDist != -1) {
            int leftHeight = burnChildren(root.left);
            maxTime = Math.max(maxTime, rightDist + leftHeight);
            return rightDist + 1;
        }

        return -1;
    }
}
