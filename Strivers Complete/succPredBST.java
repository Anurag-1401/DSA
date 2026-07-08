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
        int pre = -1;
        int suc = -1;
        TreeNode curr = root;

        while (curr != null && curr.data != key) {
            if (key < curr.data) {
                suc = curr.data;
                curr = curr.left;
            } else {
                pre = curr.data;
                curr = curr.right;
            }
        }

        if (curr == null) {
            return new ArrayList<>(List.of(pre, suc));
        }

        if (curr.left != null) {
            TreeNode temp = curr.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            pre = temp.data;
        }

        if (curr.right != null) {
            TreeNode temp = curr.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            suc = temp.data;
        }

        return new ArrayList<>(List.of(pre, suc));
    }
}

