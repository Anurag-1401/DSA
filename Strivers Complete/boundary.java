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
    List<Integer> res = new ArrayList<>();
    public List<Integer> boundary(TreeNode root) {
        if(root == null) return res;

        if(!isLeaf(root)) res.add(root.data);

        addLeftB(root.left);
        addL(root);
        addRightB(root.right);

        return res;
    }

    private boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }

    private void addLeftB(TreeNode root){
        while(root!=null){
            if(!isLeaf(root)) res.add(root.data);

            if(root.left!=null) root = root.left;
            else root = root.right;
        }
    }

    private void addL(TreeNode root){
        if(root == null) return;

        if(isLeaf(root)){
            res.add(root.data);
            return;
        }

        addL(root.left);
        addL(root.right);
    }

    private void addRightB(TreeNode root){
        Stack<Integer> st = new Stack<>();

        while(root!=null){
            if(!isLeaf(root)) st.push(root.data);

            if(root.right != null) root = root.right;
            else root = root.left;
        }

        while(!st.isEmpty()) res.add(st.pop());
    }
}
