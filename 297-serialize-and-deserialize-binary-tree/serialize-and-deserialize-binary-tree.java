/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

   public List<Integer> serialize(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfsSerialize(root, res);
        return res;
    }

    private void dfsSerialize(TreeNode root, List<Integer> res) {
        if (root == null) {
            res.add(Integer.MAX_VALUE);
            return;
        }
        res.add(root.val);
        dfsSerialize(root.left, res);
        dfsSerialize(root.right, res);
    }

    public TreeNode deserialize(List<Integer> data) {
        return dfsDeserialize(data, new int[1]);
    }

    private TreeNode dfsDeserialize(List<Integer> data, int[] index) {
        int cur = data.get(index[0]++);
        if (cur == Integer.MAX_VALUE) return null;
        TreeNode root = new TreeNode(cur);
        root.left = dfsDeserialize(data, index);
        root.right = dfsDeserialize(data, index);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));