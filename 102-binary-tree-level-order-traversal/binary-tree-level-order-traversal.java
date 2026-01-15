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
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> res  = new ArrayList<>();

//         if(root == null) return res;

//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);

//         while(!q.isEmpty()){
//             int size = q.size();
//             List<Integer> level = new ArrayList<>();

//             for(int i=0;i<size;i++){
//                 TreeNode curr = q.poll();

//                 level.add(curr.val);

//                 if (curr.left != null) q.add(curr.left);
//                 if (curr.right != null) q.add(curr.right);
//             }
//             res.add(level);
//         }
//         return res;
//     }
// }



class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> output = new ArrayList<>();
		levelOrderHelper(output, root, 0);
		return output;
	}
	
	public void levelOrderHelper(List<List<Integer>> output, TreeNode root, int level) {
		if (root == null) {
            return;
        } else {
            if (level >= output.size()) {
                output.add(new ArrayList<>());
            }   
            output.get(level).add(root.val);
            levelOrderHelper(output, root.left, level + 1);
            levelOrderHelper(output, root.right, level + 1);
        }
	}
}