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
public class Node {
    int mx;
    int mn;
    int totalSum;

    public Node(int mx, int mn, int totalSum) {
        this.mx = mx;
        this.mn = mn;
        this.totalSum = totalSum;
    }
}
class Solution {
    int ans=0;
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return ans;
    }

    Node traverse(TreeNode curr) {
        if(curr==null) return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

        Node left = traverse(curr.left);
        Node right = traverse(curr.right);

        if(curr.val>left.mx && curr.val<right.mn) {
            int currTotalSum = left.totalSum+right.totalSum+curr.val;
            ans=Math.max(ans, currTotalSum);
            return new Node(Math.max(right.mx, curr.val), Math.min(left.mn,curr.val), currTotalSum);
        } else {
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

    }
}
