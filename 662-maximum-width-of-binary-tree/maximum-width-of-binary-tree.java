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

    class Pair{
        TreeNode node;
        long i;

        Pair(TreeNode node,long i){
            this.node = node;
            this.i = i;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));

        int maxWd = 0;

        while(!q.isEmpty()){
            int size = q.size();
            long minI = q.peek().i;
            long first =0,last = 0;

            for(int i=0;i<size;i++){
                Pair curr = q.poll();
                long currI = curr.i - minI;

                if(i == 0) first = currI;
                if(i == size-1) last = currI;

                if(curr.node.left!=null) q.offer(new Pair(curr.node.left,2*currI+1));
                if(curr.node.right!=null) q.offer(new Pair(curr.node.right,2*currI+2));
            }
            maxWd = Math.max(maxWd,(int)(last-first+1));
        }    
        return maxWd;
    }
}