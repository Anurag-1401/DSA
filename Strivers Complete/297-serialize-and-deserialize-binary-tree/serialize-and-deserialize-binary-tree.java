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

   public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    dfsSerialize(root, sb);
    return sb.toString();
}

private void dfsSerialize(TreeNode root, StringBuilder sb) {
    if (root == null) {
        sb.append("#,");
        return;
    }

    sb.append(root.val).append(",");
    dfsSerialize(root.left, sb);
    dfsSerialize(root.right, sb);
    }   

    public TreeNode deserialize(String data) {
    String[] arr = data.split(",");
    return dfsDeserialize(arr, new int[1]);
}

private TreeNode dfsDeserialize(String[] arr, int[] index) {

    if (arr[index[0]].equals("#")) {
        index[0]++;
        return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(arr[index[0]++]));
    root.left = dfsDeserialize(arr, index);
    root.right = dfsDeserialize(arr, index);

    return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));