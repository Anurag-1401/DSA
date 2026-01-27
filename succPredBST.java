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
    List<Integer> succPredBST(TreeNode root, int key) {
        int pre = -1,suc = -1;
        
        TreeNode curr = root;

        while(curr != null && curr.data != key){
            if(key < root.val) {
                suc = curr.data;
                curr = curr.left;
            }else {
                pre = curr.data;
                curr  = curr.right;
            }

            if(curr == null) return new ArrayList<>(List.of(pre,suc));

            TreeNode temp= curr.left;

            while(temp!=null){
                pre = temp.data;
                temp = temp.right;
            }

            temp=  curr.right;
            while(temp!=null){
                suc = temp.data;
                temp = temp.left;
            }

            return new ArrayList<>(List.of(pre,suc));
        }
    }
}
