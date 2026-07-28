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
    private static class NodeInfo {
        int col;
        int row;
        int val;

        NodeInfo(int col, int row, int val) {
            this.col = col;
            this.row = row;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        List<NodeInfo> nodeList = new ArrayList<>();
        
        dfs(root, 0, 0, nodeList);

        Collections.sort(nodeList, (a, b) -> {
            if (a.col != b.col) {
                return Integer.compare(a.col, b.col);
            }
            if (a.row != b.row) {
                return Integer.compare(a.row, b.row);
            }
            return Integer.compare(a.val, b.val);
        });

        int currentCol = nodeList.get(0).col;
        List<Integer> currentColumnList = new ArrayList<>();

        for (NodeInfo node : nodeList) {
            if (node.col != currentCol) {
                result.add(currentColumnList);
                currentColumnList = new ArrayList<>();
                currentCol = node.col;
            }
            currentColumnList.add(node.val);
        }
        result.add(currentColumnList);

        return result;
    }

    private void dfs(TreeNode root, int col, int row, List<NodeInfo> nodeList) {
        if (root == null) return;
        
        nodeList.add(new NodeInfo(col, row, root.val));
        
        dfs(root.left, col - 1, row + 1, nodeList);
        dfs(root.right, col + 1, row + 1, nodeList);
    }
}
