class Solution {
    boolean checkChildrenSum(TreeNode root) { 
        if(root == null) return true;

        if(root.left ==  null && root.right == null) return true;

        int left = (root.left!=null) ? root.left.val : 0;
        int right = (root.right!=null) ? root.right.val : 0;
    
        return (root.val == left+right) && checkChildrenSum(root.left) 
                && checkChildrenSum(root.right);
    }
}
