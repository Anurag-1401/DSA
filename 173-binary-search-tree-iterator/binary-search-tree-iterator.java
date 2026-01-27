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
class BSTIterator {
    private int index;
    List<Integer> inOrderList;
    
    public BSTIterator(TreeNode root) {
        int index = 0;
        inOrderList = new ArrayList<>();
        inOrder(root);
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;          
        inOrder(node.left);               
        inOrderList.add(node.val);             
        inOrder(node.right);                  
    }

    public int next() {
        return inOrderList.get(index++);
    }

    public boolean hasNext() {
        return index < inOrderList.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */