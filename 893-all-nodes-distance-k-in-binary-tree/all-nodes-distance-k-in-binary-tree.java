/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> ans=new LinkedList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        foundAtDistance(root,target,k);
        return ans;
    }

    public void findChildrenAtKDistance(TreeNode root, int distance){
        if(root==null) return;

        if(distance<0)return;

        if(distance==0){
            ans.add(root.val);
            return;
        } else{
            findChildrenAtKDistance(root.left,distance-1);
            findChildrenAtKDistance(root.right,distance-1);
        }
    }

    public int foundAtDistance(TreeNode root,TreeNode target,int k){
        if(root==null) return 0;

        if(root.val==target.val){
            findChildrenAtKDistance(root,k);
            return 1;
        }

        int leftDistance=foundAtDistance(root.left,target,k);
        int rightDistance=foundAtDistance(root.right,target,k);

        if(leftDistance>0){
            if(leftDistance>k) return 0;

            else if(leftDistance==k){
                ans.add(root.val);
                return 0;
            }

            else{
                findChildrenAtKDistance(root.right, k-leftDistance-1);
                return leftDistance+1;
            }
        }else if(rightDistance>0){
            if(rightDistance>k)return 0;

            else if(rightDistance==k){
                ans.add(root.val);
                return 0;
            }

            else{
                findChildrenAtKDistance(root.left, k-rightDistance-1);
                return rightDistance+1;
            }
        }else{
            return 0;
        }
    }
}