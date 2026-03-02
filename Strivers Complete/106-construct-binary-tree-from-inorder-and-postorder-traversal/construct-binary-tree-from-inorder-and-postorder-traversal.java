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
    int postI;
    Map<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postI = postorder.length - 1;

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return construct(postorder,0,inorder.length-1);
    }

    private TreeNode construct(int[] post,int s,int e){
        if(s>e) return null;

        int rootVal = post[postI--];
        TreeNode root = new TreeNode(rootVal);

        int idx = map.get(rootVal);

        root.right = construct(post,idx+1,e);
        root.left = construct(post,s,idx-1);

        return root;
    }
}