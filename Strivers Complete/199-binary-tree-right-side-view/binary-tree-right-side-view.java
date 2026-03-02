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
//     public List<Integer> rightSideView(TreeNode root) {

//         List<Integer> ans = new ArrayList<>();
//         if (root == null) return ans;

//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);

//         while (!q.isEmpty()) {
//             int size = q.size();

//             for (int i = 0; i < size; i++) {
//                 TreeNode curr = q.poll();

//                 if (i == size - 1) {
//                     ans.add(curr.val);
//                 }

//                 if (curr.left != null) q.offer(curr.left);
//                 if (curr.right != null) q.offer(curr.right);
//             }
//         }
//         return ans;
//     }
// }



class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }
    void dfs(TreeNode root, int d, List<Integer> ans) {
        if (root == null) return;

        if (d == ans.size()) ans.add(root.val);

        dfs(root.right, d + 1, ans);

        dfs(root.left, d + 1, ans);
    }
}