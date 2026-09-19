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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        solve(root, new StringBuilder(), ans);
        return ans;
    }

    public static void solve(TreeNode root, StringBuilder temp, List<String> ans){
        if(root == null){
            return;
        }

        int len = temp.length();
        temp.append(root.val);
        
        if(root.left == null && root.right == null){
            ans.add(temp.toString());
        }else{
            temp.append("->");
            solve(root.left, temp, ans);
            solve(root.right, temp, ans);
        }

        temp.setLength(len);
    }
}