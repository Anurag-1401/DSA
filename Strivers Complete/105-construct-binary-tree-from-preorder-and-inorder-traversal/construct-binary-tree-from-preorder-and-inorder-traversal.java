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

// class Solution {
//     int preI = 0;
//     Map<Integer,Integer> map = new HashMap<>();

//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         for(int i=0;i<inorder.length;i++){
//             map.put(inorder[i],i);
//         }

//         return construct(preorder,0,inorder.length-1);
//     }

//     private TreeNode construct(int[] pre,int s,int e){
//         if(s>e) return null;

//         int rootVal = pre[preI++];
//         TreeNode root = new TreeNode(rootVal);

//         int idx = map.get(rootVal);

//         root.left = construct(pre,s,idx-1);
//         root.right = construct(pre,idx+1,e);

//         return root;
//     }
// }


class Solution {
    private int i=0;
    private int p=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(inorder,preorder,Integer.MIN_VALUE);
    }
    public TreeNode build(int[] inorder,int[] preorder,int stop){
        if(p>=preorder.length) return null;
        if(inorder[i]==stop){
            i++;
            return null;
        }
        TreeNode node=new TreeNode(preorder[p++]);
        node.left=build(inorder,preorder,node.val);
        node.right=build(inorder,preorder,stop);
        return node;
    }
}