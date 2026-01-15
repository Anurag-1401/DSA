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
//     List<Integer> res = new ArrayList<>();
//     public List<Integer> postorderTraversal(TreeNode root) {
//         if(root == null) return res;

//         postorderTraversal(root.left);
//         postorderTraversal(root.right);
//         res.add(root.val);

//         return res;
//     }
// }

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(root);

        while (!st1.isEmpty()) {
            TreeNode curr = st1.pop();
            st2.push(curr);

            if (curr.left != null) st1.push(curr.left);
            if (curr.right != null) st1.push(curr.right);
        }

        while (!st2.isEmpty()) {
            res.add(st2.pop().val);
        }

        return res;
    }
}
