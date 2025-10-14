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
    int preIndex;
    Map<Integer,Integer> inMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<>();
        preIndex = 0;

        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }

        return build(preorder,0,inorder.length-1);
    }
    private TreeNode build(int[] preorder,int start , int end){
        if(start > end) return null;

        int val = preorder[preIndex++];
        TreeNode tree = new TreeNode(val);

        int index = inMap.get(val);

        tree.left = build(preorder,start,index-1);
        tree.right = build(preorder,index+1,end);

        return tree;
    }
}