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
class Solution {
    int max = Integer.MIN_VALUE;

    private int cal(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(cal(root.left),0);
        int right = Math.max(cal(root.right),0);

        int sum = root.val + left + right;

        max = Math.max(max,sum);

        return root.val + Math.max(left,right);
    }

    public int maxPathSum(TreeNode root) {
        cal(root);
        return max;
    }
}