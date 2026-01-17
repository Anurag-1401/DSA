/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }

            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }

        Set<TreeNode> visited = new HashSet<>();
        q.clear();
        q.offer(target);
        visited.add(target);

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            if (dist == k) break;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }

                if (parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    visited.add(parent.get(curr));
                    q.offer(parent.get(curr));
                }
            }
            dist++;
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }

        return ans;
    }
}
