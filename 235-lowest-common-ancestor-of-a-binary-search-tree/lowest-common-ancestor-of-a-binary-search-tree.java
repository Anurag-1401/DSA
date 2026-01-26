/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while(node != null) {
            int val = node.val;
            if(val < p.val && val < q.val) node = node.right;
            else if(val > p.val && val > q.val) node = node.left;
            else return node;
        }
        return null;
    }
}