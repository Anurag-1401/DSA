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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) return res;

        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        boolean leftToRight = true;

        while (!level.isEmpty()) {
            List<Integer> values = new ArrayList<>();
            List<TreeNode> next = new ArrayList<>();

            for (TreeNode node : level) {
                values.add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }

            if (!leftToRight) {
                Collections.reverse(values);
            }

            res.add(values);
            level = next;
            leftToRight = !leftToRight; 
        }
        return res;
    }
}
