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
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder,Integer.MAX_VALUE);
    }

    private TreeNode build(int[] pre,int bound){
        if(i == pre.length||pre[i]>bound) return null;

        TreeNode root = new TreeNode(pre[i++]);
        root.left = build(pre,root.val);
        root.right = build(pre,bound);

        return root;
    }
}