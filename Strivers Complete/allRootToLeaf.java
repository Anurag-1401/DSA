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
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        List<Integer> path = new ArrayList<>();
        dfs(root,path,ans);

        return ans;
    }

    private void dfs(TreeNode root,List<Integer> path,List<List<Integer>> ans){
        if(root == null) return;

        path.add(root.data);

        if(root.left == null && root.right == null) ans.add(new ArrayList<>(path));
        else{
            dfs(root.left,path,ans);
            dfs(root.right,path,ans);
        }

        path.remove(path.size() - 1);
    }
}
